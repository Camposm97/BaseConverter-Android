package com.campos.baseconverter.util;


/* TODO
    Maybe I should rename this class since it only involves formatting
    binary strings
 */
public class MyUtils {
    /**
     * Calls spaceBinStr and completeBinStr
     * @param binStr
     * @return result
     */
    public static String formatBinStr(String binStr) {
        if (binStr.contains(".")) {
            String[] arr = binStr.split("[.]");
            return spaceBinStr(completeBinStr(arr[0], 0)) + "." + spaceBinStr(completeBinStr(arr[1], 1));
        }
        return spaceBinStr(completeBinStr(binStr, 0));
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
     * mod 4 equals zero. If code == 0, then add zeros in front, else add zeros at the back
     * @param binStr
     * @return result
     */
    public static String completeBinStr(String binStr, int code) {
        while ((binStr.length() % 4) != 0) {
            if (code == 0)
                binStr = "0" + binStr;
            else
                binStr = binStr + "0";
        }
        return binStr;
    }

    /**
     * Adds bits of 0 in front of the binary string
     * @param binStr
     * @param amount
     * @return
     */
    public static String addBitsOf0(String binStr, int amount) {
        for (int i = 0; i < amount; i++) {
            binStr = "0" + binStr;
        }
        return binStr;
    }
}
