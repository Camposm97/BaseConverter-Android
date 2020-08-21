package com.campos.baseconverter.model;

import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import com.campos.baseconverter.util.MyUtils;

public class BaseOnKeyListener implements View.OnKeyListener {
    private BaseConverter bc;
    private EditText tf;
    private EditText[] arr;

    public BaseOnKeyListener(EditText tf, Base convertFrom, EditText[] arr) {
        this.bc = new BaseConverter(tf.getText().toString(), convertFrom);
        this.tf = tf;
        this.arr = arr;
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (isInfoValid()) {
            displayResults(bc.getMainResults());
        }
        return false;
    }

    private void displayResults(String[] results) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != tf) {
            arr[i].setText(results[i]);
            }
        }
    }

    public boolean isInfoValid() {
        return MyUtils.isValidBase(bc.getConvertFrom(), tf.getText().toString());
    }
}
