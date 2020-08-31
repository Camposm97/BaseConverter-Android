package com.campos.baseconverter.model;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.campos.baseconverter.R;
import com.campos.baseconverter.view.activities.ShowAllBasesActivity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static com.campos.baseconverter.util.Tag.TAG;

public class HistoryViewAdapter extends RecyclerView.Adapter<HistoryViewAdapter.HistoryViewHolder> {
    private Context context;
    private List<BaseNumber> numList;

    public HistoryViewAdapter(Context context, List<BaseNumber> numList) {
        this.context = context;
        this.numList = numList;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.history_view_item, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HistoryViewHolder holder, final int position) {
        holder.tv.setText(numList.get(position).toSpanString());
        holder.tv.setAnimation(AnimationUtils.loadAnimation(context, R.anim.anim_fade_scale));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Layout Clicked! " + holder.tv.getText());
                Intent intent = new Intent(context, ShowAllBasesActivity.class);
                intent.putExtra("target", numList.get(position));
                context.startActivity(intent);
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
