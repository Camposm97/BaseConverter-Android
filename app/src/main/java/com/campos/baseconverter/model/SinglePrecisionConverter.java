package com.campos.baseconverter.model;


import java.math.BigDecimal;

public class SinglePrecisionConverter {
    private BaseNumber input;

    public SinglePrecisionConverter(BaseNumber input) {
        this.input = input;
    }

    public void convertToBin() throws InvalidBaseNumberException {
        if (input.getBase().equals(Base.BASE_10)) {
            BigDecimal value = new BigDecimal(input.getValue());
            BigDecimal[] arr = value.divideAndRemainder(BigDecimal.ONE);
//            System.out.println(arr[0]);
//            System.out.println(arr[1]);

            BaseNumber num = new BaseNumber(input.getBase(), arr[0].toBigInteger().toString());
            BaseConverter baseConverter = new BaseConverter(num, Base.BASE_2);
            BaseNumber result1 = baseConverter.convert(); //  Result before '.'

            
        }
    }
}
