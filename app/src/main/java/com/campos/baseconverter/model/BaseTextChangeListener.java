package com.campos.baseconverter.model;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

public class BaseTextChangeListener implements TextWatcher {
    private static final String TAG = BaseTextChangeListener.class.getSimpleName();
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Log.d(TAG, "Before: " + s);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.d(TAG, "onChange: " + s);

    }

    @Override
    public void afterTextChanged(Editable s) {
        Log.d(TAG, "After: " + s);

    }
}
