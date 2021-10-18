package com.campos.baseconverter.model.num;

import java.math.BigInteger;

public class BaseConverter {
    private BaseNumber input;

    public BaseConverter(BaseNumber input) {
        setInput(input);
    }

    public void setInput(BaseNumber input) {
        this.input = input;
    }

    public BaseNumber convertTo(Base convertTo) {
        if (!Base.isValidBaseNum(input)) {
            System.out.println(("Input is invalid!"));
            return null;
        }
        if (input.getBase().equals(convertTo)) {
            return BaseNumber.deepCopy(input); // Return deep copy of input
        }
        if (input.getValue().equals("0")) {
            System.out.println("Input is 0");
            return new BaseNumber(convertTo, "0");
        }
        if (input.getBase().equals(Base.BASE_10)) {
            return convertDecToBase(input, convertTo);
        }
        BaseNumber dec = convertToDec(input);
        if (convertTo.equals(Base.BASE_10)) {
            return dec;
        }
        return convertDecToBase(dec, convertTo);
    }

    public BaseNumber convertToDec(BaseNumber input) {
        int radix = input.getBase().getRadix();
        int pow = 0;
        BigInteger sum = BigInteger.ZERO;
        for (int i = input.size() - 1; i >= 0; i--) {
            char c = Character.toUpperCase(input.getValue().charAt(i));
            int num;
            if (Character.isLetter(c)) {
                num = (c - 55);
            } else {
                num = Integer.parseInt(String.valueOf(c));
            }
            BigInteger bigInteger = BigInteger.valueOf(radix);
            bigInteger = bigInteger.pow(pow++);
            bigInteger = bigInteger.multiply(BigInteger.valueOf(num));
            sum = sum.add(bigInteger);
        }
        return new BaseNumber(Base.BASE_10, sum.toString());
    }

    public BaseNumber convertDecToBase(BaseNumber input, Base convertTo) {
        if (input.getValue().equals("0")) {
            return new BaseNumber(convertTo, "0");
        }
        String result = "";
        int radix = convertTo.getRadix();
        BigInteger num = new BigInteger(input.getValue());
        while (!num.equals(BigInteger.ZERO)) {
            BigInteger rem = num.mod(BigInteger.valueOf(radix));
            int r = Integer.valueOf(rem.toString());
            if (r >= 10) {
                r += 55;
                result = ((char) r) + result;
            } else {
                result = r + result;
            }
            num = num.divide(BigInteger.valueOf(radix));
        }
        return new BaseNumber(convertTo, result);
    }

    public BaseNumber[] getMainResults() {
        if (!Base.isValidBaseNum(input)) {
            return null;
        }
        BaseNumber dec = convertTo(Base.BASE_10);
        BaseNumber bin = convertDecToBase(dec, Base.BASE_2);
        BaseNumber octal = convertDecToBase(dec, Base.BASE_8);
        BaseNumber hex = convertDecToBase(dec, Base.BASE_16);
        return new BaseNumber[] {bin, octal, dec, hex};
    }

    public BaseNumber[] getAllResults() {
        if (!Base.isValidBaseNum(input)) {
            return null;
        }
        BaseNumber dec = convertTo(Base.BASE_10);
        BaseNumber[] arr = new BaseNumber[Base.values().length];
        for (int i = 0; i < Base.values().length; i++) {
            if (Base.values()[i].equals(input.getBase())) {
                arr[i] = input;
            } else {
                arr[i] = convertDecToBase(dec, Base.values()[i]);
            }
        }
        return arr;
    }
}
