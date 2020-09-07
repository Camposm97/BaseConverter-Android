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

    public String convertToBinStr() throws InvalidBaseNumberException {
        String result = "";
        if (input.getBase().equals(Base.BASE_10)) {
            BigDecimal value = new BigDecimal(input.getValue());
            BigDecimal[] arr = value.divideAndRemainder(BigDecimal.ONE);

            String result1 = calcWholePart(arr[0]);
//            BaseNumber num = new BaseNumber(input.getBase(), arr[0].toBigInteger().toString());
//            BaseConverter baseConverter = new BaseConverter(num, Base.BASE_2);
//            BaseNumber result1 = baseConverter.convert(); //  Result before '.'

            BigDecimal decimals = arr[1];
            String result2 = calcFractionalPart(decimals);
            result = result1 + "." + result2;
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
            BigInteger bit = fractionalPart.divide(BigDecimal.ONE).toBigInteger();
            if (BigDecimal.ONE.compareTo(fractionalPart) <= 0) { // Is greater than 1
                fractionalPart = fractionalPart.subtract(new BigDecimal(bit));
                result = result + bit.toString();
            } else { // Is less than one
                result = result + bit.toString();
            }
        }

        return result;
    }
}
