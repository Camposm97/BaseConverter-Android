package com.campos.baseconverter.model;

import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

public class BaseOnKeyListener implements View.OnKeyListener {
    private BaseConverter bc;
    private EditText tf;

    public BaseOnKeyListener(EditText tf) {
        this.tf = tf;
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {

        return false;
    }
}
