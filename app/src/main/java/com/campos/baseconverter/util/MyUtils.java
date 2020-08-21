package com.campos.baseconverter.util;

import android.util.Log;

import com.campos.baseconverter.model.Base;

public class MyUtils {
    public static boolean isBinary(String str) {
        return str.matches("[01]+");
    }

    public static boolean isOct(String str) {
        return str.matches("[0-7]+");
    }

    public static boolean isDec(String str) {
        return str.matches("[0-9]+");
    }

    public static boolean isHex(String str) {
        return str.matches("[0-9A-F]+");
    }

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
