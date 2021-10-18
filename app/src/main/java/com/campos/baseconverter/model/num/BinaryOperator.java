package com.campos.baseconverter.model.num;

public class BinaryOperator {
    // TODO Find a better way to find sign/mag
    public String toSignMag(String binStr, boolean isNegative) {
        /*
        The msb is allocated to represent the sign, so there has to be some sort of restriction on the user's input
        so the msb is not touched.
         */
        char[] arr = binStr.toCharArray();
        if (isNegative) {
            arr[0] = '1';
        }
        return new String(arr);

    }

    public String toOnesComp(String binStr) {
        char[] arr = binStr.toCharArray();
        arr = flipBits(arr);
        return new String(arr);
    }

    public String toTwosComp(String binStr) {
        /*
        We can assume the number is already negative, but if the number is positive then
        there's no need to call the function at all.
         */
        char[] arr = binStr.toCharArray();
        arr = flipBits(arr);
        arr = addOne(arr);
        return new String(arr);
    }

    public char[] flipBits(char[] input) {
        char[] arr = input.clone();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == '0')
                arr[i] = '1';
            if (c == '1')
                arr[i] = '0';
        }
        return arr;
    }

    public char[] addOne(char[] input) {
        char[] arr = input.clone();
        for (int i = (arr.length - 1); i >= 0; i--) {
            char c = arr[i];
            if (c == '0') {
                arr[i] = '1';
                break;
            }
            if (c == '1') {
                arr[i] = '0';
            }
        }
        return arr;
    }
}
