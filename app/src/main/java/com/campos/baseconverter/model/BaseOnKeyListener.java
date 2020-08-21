package com.campos.baseconverter.model;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import com.campos.baseconverter.util.MyUtils;

import java.util.Arrays;

public class BaseOnKeyListener implements View.OnKeyListener {
    private BaseConverter bc;
    private EditText tf;
    private EditText[] editTexts;

    public BaseOnKeyListener(EditText tf, Base convertFrom, EditText[] editTexts) {
        this.bc = new BaseConverter(tf.getText().toString(), convertFrom);
        this.tf = tf;
        this.editTexts = editTexts;
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (MyUtils.isBinary(tf.getText().toString())) {
            String[] results = bc.getMainResults();
            displayResults(results);
        }
        return false;
    }

    private void displayResults(String[] results) {
        for (int i = 0; i < editTexts.length; i++) {
//            if (arr[i] != tf) {
            editTexts[i].setText(results[i]);
//            }
        }
    }

}
