package com.campos.baseconverter.model;

public class IEEE754 {

    public void toSinglePrecision(BaseNumber input) {
        if (input.getBase().equals(Base.BASE_2)) {
            String value = input.getValue();
        }
    }

    private boolean containsFractions(String value) {
        return value.contains("[.]");
    }
}
