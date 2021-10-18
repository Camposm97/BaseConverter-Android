package com.campos.baseconverter.model.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.campos.baseconverter.R;
import com.campos.baseconverter.model.UserHistory;
import com.campos.baseconverter.view.activity.ShowResultsActivity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryViewAdapter extends RecyclerView.Adapter<HistoryViewAdapter.HistoryViewHolder> {
    private Context context;
    private List<UserHistory.HistoryItem> list;

    public HistoryViewAdapter(Context context, List<UserHistory.HistoryItem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_history_cardview, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        holder.tv.setText(list.get(position).getInput().toSpanString());
        holder.tv.setAnimation(AnimationUtils.loadAnimation(context, R.anim.anim_fade_scale));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String s1 = "selected_item";
                Intent intent = new Intent(context, ShowResultsActivity.class);
                intent.putExtra(s1, list.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.history_item);
            tv.setTextSize(18);
        }
    }
}
