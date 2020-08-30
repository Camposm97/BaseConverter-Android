package com.campos.baseconverter.model;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.campos.baseconverter.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static com.campos.baseconverter.util.Tag.TAG;

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
        holder.tv.setText(numList.get(position).toSpanString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Layout Clicked!");
            }
        });
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
