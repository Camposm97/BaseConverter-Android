package com.campos.baseconverter.util;

import com.campos.baseconverter.model.Base;

/**
 * TODO:
 * I should probably move these methods to Base enum if I only have methods that
 * revolve around Bases.
 */
public class MyUtils {
    public static String formatBinStr(String binStr) {
        String result = "";
        return result;
    }

    public static String spaceBinStr(String binStr) {


        String result = "";
        int count = 0;
        for (int i = binStr.length() - 1; i >= 0; i--) {
            char c = binStr.charAt(i);
            result = c + result;
            count++;
            if (count >= 4) {
                result = " " + result;
                count = 0;
            }
        }
        if (result.charAt(0) == ' ') {
            result = result.substring(1);
        }
        return result;
    }

    public static String completeBinStr(String binStr) {
        String result = "";
        final int SIZE = binStr.length();
        int r = SIZE % 4;
        for (int i = 0; i < r; i++) {
            binStr = "0" + binStr;
        }
        result = binStr;
        return result;
    }
}
