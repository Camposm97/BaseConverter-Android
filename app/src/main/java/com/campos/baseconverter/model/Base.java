package com.campos.baseconverter.model;

import java.util.LinkedList;
import java.util.List;

public enum Base {
    BASE_2(2, "Binary"), BASE_3(3, "Ternary"),
    BASE_4(4, "Quarternary"), BASE_5(5, "Quinary"),
    BASE_6(6, "Senary"), BASE_7(7, "Septenary"),
    BASE_8(8, "Octal"), BASE_9(9, "Nonary"),
    BASE_10(10, "Decimal"), BASE_11(11, "Undecimal"),
    BASE_12(12, "Duodecimal"), BASE_13(13, "Tridecimal"),
    BASE_14(14, "Tetradecimal"), BASE_15(15, "Pentadecimal"),
    BASE_16(16, "Hexadecimal"), Base_17(17, "Heptadecimal"),
    BASE_18(18, "Octodecimal"), BASE_19(19, "Enneadecimal"),
    BASE_20(20, "Vigesimal"), BASE_21(21, "Unvigesimal"),
    BASE_22(22, "Duovigesimal"), BASE_23(23, "Trivigesimal"),
    BASE_24(24, "Tetravigesimal"), BASE_25(25, "Pentavigesimal"),
    BASE_26(26, "Hexavigesimal"), BASE_27(27, "Heptavigesimal"),
    BASE_28(28, "Octovigesimal"), BASE_29(29, "Enneavigesimal"),
    BASE_30(30, "Trigesimal"), BASE_31(31, "Untrigesimal"),
    BASE_32(32, "Duotrisgesimal"), BASE_33(33, "Tritrigesimal"),
    BASE_34(34, "Tetratrigesimal"), BASE_35(35, "Pentatrigesimal"),
    BASE_36(36, "Hexatrigesimal");

    private int radix;
    private String name;

    Base(int radix, String name) {
        this.radix = radix;
        this.name = name;
    }

    public static String toItem(Base base) {
        String s = base.toString();
        s = s.toLowerCase();
        s = Character.toUpperCase(s.charAt(0)) + s.substring(1);
        s = s.replace('_', ' ');
        return s;
    }

    public static List<String> loadSpinnerItemMainBases() {
        List<String> list = new LinkedList<>();
        list.add("Convert From: Select One");
        list.add(BASE_2.getName());
        list.add(BASE_8.getName());
        list.add(BASE_10.getName());
        list.add(BASE_16.getName());
        return list;
    }

    public static List<String> loadSpinnerAllBases() {
        List<String> list = new LinkedList<>();
        list.add("Convert From: Select One");
        for (int i = 0; i < values().length; i++) {
            Base base = values()[i];
            String s = toItem(base);
            list.add(s);
        }
        return list;
    }

    /**
     * Parses only main bases
     * @param chosenItem
     * @return
     */
    public static Base parse(String chosenItem) {
        System.out.println("chosenItem=" + chosenItem);
        switch (chosenItem.toUpperCase()) {
            case "BINARY":
                return BASE_2;
            case "OCTAL":
                return BASE_8;
            case "DECIMAL":
                return BASE_10;
            case "HEXADECIMAL":
                return BASE_16;
            default:

                return Base.valueOf(chosenItem.toUpperCase());
        }
    }

    public static boolean isValidBaseNum(BaseNumber input) {
        int radix = input.getBase().getRadix();
        if (radix <= 10) {
            return input.getValue().replaceFirst("[.]", "").matches("[0-" + (radix - 1) + "]+");
        } else {
            char c = (char) (54 + radix);
            return input.getValue().replaceFirst("[.]", "").matches("[0-9A-" + c + "]+");
        }
    }

    public int getRadix() {
        return radix;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Base " + radix;
    }

    public String toTitle() {
        String result = " ";
        if (radix < 10) {
            result += "0";
        }
        result += radix;
        return "BASE" + result;
    }
}
