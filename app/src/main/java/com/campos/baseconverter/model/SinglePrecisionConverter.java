package com.campos.baseconverter.model;


import java.math.BigDecimal;

public class SinglePrecisionConverter {
    private BaseNumber input;

    public SinglePrecisionConverter(BaseNumber input) {
        this.input = input;
    }

    public void convertToBin() {
        if (input.getBase().equals(Base.BASE_10)) {
            BigDecimal value = new BigDecimal(input.getValue());
            BigDecimal quotient = value.divide(BigDecimal.ONE);
            BigDecimal r = value.remainder(BigDecimal.ONE);
            System.out.println(quotient);
            System.out.println(r);
        }
    }
}
