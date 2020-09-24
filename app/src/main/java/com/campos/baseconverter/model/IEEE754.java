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
        int posDot = sb.indexOf("."); // find the first '.'
        int posOne = sb.indexOf("1"); // find the first '1'
        int x = posDot - posOne;
//        System.out.println("x=" + x);
//        System.out.println(sb);
//        System.out.println("posDot=" + posDot);
//        System.out.println("posOne=" + posOne);
        if (x == 1) { // Leave decimal
            x = 0;
        } else if (x > 1) { // Move decimal right
            sb.insert(posOne + 1, '.');
            sb.deleteCharAt(posDot + 1);
            posDot = sb.indexOf(".");
            x = Math.abs(x) - 1;
        } else { // Move decimal left
            sb.insert(posOne + 1, '.');
            sb.deleteCharAt(posDot);
            posDot = sb.indexOf(".");
        }
        if (sb.charAt(sb.length() - 1) == '.') {
            sb.append('0');
        }
        sb = sb.delete(0, posDot - 1);
//        System.out.println(sb);
//        System.out.println("pow=" + x);
        return new String[] {sb.toString(), String.valueOf(x)};
    }
}
