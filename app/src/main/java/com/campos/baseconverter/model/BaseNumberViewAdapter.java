package com.campos.baseconverter.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.campos.baseconverter.R;
import com.campos.baseconverter.app.App;

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
        defineLabelText(holder, position);
        holder.getField().setText(numArr[position].getValue());
        holder.getLbl().setAnimation(loadAnim());
        holder.getField().setAnimation(loadAnim());
    }

    private void defineLabelText(BaseNumberViewHolder holder, int position) {
        switch (App.numSchemeCode) {
            case 0: // Show Bases (ex: Base 02)
                holder.getLbl().setText(numArr[position].getBase().toTitle());
                break; // Show Names (ex: Binary)
            case 1:
                holder.getLbl().setText(numArr[position].getBase().getName());
                break;
            default: // Display Default
                if (numArr.length == 4) {
                    holder.getLbl().setText(numArr[position].getBase().getName());
                } else {
                    holder.getLbl().setText(numArr[position].getBase().toTitle());
                }
        }
    }

    private Animation loadAnim() {
        return AnimationUtils.loadAnimation(context, R.anim.anim_fade_trans);
    }
}
