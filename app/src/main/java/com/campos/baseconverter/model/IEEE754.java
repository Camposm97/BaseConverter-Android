package com.campos.baseconverter.model;

public class IEEE754 {
    /*
    Maybe this method doesn't need a BaseNumber type parameter, I could just pass in a binary string,
    and make it so the class validates the string.
     */
    public String toSinglePrecision(BaseNumber input) {
        StringBuilder result = new StringBuilder();
        if (input.getBase().equals(Base.BASE_2)) {
            /*
            TODO:
                I need some way to determine if the binary number is positive or negative.
                We work in two's complement, so I can solve this by creating a class that
                converts two's complement binary numbers to it's decimal and then check if the
                the decimal is less than zero.
             */
            String value = input.getValue();
            String[] arr =formatBinStr(value);
            String m = arr[0].split("[.]")[1]; // get mantissa
            String e = String.valueOf((Integer.parseInt(arr[1]) + 127)); // get exponent
            
        }
        return result.toString();
    }

    /**
     * result[0] contains value, result[1] contains power
     *
     * @return result[]
     */
    public String[] formatBinStr(String value) {
        StringBuilder sb = new StringBuilder(value);
        int posDot = sb.indexOf("."); // find the first '.'
        int posOne = sb.indexOf("1"); // find the first '1'
        int x = posDot - posOne;
//        System.out.println("x=" + x);
//        System.out.println(sb);
//        System.out.println("posDot=" + posDot);
//        System.out.println("posOne=" + posOne);
        if (x == 1) { // Leave decimal
            x = 0;
        } else if (x > 1) { // Move decimal right
            sb.insert(posOne + 1, '.');
            sb.deleteCharAt(posDot + 1);
            posDot = sb.indexOf(".");
            x = Math.abs(x) - 1;
        } else { // Move decimal left
            sb.insert(posOne + 1, '.');
            sb.deleteCharAt(posDot);
            posDot = sb.indexOf(".");
        }
        if (sb.charAt(sb.length() - 1) == '.') {
            sb.append('0');
        }
        sb = sb.delete(0, posDot - 1);
//        System.out.println(sb);
//        System.out.println("pow=" + x);
        return new String[] {sb.toString(), String.valueOf(x)};
    }
}
