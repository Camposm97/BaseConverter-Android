package com.campos.baseconverter.model;

import java.math.BigInteger;

public class BaseConverter {
//    private String input;
//    private Base convertFrom;
    private BaseNumber input;
    private Base convertTo;

//    public BaseConverter() {
//        this.convertFrom = null;
//        this.input = null;
//        this.convertTo = null;
//    }

    public BaseConverter(BaseNumber input) {
        setInput(input);
    }

//    public BaseConverter(Base convertFrom, Base convertTo, String input) throws InvalidBaseNumberException {
//        setConvertFrom(convertFrom);
//        setConvertTo(convertTo);
//        setInput(input);
//    }

//    public BaseConverter(Base convertFrom, String input) throws InvalidBaseNumberException {
//        setConvertFrom(convertFrom);
//        setInput(input);
//    }

    public BaseConverter(BaseNumber input, Base convertTo) {
        setInput(input);
        setConvertTo(convertTo);
    }

    public void setInput(BaseNumber input) {
        this.input = input;
    }

//    public void setInput(String input) throws InvalidBaseNumberException {
//        if (Base.isValidBaseNum(convertFrom, input)) {
//            this.input = input;
//        } else {
//            throw new InvalidBaseNumberException();
//        }
//    }

//    public void setConvertFrom(Base convertFrom) {
//        this.convertFrom = convertFrom;
//    }

    public void setConvertTo(Base convertTo) {
        this.convertTo = convertTo;
    }

    public BaseNumber convert() throws InvalidBaseNumberException {
        BaseNumber baseNumber;
        if (input.getBase().equals(convertTo)){
            return input;
        } else {
            BaseNumber dec = convertToDecimal(input);
            BaseNumber result = convertDecimalToBase(dec, convertTo);
            return result;
        }
    }

//    /**
//     * The way convert() works is that the user inputs their number as a String so the method can take the input and
//     * analyze it and see if converting from its base to the base wanted is possible.
//     * @return result
//     */
//    public String convert() {
//        String result;
//        if (convertFrom.equals(convertTo)) {
//            return input;
//        } else {
//            result = convertToDecimal(input, convertFrom);
//            result = convertDecimalToBase(result, convertTo);
//            return result;
//        }
//    }

    public BaseNumber convertToDecimal(BaseNumber input) throws InvalidBaseNumberException {
        int radix = input.getBase().getRadix();
        int pow = 0;
        BigInteger sum = BigInteger.ZERO;
        for (int i = input.getValue().length() - 1; i >= 0; i--) {
            char c = Character.toUpperCase(input.getValue().charAt(i));
            int num = 0;
            if (Character.isLetter(c)) {
                num = ((int) (c - 55));
            } else {
                num = Integer.parseInt(String.valueOf(c));
            }
            BigInteger bigInteger = BigInteger.valueOf(radix);
            bigInteger = bigInteger.pow(pow++);
            bigInteger = bigInteger.multiply(BigInteger.valueOf(num));
            sum = sum.add(bigInteger);
        }
        return new BaseNumber(Base.DECIMAL, sum.toString());
    }

    public BaseNumber convertDecimalToBase(BaseNumber input, Base convertTo) throws InvalidBaseNumberException {
        String result = "";
        int radix = input.getBase().getRadix();
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
        return new BaseNumber(convertTo, num.toString());
    }

    public BaseNumber[] getMainResults() throws InvalidBaseNumberException {
//        String strDec = convertToDecimal(input);
        BaseNumber dec = convertToDecimal(input);
        BaseNumber bin = convertDecimalToBase(dec, Base.BINARY);
        BaseNumber octal = convertDecimalToBase(dec, Base.OCTAL);
        BaseNumber hex = convertDecimalToBase(dec, Base.HEXADECIMAL);
        return new BaseNumber[] {bin, octal, dec, hex};
    }

    public BaseNumber[] getAllResults() throws InvalidBaseNumberException {
//        String strDec = convertToDecimal(input);
        BaseNumber dec = convertToDecimal(input);
        BaseNumber[] arr = new BaseNumber[Base.values().length];
        for (int i = 0; i < Base.values().length; i++) {
            if (Base.values()[i].equals(input.getBase())) {
                arr[i] = input;
            } else {
                arr[i] = convertDecimalToBase(dec, Base.values()[i]);
            }
        }
        return arr;
    }
}
