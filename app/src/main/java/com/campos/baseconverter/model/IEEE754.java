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
