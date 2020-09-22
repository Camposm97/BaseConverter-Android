package com.campos.baseconverter.model;

public class IEEE754 {

    public String toSinglePrecision(BaseNumber input) {
        String result = "";
        if (input.getBase().equals(Base.BASE_2)) {
            String value = input.getValue();

        }
        return result;
    }

    /**
     * result[0] contains value, result[1] contains power
     * @return result[]
     */
    private String[] formatString(String value) {
        StringBuilder sb = new StringBuilder(value);

        return null;
    }

    private boolean containsFractions(String value) {
        return value.contains("[.]");
    }
}
