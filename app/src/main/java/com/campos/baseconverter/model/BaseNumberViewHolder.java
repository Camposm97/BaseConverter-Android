package com.campos.baseconverter.model;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.campos.baseconverter.R;

public class BaseNumberViewHolder extends RecyclerView.ViewHolder {
    private TextView tv;
    private EditText tf;

    public BaseNumberViewHolder(@NonNull View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.output_label);
        tf = itemView.findViewById(R.id.output_field);
    }

    public TextView getTv() {
        return tv;
    }

    public EditText getTf() {
        return tf;
    }
}
