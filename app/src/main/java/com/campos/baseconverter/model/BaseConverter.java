package com.campos.baseconverter.model;

import java.math.BigInteger;

public class BaseConverter {
    private String input;
    private Base convertFrom;
    private Base convertTo;

    public BaseConverter() {
        this.convertFrom = null;
        this.convertTo = null;
    }

    public BaseConverter(Base convertFrom, Base convertTo, String input) throws InvalidBaseNumberException {
        setConvertFrom(convertFrom);
        setConvertTo(convertTo);
        setInput(input);
    }

    public BaseConverter(Base convertFrom, String input) throws InvalidBaseNumberException {
        setConvertFrom(convertFrom);
        setInput(input);
    }

    public void setInput(String input) throws InvalidBaseNumberException {
        if (Base.isValidBaseNum(convertFrom, input)) {
            this.input = input;
        } else {
            throw new InvalidBaseNumberException();
        }
    }

    public void setConvertFrom(Base convertFrom) {
        this.convertFrom = convertFrom;
    }

    public void setConvertTo(Base convertTo) {
        this.convertTo = convertTo;
    }

    /**
     * The way convert() works is that the user inputs their number as a String so the method can take the input and
     * analyze it and see if converting from its base to the base wanted is possible.
     * @return result
     */
    public String convert() {
        String result;
        if (convertFrom.equals(convertTo)) {
            return input;
        } else {
            result = convertToDecimal(input, convertFrom);
            result = convertDecimalToBase(result, convertTo);
            return result;
        }
    }

    /**
     * Takes the string that's in the base and converts it to decimal
     * @param input
     * @param base
     * @return result
     */
    public String convertToDecimal(String input, Base base) {
        int radix = base.getRadix();
        int pow = 0;
        BigInteger sum = BigInteger.ZERO;
        for (int i = input.length() - 1; i >= 0; i--) {
            char c = Character.toUpperCase(input.charAt(i));
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
        return sum.toString();
    }

    /**
     * Takes the string which should be in decimal format and takes the base given
     * to convert the string to the wanted base
     * @param input
     * @param base
     * @return result
     */
    public String convertDecimalToBase(String input, Base base) {
        String result = "";
        int radix = base.getRadix();
        BigInteger num = new BigInteger(input);
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
        return result;
    }

    public String[] getMainResults() {
        String strDec = convertToDecimal(input, convertFrom);
        String strBin = convertDecimalToBase(strDec, Base.BINARY);
        String strOctal = convertDecimalToBase(strDec, Base.OCTAL);
        String strHex = convertDecimalToBase(strDec, Base.HEXADECIMAL);
        return new String[] {strBin, strOctal, strDec, strHex};
    }

    public String[] getAllResults() {
        String strDec = convertToDecimal(input, convertFrom);
        String[] arr = new String[Base.values().length];
        for (int i = 0; i < Base.values().length; i++) {
            if (Base.values()[i].equals(convertFrom)) {
                arr[i] = input;
            } else {
                arr[i] = convertDecimalToBase(strDec, Base.values()[i]);
            }
        }
        return arr;
    }
}
