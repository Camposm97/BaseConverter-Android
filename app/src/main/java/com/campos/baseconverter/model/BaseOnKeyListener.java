package com.campos.baseconverter.model;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import com.campos.baseconverter.util.MyUtils;

import java.util.Arrays;

public class BaseOnKeyListener implements View.OnKeyListener {
    private static final String TAG = BaseOnKeyListener.class.getSimpleName();
    private EditText tf;
    private EditText[] arr;
    private Base convertFrom;


    public BaseOnKeyListener(EditText tf, EditText[] arr, Base convertFrom) {
        this.tf = tf;
        this.arr = arr;
        this.convertFrom = convertFrom;
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        start();
        return false;
    }

    public void start() {
        if (isInfoValid()) {
            BaseConverter bc = new BaseConverter(tf.getText().toString(), convertFrom);
            displayResults(bc.getMainResults());
        } else {
            displayResults("N\\A", "N\\A", "N\\A", "N\\A");
        }
    }

    public void displayResults(String... results) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != tf) {
                arr[i].setText(results[i]);
            }
        }
    }

    public boolean isInfoValid() {
        return MyUtils.isValidBase(convertFrom, tf.getText().toString());
    }
}
