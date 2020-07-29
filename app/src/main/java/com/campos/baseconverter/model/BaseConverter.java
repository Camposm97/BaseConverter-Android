package com.campos.baseconverter.model;

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
     * The way convert() works is that the user inputs their number as a String so the method can take the input and
     * analyze it and see if converting from its base to the base wanted is possible.
     *
     * If the bases we're converting from and to are the same, then return the same thing
     *
     * If the base we're converting to is lower from decimal, then all we have to do is divide.
     *
     * If the base we're converting to is decimal and the base we're converting from is smaller than decimal,
     * then all we have to is multiply by the base we're converting from
     *
     * If the base we're converting to is higher from a smaller base,
     * then we have to take the input and convert to decimal and then convert that to the base we want by dividing
     *
     * If the base we're converting to is lower than the base we're converting from, then we have to take the input and convert it to deciaml and then,
     * convert it to the base we want by dividing
     * @param str
     * @return result
     */
    public String convert(String str) {
        String result;
        if (convertFrom.equals(convertTo)) {
            return str;
        } else {
            result = convertToDecimal(str, convertFrom);
            result = convertDecimalToBase(result, convertTo);
            return result;
        }
    }

    /**
     * Takes the string that's in the base and converts it to decimal
     * @param str
     * @param base
     * @return result
     */
    public String convertToDecimal(String str, Base base) {
        String result = "";
        int radix = base.getRadix(); // Unique digits in base
        long pow = 0;
        long sum = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            int num = 0;
            if (Character.isLetter(c)) {
                c = Character.toUpperCase(c);
                num = (int) c - 55; // Giving us what the number the letter represents
            } else {
                num = Integer.parseInt(String.valueOf(c));
            }
            // Add to sum and increment power for next column
            sum += (num * Math.pow(radix, pow++));
        }
        result = String.valueOf(sum);
        return result;
    }

    /**
     * Takes the string which should be in decimal format and takes the base given
     * to convert the string to the wanted base
     * @param str
     * @param base
     * @return result
     */
    public String convertDecimalToBase(String str, Base base) {
        String result = "";
        int radix = base.getRadix();
        long num = Long.valueOf(str);
        while (num != 0) {
            long r = num % radix;
            if (r >= 10) {
                r += 55;
                result = ((char) r) + result;
            } else {
                result = r + result;
            }
            num = num / radix;
        }
        return result;
    }
}
