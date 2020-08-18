package com.campos.baseconverter.model;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public interface BaseTextChangeListener extends TextWatcher {

    public BaseTextChangeListener(EditText tf) {
        this.tf = tf;
        this.strBefore = "";
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        this.strBefore = s.toString();
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String str = s.toString();
        if (!str.isEmpty()) {
            for (char c : str.toCharArray()) {
                try {
                    if (c != '0' || c != '1') {
                        tf.setText(strBefore);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
