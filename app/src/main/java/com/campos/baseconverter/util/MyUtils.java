package com.campos.baseconverter.util;

import com.campos.baseconverter.model.Base;

public class MyUtils {
    public static boolean isValidBase(Base base, String input) {
        switch (base) {
            case BINARY:
                return input.matches("[01]+");
            case OCTAL:
                return input.matches("[0-7]+");
            case DECIMAL:
                return input.matches("[0-9]+");
            case HEXADECIMAL:
                return input.matches("[0-9A-F]+");
            default:
                int radix = base.getRadix();
                if (radix < 10) {
                    return input.matches("[0-" + (radix - 1) + "]+");
                } else {
                    char c = (char) (54 + radix);
                    return input.matches("[0-9A-" + c + "]");
                }
        }
    }
}
