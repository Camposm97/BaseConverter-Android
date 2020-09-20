package com.campos.baseconverter.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.campos.baseconverter.R;
import com.campos.baseconverter.app.App;
import com.campos.baseconverter.util.MyUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BaseNumberViewAdapter extends RecyclerView.Adapter<BaseNumberViewHolder> {
    private Context context;
    private BaseNumber[] numArr;

    public BaseNumberViewAdapter(Context context, BaseNumber[] numArr) {
        this.context = context;
        this.numArr = numArr;
    }

    @NonNull
    @Override
    public BaseNumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_base_num_output, parent, false);
        return new BaseNumberViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return numArr.length;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseNumberViewHolder holder, int position) {
        defineLabelText(holder, position);
        defineFieldText(holder, position);
        holder.getLbl().setAnimation(loadAnim());
        holder.getField().setAnimation(loadAnim());
    }

    private void defineFieldText(BaseNumberViewHolder holder, int i) {
        String value = numArr[i].getValue();
        if (i == 0 && !value.isEmpty()) { // Format bin string then display
            String binStr = numArr[i].getValue();
            holder.getField().setText(MyUtils.formatBinStr(binStr));
        } else { // Display
            holder.getField().setText(value);
        }
    }

    private void defineLabelText(BaseNumberViewHolder holder, int i) {
        switch (App.numSchemeCode) {
            case 0: // Show Bases (ex: Base 02)
                holder.getLbl().setText(numArr[i].getBase().toTitle());
                break; // Show Names (ex: Binary)
            case 1:
                holder.getLbl().setText(numArr[i].getBase().getName());
                break;
            default: // Display Default
                if (numArr.length == 4) {
                    holder.getLbl().setText(numArr[i].getBase().getName());
                } else {
                    holder.getLbl().setText(numArr[i].getBase().toTitle());
                }
        }
    }

    private Animation loadAnim() {
        return AnimationUtils.loadAnimation(context, R.anim.anim_fade_trans);
    }
}
