package com.campos.baseconverter.util;

import android.content.Context;
import android.widget.Toast;

import com.campos.baseconverter.R;

public class AlertUtils {
    public static void showInvalidBaseNumInput(Context c) {
        Toast.makeText(c, R.string.invalid_base_num_message, Toast.LENGTH_SHORT).show();
    }
}
