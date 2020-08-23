package com.campos.baseconverter.util;

import android.util.Log;

import com.campos.baseconverter.model.Base;

public class MyUtils {
    public static boolean isValidBase(Base base, String str) {
        switch (base) {
            case BINARY:
                return str.matches("[01]+");
            case OCTAL:
                return str.matches("[0-7]+");
            case DECIMAL:
                return str.matches("[0-9]+");
            case HEXADECIMAL:
                return str.matches("[0-9A-F]+");
            default:
                return false;
        }
    }
}
