package com.campos.baseconverter.util;

import android.util.Log;

import com.campos.baseconverter.model.Base;

public class MyStringUtils {
    public static boolean isBinary(String str) {
        return str.matches("[01]+");
    }

    public static boolean isOctal(String str) {
        return str.matches("[0-7]+");
    }

    public static boolean isBase(Base base, String str) {
        String regex = "[";
        int radix = base.getRadix();
        if (radix <= 10) {
            for (int i = 0; i < radix; i++){
                regex += String.valueOf(i);
            }
        } else {
            regex += "0123456789";
            radix -= 10;
            int n = 65;
            for (int i = 10; i < radix; i++) {
                regex += ((char) n);
            }
        }
        regex += "]+";
        Log.v("BaseChecker", regex);
        return str.matches(regex);
    }
}
