package com.campos.baseconverter.util;

import android.util.Log;

import com.campos.baseconverter.model.Base;

public class MyStringUtils {
    public static boolean isBase(Base base, String str) {
        String regex = "[";
        for (int i = 0; i < base.getRadix(); i++) {
            regex += String.valueOf(i);
        }
        regex += "]+";
        Log.v("BaseChecker", regex);
        return str.matches(regex);
    }
}
