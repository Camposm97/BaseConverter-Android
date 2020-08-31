package com.campos.baseconverter.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.campos.baseconverter.R;

public class BaseNumberViewAdapter extends RecyclerView.Adapter<BaseNumberViewHolder> {
    private Context context;
    private BaseNumber[] numArr;
    private String[] lblArr;
    private String[] resultArr;

//    public BaseNumberViewAdapter(Context context, String[] lblArr) {
//        this.context = context;
//        this.lblArr = lblArr;
//        this.resultArr = null;
//    }
//
//    public BaseNumberViewAdapter(Context context, String[] lblArr, String[] resultArr) {
//        this.context = context;
//        this.lblArr = lblArr;
//        this.resultArr = resultArr;
//    }

    public BaseNumberViewAdapter(Context context, BaseNumber[] numArr) {
        this.context = context;
        this.numArr = numArr;
    }

    @NonNull
    @Override
    public BaseNumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.base_output_layout, parent, false);
        return new BaseNumberViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return numArr.length;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseNumberViewHolder holder, int position) {
        // Put animations here
        holder.getLbl().setText(Base.toTitle(numArr[position].getBase()));
        holder.getLbl().setAnimation(AnimationUtils.loadAnimation(context, R.anim.anim_fade_scale));
        holder.getField().setText(numArr[position].getValue());
        holder.getField().setAnimation(AnimationUtils.loadAnimation(context, R.anim.anim_fade_scale));
//        if (resultArr != null) {
//            holder.getField().setText(resultArr[position]);
//        } else {
//            holder.getField().setText("");
//        }
    }
}
