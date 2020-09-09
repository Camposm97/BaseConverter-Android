package com.campos.baseconverter.model;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SinglePrecisionConverter {
    private BaseNumber input;

    public SinglePrecisionConverter(BaseNumber input) {
        this.input = input;
    }

    public BaseNumber getInput() {
        return input;
    }

    public String convertToDec() throws InvalidBaseNumberException {
        BigDecimal result = null;
        if (!input.getBase().equals(Base.BASE_10)) {
            String[] arr = input.getValue().split("[.]");
            BaseNumber wholePart = calcWholePartToDec(arr[0]);
            BigDecimal fractionalPart = calcFractionalPartToDec(arr[1]);
            result = new BigDecimal(wholePart.getValue());
            result = result.add(fractionalPart);
        }
        return result.toString();
    }

    private BaseNumber calcWholePartToDec(String value) throws InvalidBaseNumberException {
        BaseNumber num = new BaseNumber(input.getBase(), value);
        BaseConverter baseConverter = new BaseConverter(num, Base.BASE_10);
        return baseConverter.convert();
    }

    private BigDecimal calcFractionalPartToDec(String s) {
        int pow = -1;
        double sum = 0;
        for (char c : s.toCharArray()) {
            double value;
            if (Character.isLetter(c)) {
                value = (c - 55);
            } else {
                value = Integer.valueOf(c + "");
            }
            sum += (value * Math.pow(input.getBase().getRadix(), pow--));
        }
        return new BigDecimal(sum);
    }

    public String convertToBinStr() throws InvalidBaseNumberException {
        String result = "";
        if (input.getBase().equals(Base.BASE_10)) {
            BigDecimal value = new BigDecimal(input.getValue());
            BigDecimal[] arr = value.divideAndRemainder(BigDecimal.ONE);

            String wholePart = calcWholePart(arr[0]);
            String fractionalPart = calcFractionalPart(arr[1]);
            result = wholePart + "." + fractionalPart;
        }
        return result;
    }

    private String calcWholePart(BigDecimal wholePart) throws InvalidBaseNumberException {
        String value = wholePart.toBigInteger().toString();
        BaseNumber num = new BaseNumber(input.getBase(), value);
        return new BaseConverter(num, Base.BASE_2).convert().getValue();
    }

    private String calcFractionalPart(BigDecimal fractionalPart) {
        String result = "";
        final int RADIX = Base.BASE_2.getRadix();
        final int LIMIT = 23;
        for (int i = 0 ;i < LIMIT; i++) {
            fractionalPart = fractionalPart.multiply(BigDecimal.valueOf(RADIX));
            BigInteger wholePart = fractionalPart.divide(BigDecimal.ONE).toBigInteger();
            if (BigDecimal.ONE.compareTo(fractionalPart) <= 0) { // Is greater than 1
                fractionalPart = fractionalPart.subtract(new BigDecimal(wholePart));
                result = result + wholePart.toString();
            } else { // Is less than one
                result = result + wholePart.toString();
            }
        }
        return result;
    }
}
