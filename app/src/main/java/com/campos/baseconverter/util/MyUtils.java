package com.campos.baseconverter.util;

import com.campos.baseconverter.model.Base;

/**
 * TODO:
 * I should probably move these methods to Base enum if I only have methods that
 * revolve around Bases.
 */
public class MyUtils {
    /**
     * Calls spaceBinStr and completeBinStr
     * @param binStr
     * @return result
     */
    public static String formatBinStr(String binStr) {
        return spaceBinStr(completeBinStr(binStr));
    }

    /**
     * Formats the binary string by spacing out the bits by splitting it by a space
     * for every 4 bits.  If the string's length is not divisible by 4, then the it will be left
     * as this (before: 10101 ---> after: 1 0101)
     * @param binStr
     * @return result
     */
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

    /**
     * Completes the binary string by adding zeros in front of the string if the string's length
     * mod 4 equals zero
     * @param binStr
     * @return result
     */
    public static String completeBinStr(String binStr) {
        while ((binStr.length() % 4) != 0) {
            binStr = "0" + binStr;
        }
        return binStr;
    }
}
