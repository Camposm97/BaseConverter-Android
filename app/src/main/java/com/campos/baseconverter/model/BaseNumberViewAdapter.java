package com.campos.baseconverter.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.campos.baseconverter.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BaseNumberViewAdapter extends RecyclerView.Adapter<BaseNumberViewAdapter.BaseNumberViewHolder> {
    private Context context;
    private List<String> list;

    public BaseNumberViewAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
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
        return list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull BaseNumberViewHolder holder, int position) {
        // Put animations here
        holder.tv.setText(list.get(position));
    }

    public class BaseNumberViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        private EditText tf;

        public BaseNumberViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.output_label);
            tf = itemView.findViewById(R.id.output_field);
        }
    }
}
