package com.campos.baseconverter.model.adapter;

import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.campos.baseconverter.R;

public class MasterBaseViewHolder extends RecyclerView.ViewHolder {
    private TextView lbl;
    private TextView field;

    public MasterBaseViewHolder(@NonNull View itemView) {
        super(itemView);
        lbl = itemView.findViewById(R.id.output_label);
        field = itemView.findViewById(R.id.output_field);
    }

    public void onTitleClicked(View.OnClickListener clickListener) {
        lbl.setOnClickListener(clickListener);
    }

    public String getTitle() {
        return lbl.getText().toString();
    }

    public void setTitle(String s) {
        lbl.setText(s);
    }

    public void setValue(String s) {
        field.setText(s);
    }

    public void setAnimation(Animation a) {
        lbl.setAnimation(a);
        field.setAnimation(a);
    }
}
