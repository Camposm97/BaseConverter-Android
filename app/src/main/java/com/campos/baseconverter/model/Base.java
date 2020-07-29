package com.campos.baseconverter.model;

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

    private Base(int radix) {
        this.radix = radix;
    }

    public int getRadix() {
        return radix;
    }
}
