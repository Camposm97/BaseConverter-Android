package com.campos.baseconverter.model;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

public class BaseTextChangeListener implements TextWatcher {
    private static final String TAG = BaseTextChangeListener.class.getSimpleName();
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Log.v(TAG, "Before: " + s);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.v(TAG, "onChange: " + s);
    }

    @Override
    public void afterTextChanged(Editable s) {
        Log.v(TAG, "After: " + s);
        Log.v(TAG, "\n");
    }
}
