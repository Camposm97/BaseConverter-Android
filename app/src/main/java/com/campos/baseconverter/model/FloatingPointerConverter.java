package com.campos.baseconverter.model;

import java.math.BigDecimal;

public class FloatingPointerConverter {
    private BaseNumber input;
    private int scale;

    public FloatingPointerConverter(BaseNumber input) {
        setInput(input);
        this.setScale(16);
    }

    public void setInput(BaseNumber input) {
        this.input = input;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public BaseNumber convert(Base convertTo) throws InvalidBaseNumberException {
        if (input.getBase().equals(convertTo)) { // Return deep copy of input
            return BaseNumber.deepCopy(input);
        } // Else convert to Decimal then to convertTo
        if (input.getBase().equals(Base.BASE_10)) {
            return new BaseNumber(convertTo, convertDecToBase(input.getValue(), convertTo));
        }
        String strDec = convertToDec();
        if (convertTo.equals(Base.BASE_10)) {
            return new BaseNumber(convertTo, strDec);
        } else {
            return new BaseNumber(convertTo, convertDecToBase(strDec, convertTo));
        }
    }

    private String convertToDec() throws InvalidBaseNumberException {
        BigDecimal result;
        String[] arr = input.getValue().split("[.]");
        BaseNumber wholePart = calcWholePart(arr[0], Base.BASE_10);
        BigDecimal fractionalPart = calcFractionPartToDec(arr[1]);
        result = new BigDecimal(wholePart.getValue());
        result = result.add(fractionalPart);
        return result.toString();
    }

    private BaseNumber calcWholePart(String value, Base convertTo) throws InvalidBaseNumberException {
        BaseNumber num = new BaseNumber(input.getBase(), value);
        BaseConverter baseConverter = new BaseConverter(num);
        return baseConverter.convert(convertTo);
    }

    private BigDecimal calcFractionPartToDec(String s) {
        int pow = -1;
        int radix = input.getBase().getRadix();
        double sum = 0;
        for (char c : s.toCharArray()) {
            double digit;
            if (Character.isLetter(c)) {
                digit = (c - 55);
            } else {
                digit = Integer.parseInt(String.valueOf(c));
            }
            double value = digit * Math.pow(radix, pow--);
            sum += value;
        }
        return new BigDecimal(sum);
    }

    private String convertDecToBase(String strDec, Base convertTo) throws InvalidBaseNumberException {
        BigDecimal value = new BigDecimal(strDec);
        BigDecimal[] arr = value.divideAndRemainder(BigDecimal.ONE);
        String strWholePart = arr[0].toBigInteger().toString();
        String strFractionPart = calcDecFractionPartToBase(arr[1], convertTo);
        BaseNumber wholePart = calcWholePart(strWholePart, convertTo);
        return wholePart.getValue() + '.' + strFractionPart;
    }

    private String calcDecFractionPartToBase(BigDecimal fractionPart, Base convertTo) {
        StringBuilder result = new StringBuilder();
        final BigDecimal RADIX = new BigDecimal(convertTo.getRadix());
        for (int i = 0; i < scale; i++) {
            fractionPart = fractionPart.multiply(RADIX);
            int wholePart = fractionPart.divide(BigDecimal.ONE).intValue();
            if (BigDecimal.ONE.compareTo(fractionPart) <= 0) { // Is whole part greater than 1
                fractionPart = fractionPart.subtract(new BigDecimal(wholePart));
                if (wholePart >= 10) {
                    result.append(((char) (wholePart + 55)));
                } else {
                    result.append(wholePart);
                }
            } else {
                result.append(wholePart);
            }
        }
        return result.toString();
    }
}
