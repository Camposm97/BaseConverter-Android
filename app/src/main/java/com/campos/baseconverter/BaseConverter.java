package com.campos.baseconverter;

public class BaseConverter {
    private Base convertFrom;
    private Base convertTo;

    public BaseConverter() {
        this.convertFrom = null;
        this.convertTo = null;
    }

    public Base getConvertFrom() {
        return convertFrom;
    }

    public void setConvertFrom(Base convertFrom) {
        this.convertFrom = convertFrom;
    }

    public Base getConvertTo() {
        return convertTo;
    }

    public void setConvertTo(Base convertTo) {
        this.convertTo = convertTo;
    }

    /**
     * The way convert() works is that the user inputs their number as a String type so the method can take the input and
     * analyze it and see if converting from its base to the base wanted is possible.
     * @param num
     * @return result;
     */
    public String convert(String num) {
        /*
        If the base we want to convert to is smaller than the base we're converting from, then we
        divide using the base's
         */

        // Compare the bases we want to convert from and to.

        String result = "";
        return result;
    }
}
