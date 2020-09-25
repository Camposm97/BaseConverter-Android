package com.campos.baseconverter.model;

public class BinaryOperator {
    public String toTwosComp(BaseNumber input) {
        StringBuilder sb = new StringBuilder();
        if (input.isValidAndIs(Base.BASE_2)) {

        }
        return sb.toString();
    }

    public char[] flipBits(char[] input) {
        char[] arr = input.clone();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == 48)
                arr[i] = 49;
            if (c == 49)
                arr[i] = 48;
        }
        return arr;
    }

    public char[] addOne(char[] input) {
        char[] arr = input.clone();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == 48) {
                arr[i] = 49;
                break;
            }
            if (c == 49) {
                arr[i] = 48;
            }
        }
        return arr;
    }
}
