package com.campos.baseconverter.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.campos.baseconverter.R;

import java.util.List;

public class BaseNumberViewAdapter extends RecyclerView.Adapter<BaseNumberViewHolder> {
    private Context context;
    private List<String> listLbl;
    private List<String> listTf;

    public BaseNumberViewAdapter(Context context, List<String> listLbl) {
        this.context = context;
        this.listLbl = listLbl;
        this.listTf = null;
    }

    public BaseNumberViewAdapter(Context context, List<String> listLbl, List<String> listTf) {
        this.context = context;
        this.listLbl = listLbl;
        this.listTf = listTf;
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
        return listLbl.size();
    }

    @Override
    public void onBindViewHolder(@NonNull BaseNumberViewHolder holder, int position) {
        // Put animations here
        holder.getLbl().setText(listLbl.get(position));
        holder.getLbl().setAnimation(AnimationUtils.loadAnimation(context, R.anim.anim_fade_trans));
        holder.getField().setAnimation(AnimationUtils.loadAnimation(context, R.anim.anim_fade_trans));
        if (listTf != null) {
            holder.getField().setText(listTf.get(position ));
        } else {
            holder.getField().setText("");
        }
    }
}
