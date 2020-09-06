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

            BigDecimal decimals = arr[1];
            System.out.println("inital=" + decimals);
            final int RADIX = Base.BASE_2.getRadix();
            final int LIMIT = 23;
            for (int i = 0; i < LIMIT; i++) {
                decimals = decimals.multiply(BigDecimal.valueOf(RADIX));
                if (BigDecimal.ONE.compareTo(decimals) == -1) {
                    System.out.print("1 < ");
                }
                System.out.println(decimals);
            }
        }
    }
}
