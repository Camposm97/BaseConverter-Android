package com.campos.baseconverter.model;

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
     * @return result[]
     */
    private String[] formatBinStr(String value) {
        StringBuilder sb = new StringBuilder(value);
        int j = 0;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '.') {
                sb.deleteCharAt(i);
                if (sb.charAt(0) == '1') {
                    j = i - 1;
                }
            }
        }
        System.out.println(sb);
        System.out.println("j=" + j);
        return null;
    }

    private boolean containsFractions(String value) {
        return value.contains("[.]");
    }
}
