package com.campos.baseconverter.model;

import java.math.BigInteger;

public class BaseConverter {
    private BaseNumber input;
//    private Base convertTo;

    public BaseConverter(BaseNumber input) throws InvalidBaseNumberException {
        setInput(input);
    }

//    public BaseConverter(BaseNumber input, Base convertTo) throws InvalidBaseNumberException {
//        setInput(input);
//        setConvertTo(convertTo);
//    }

    public void setInput(BaseNumber input) throws InvalidBaseNumberException {
        if (Base.isValidBaseNum(input)) {
            this.input = input;
        } else {
            throw new InvalidBaseNumberException();
        }
    }

//    public void setConvertTo(Base convertTo) {
//        this.convertTo = convertTo;
//    }

    public BaseNumber convert(Base convertTo) {
        if (input.getBase().equals(convertTo)) {
            return BaseNumber.deepCopy(input); // Return deep copy of input
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
        BaseNumber dec = convertToDec(input);
        BaseNumber bin = convertDecToBase(dec, Base.BASE_2);
        BaseNumber octal = convertDecToBase(dec, Base.BASE_8);
        BaseNumber hex = convertDecToBase(dec, Base.BASE_16);
        return new BaseNumber[]{bin, octal, dec, hex};
    }

    public BaseNumber[] getAllResults() {
        BaseNumber dec = convertToDec(input);
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
