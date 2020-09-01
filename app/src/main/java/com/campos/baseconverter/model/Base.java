package com.campos.baseconverter.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public enum Base {
    BINARY(2), BASE_3(3), BASE_4(4), BASE_5(5),
    BASE_6(6), BASE_7(7), OCTAL(8), BASE_9(9),
    DECIMAL(10), BASE_11(11), BASE_12(12), BASE_13(13),
    BASE_14(14), BASE_15(15), HEXADECIMAL(16), Base_17(17),
    BASE_18(18), BASE_19(19), BASE_20(20), BASE_21(21), BASE_22(22),
    BASE_23(23), BASE_24(24), BASE_25(25), BASE_26(26), BASE_27(27),
    BASE_28(28), BASE_29(29), BASE_30(30), BASE_31(31), BASE_32(32),
    BASE_33(33), BASE_34(34), BASE_35(35), BASE_36(36);

    private int radix;

    Base(int radix) {
        this.radix = radix;
    }

    public int getRadix() {
        return radix;
    }

    public static String toItem(Base base) {
        String s = base.toString();
        s = s.toLowerCase();
        s = Character.toUpperCase(s.charAt(0)) + s.substring(1);
        s = s.replace('_', ' ');
        return s;
    }

    public static List<String> loadSpinnerItemMainBases() {
        return Arrays.asList("Convert From: Select One", "Binary", "Octal", "Decimal", "Hexadecimal");
    }

    public static List<String> loadSpinnerItemsAllBases() {
        List<String> list = new LinkedList<>();
        list.add("Convert From: Select One");
        for (int i = 0; i < values().length; i++) {
            Base base = values()[i];
            switch (base) {
                case BINARY:
                    list.add("Base 2");
                    break;
                case OCTAL:
                    list.add("Base 8");
                    break;
                case DECIMAL:
                    list.add("Base 10");
                    break;
                case HEXADECIMAL:
                    list.add("Base 16");
                    break;
                default:
                    String s = toItem(base);
                    list.add(s);
            }
        }
        return list;
    }

    public static String toTitle(Base base) {
        switch (base) {
            case BINARY:
                return "BASE 02";
            case OCTAL:
                return "BASE 08";
            case DECIMAL:
                return "BASE 10";
            case HEXADECIMAL:
                return "BASE 16";
            default:
                String result = " ";
                if (base.getRadix() < 10) {
                    result += "0";
                }
                result += base.getRadix();
                return "BASE" + result;
        }
    }

    public static boolean isMainBase(Base base) {
        switch (base) {
            case BINARY:
            case OCTAL:
            case DECIMAL:
            case HEXADECIMAL:
                return true;
            default:
                return false;
        }
    }

    public static boolean isValidBaseNum(BaseNumber input) {
        int radix = input.getBase().getRadix();
        if (radix <= 10) {
            return input.getValue().matches("[0-" + (radix - 1) + "]+");
        } else {
            char c = (char) (54 + radix);
            return input.getValue().matches("[0-9A-" + c + "]+");
        }
    }
}
