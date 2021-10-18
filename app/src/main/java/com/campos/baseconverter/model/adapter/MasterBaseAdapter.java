package com.campos.baseconverter.model.adapter;

import static com.campos.baseconverter.util.AlertUtils.showShortToast;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.campos.baseconverter.R;
import com.campos.baseconverter.app.App;
import com.campos.baseconverter.model.BaseInputDialogBuilder;
import com.campos.baseconverter.model.UserHistory;
import com.campos.baseconverter.model.num.Base;
import com.campos.baseconverter.model.num.BaseConverter;
import com.campos.baseconverter.model.num.BaseNumber;
import com.campos.baseconverter.model.num.SignFormat;
import com.campos.baseconverter.model.num.SignedBinaryConverter;
import com.campos.baseconverter.util.MyUtils;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MasterBaseAdapter extends RecyclerView.Adapter<MasterBaseViewHolder> {
    private Context context;
    private BaseNumber[] numArr;
    private AdapterType type;
    private RecyclerView rv;

    /*
     * TODO Finish implementing this adapter
     * Based on the adapter type determined how the adapter functions
     */

    public MasterBaseAdapter(Context context, AdapterType type, BaseNumber[] numArr, RecyclerView rv) {
        this.context = context;
        this.type = type;
        this.numArr = numArr;
        this.rv = rv;
    }

    @NonNull
    @Override
    public MasterBaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_base_num_output, parent, false);
        return new MasterBaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MasterBaseViewHolder holder, int i) {
        initHolderTitle(holder, i);
        initHolderValue(holder, i);
        holder.onTitleClicked(e -> {
            Base convertFromBase = numArr[i].getBase();
            BaseInputDialogBuilder dialogBuilder =
                    new BaseInputDialogBuilder(context, convertFromBase);
            if (type.equals(AdapterType.SIGNED_BINARY)) {
                dialogBuilder.setTitle("Converting from " + holder.getTitle());
                dialogBuilder.setPositiveButton("Convert", (dialog, which) -> {
                    String value = dialogBuilder.getInput();
                    BaseNumber baseNumber = new BaseNumber(convertFromBase, value);
                    SignFormat format = null;

                    switch(i) {
                        case 0:
                            format = SignFormat.Decimal;
                            break;
                        case 1:
                            format = SignFormat.Sign_Magnitude;
                            break;
                        case 2:
                            format = SignFormat.Ones_Complement;
                            break;
                        case 3:
                            format = SignFormat.Twos_Complement;
                            break;
                    }

                    SignedBinaryConverter signedBinaryConverter = new SignedBinaryConverter(baseNumber, format);
                    BaseNumber[] resultsArr = signedBinaryConverter.getResults();
                    if (resultsArr != null) {
                        UserHistory.getHistory().add(baseNumber, resultsArr);
                        UserHistory.save(context);

                        rv.setAdapter(new MasterBaseAdapter(context, type, resultsArr, rv));
                    } else {
                        showShortToast(context, "Invalid Input!");
                    }
                });
                dialogBuilder.setNegativeButton("Cancel", null);
                dialogBuilder.show();
            }
        });
        holder.setAnimation(AnimationUtils.loadAnimation(context, R.anim.anim_fade_trans));
    }

    private void initHolderTitle(MasterBaseViewHolder holder, int i) {
        if (type.equals(AdapterType.SIGNED_BINARY)) {
            switch (i) { // If type is Signed Binary, then whatever int i equals determines what title for each MasterViewHolder
                case 0:
                    holder.setTitle("Decimal");
                    break;
                case 1:
                    holder.setTitle("Sign/Magnitude");
                    break;
                case 2:
                    holder.setTitle("One's Complement");
                    break;
                case 3:
                    holder.setTitle("Two's Complement");
                    break;
            }
        } else if (type.equals(AdapterType.MAIN_BASES) || type.equals(AdapterType.ALL_BASES)) {
            switch (App.numSchemeCode) {
                case 0: // Show Bases (ex: Base 02)
                    holder.setTitle((numArr[i].getBase().toTitle()));
                    break; // Show Names (ex: Binary)
                case 1:
                    holder.setTitle((numArr[i].getBase().getFormalName()));
                    break;
                default: // Display Default
                    if (numArr.length == 4) {
                        holder.setTitle(numArr[i].getBase().getFormalName());
                    } else {
                        holder.setTitle(numArr[i].getBase().toTitle());
                    }
            }
        } else if (type.equals(AdapterType.IEEE754)) {
            // TODO What happens when the adapter type is IEEE754
        }
    }

    private void initHolderValue(MasterBaseViewHolder holder, int i) {
        String value = numArr[i].getValue();
        if (numArr[i].isValidAndIs(Base.BASE_2)) { // Format bin string then display
            holder.setValue(MyUtils.formatBinStr(value));
        } else { // Display
            holder.setValue(value);
        }
    }

    @Override
    public int getItemCount() {
        return numArr.length;
    }
}
