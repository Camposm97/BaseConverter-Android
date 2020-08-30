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

public class AllBasesViewAdapter extends RecyclerView.Adapter<AllBasesViewAdapter.AllBasesViewHolder> {
    private Context context;
    private String[] strings;
    public AllBasesViewAdapter(Context context, String[] strings) {
        this.context = context;
        this.strings = strings;
    }

    @NonNull
    @Override
    public AllBasesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.history_view_item, parent, false);
        return new AllBasesViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return strings.length;
    }

    @Override
    public void onBindViewHolder(@NonNull AllBasesViewHolder holder, int position) {
        // Put animations here
        holder.tv.setText(strings[position]);
    }

    public class AllBasesViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        private EditText tf;

        public AllBasesViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.output_label);
            tf = itemView.findViewById(R.id.output_field);
        }
    }

}
