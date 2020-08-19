package com.campos.baseconverter.model;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public abstract class BaseTextChangeListener implements TextWatcher {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }
}
