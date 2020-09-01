package com.campos.baseconverter.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.campos.baseconverter.R;

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
        View view = inflater.inflate(R.layout.base_output_layout, parent, false);
        return new BaseNumberViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return numArr.length;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseNumberViewHolder holder, int position) {
        holder.getLbl().setText(numArr[position].getBase().toTitle());
//        holder.getLbl().setText(numArr[position].getBase().getName());
        holder.getField().setText(numArr[position].getValue());
        holder.getLbl().setAnimation(loadAnim());
        holder.getField().setAnimation(loadAnim());
    }

    private Animation loadAnim() {
        return AnimationUtils.loadAnimation(context, R.anim.anim_fade_trans);
    }
}
