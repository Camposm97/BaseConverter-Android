package com.campos.baseconverter.util;

import android.content.Context;
import android.widget.Toast;

import com.campos.baseconverter.R;

public class AlertHelper {
    public static void showInvalidBaseNumInput(Context context) {
        Toast.makeText(context, R.string.invalid_base_num_message, Toast.LENGTH_SHORT).show();
    }
}
