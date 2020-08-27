package com.campos.baseconverter.util;

import com.campos.baseconverter.model.Base;

/**
 * TODO:
 * I should probably move these methods to Base enum if I only have methods that
 * revolve around Bases.
 */
public class MyUtils {
    public static String formatBinStr(String input) {
        String result = "";
        int count = 0;
        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);
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
}
