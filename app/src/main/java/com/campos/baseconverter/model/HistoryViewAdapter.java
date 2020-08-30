package com.campos.baseconverter.model;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.campos.baseconverter.R;
import com.campos.baseconverter.util.Tag;

import java.util.List;

public class HistoryViewAdapter extends RecyclerView.Adapter<HistoryViewAdapter.HistoryViewHolder> {
    private List<BaseNumber> numList;

    public HistoryViewAdapter(List<BaseNumber> numList) {
        this.numList = numList;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.history_view_item, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        Log.d(Tag.TAG, "onBindViewHolder() called");
        holder.tv.setText(numList.get(position).toSpanString());
    }

    @Override
    public int getItemCount() {
        return numList.size();
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.history_item);
        }
    }
}
