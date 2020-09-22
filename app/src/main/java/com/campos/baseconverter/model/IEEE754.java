package com.campos.baseconverter.model;

import java.util.Arrays;

public class IEEE754 {

    public String toSinglePrecision(BaseNumber input) {
        String result = "";
        if (input.getBase().equals(Base.BASE_2)) {
            String value = input.getValue();
            formatBinStr(value);
        }
        return result;
    }

    /**
     * result[0] contains value, result[1] contains power
     *
     * @return result[]
     */
    private String[] formatBinStr(String value) {
        StringBuilder sb = new StringBuilder(value);
        int pos1 = sb.indexOf(".");
        int pos2 = sb.indexOf("1");
//        sb.deleteCharAt(pos1);
//        for (int i = 0; i < sb.length(); i++) {
//            char c = sb.charAt(i);
//            if (c == '1') {
//                pos2 = i;
//                break;
//            }
//        }
//        for (int i = 0; i < sb.length(); i++) {
//            char c0 = sb.charAt(i);
//            if (i < sb.length() - 1) {
//                char d = sb.charAt(i + 1);
//                System.out.println(d);
//            }
//            if (c0 == '.') {
//                position = i;
//                break;
//                if (sb.charAt(0) == '1') {
//                    // If the msb is a 1, then we can get the power and delete '.' and move on
//                    sb.deleteCharAt(i);
//                    break;
//                }
//                else { // We have to find a 1 to know the power, then we can delete '.'
//                    String[] arr = sb.toString().split("[.]");
//                    for (int j = 0; j < arr[0].length(); j++) {
//                        char c1 = arr[0].charAt(j);
//                        if (c1 == '1') {
//                            position = position - j;
//                        }
//                    }
//                    sb.deleteCharAt(i);
//                }
//            }
//        }
        int x = pos1 - pos2;
        System.out.println("x=" + x);
        System.out.println(sb);
        System.out.println("pos1=" + pos1);
        System.out.println("pos2=" + pos2);
        if (x == 1) {
            System.out.println("Leave the decimal");
        } else if (x > 1) {
            System.out.println("Move decimal to the right");
        } else {
            System.out.println("Move decimal to the left");
        }
        return null;
    }

    private boolean containsFractions(String value) {
        return value.contains("[.]");
    }
}
