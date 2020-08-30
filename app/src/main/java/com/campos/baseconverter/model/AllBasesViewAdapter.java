package com.campos.baseconverter.model;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.campos.baseconverter.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.campos.baseconverter.util.Tag.TAG;

public class AllBasesViewAdapter extends RecyclerView.Adapter<AllBasesViewAdapter.AllBasesViewHolder> {
    private Context context;
    private List<String> list;
    public AllBasesViewAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AllBasesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.base_output_layout, parent, false);
        return new AllBasesViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull AllBasesViewHolder holder, int position) {
        // Put animations here
        holder.tv.setText(list.get(position));
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
