package com.campos.baseconverter;

public enum Base {
    BINARY(2), BASE_3(3), BASE_4(4), BASE_5(5),
    BASE_6(6), BASE_7(7), OCTAL(8), BASE_9(9),
    DECIMAL(10), BASE_11(11), BASE_12(12), BASE_13(13),
    BASE_14(14), BASE_15(15), HEXADECIMAL(16);

    private int numOfDigits;

    private Base(int numOfDigits) {
        this.numOfDigits = numOfDigits;
    }

    public int getNumOfDigits() {
        return numOfDigits;
    }
}
