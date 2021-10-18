package com.campos.baseconverter.model.adapter;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.campos.baseconverter.R;

public class BaseNumberViewHolder extends RecyclerView.ViewHolder {
    private TextView lbl;
    private TextView field;

    public BaseNumberViewHolder(@NonNull View itemView) {
        super(itemView);
        lbl = itemView.findViewById(R.id.output_label);
        field = itemView.findViewById(R.id.output_field);
    }

    public TextView getLbl() {
        return lbl;
    }

    public TextView getField() {
        return field;
    }
}
