package com.campos.baseconverter.model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AllBasesViewAdapter extends RecyclerView.Adapter<AllBasesViewHolder> {
    private Context context;
    public AllBasesViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public AllBasesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        
        return null;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull AllBasesViewHolder holder, int position) {

    }

    private class AllBasesViewHolder extends RecyclerView.ViewHolder {


        public AllBasesViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
