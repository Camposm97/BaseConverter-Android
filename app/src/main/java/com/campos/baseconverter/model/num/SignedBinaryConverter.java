package com.campos.baseconverter.model.num;

import com.campos.baseconverter.util.MyUtils;

import java.util.Arrays;

public class SignedBinaryConverter {
    private BaseNumber n;
    private SignFormat format;

    public SignedBinaryConverter(BaseNumber n, SignFormat format) {
        this.n = n;
        this.format = format;
    }

    public BaseNumber[] getResults() {
        final int SIZE = 4;
        BaseNumber[] results = new BaseNumber[SIZE];

        switch (format) {
            case Decimal:
                results[0] = n;
                String value = n.getValue();
                BaseConverter baseConverter = new BaseConverter(n);
                if (value.charAt(0) == '-') { // Check if value is negative
                    System.out.println("Input is negative");
                    baseConverter.setInput(new BaseNumber(n.getBase(), n.getValue().substring(1)));
                    BaseNumber unsignedBin = baseConverter.convertTo(Base.BASE_2);
                    String binStr = unsignedBin.getValue();
                    binStr = MyUtils.completeBinStr(binStr, 0);
                    binStr = MyUtils.addBitsOf0(binStr, 4); // Add four bits in front

                    BinaryOperator op = new BinaryOperator();
                    String binStrSignMag = op.toSignMag(binStr, true);
                    String bin1Comp = op.toOnesComp(binStr);
                    String bin2Comp = op.toTwosComp(binStr);

                    results[1] = new BaseNumber(Base.BASE_2, binStrSignMag);
                    results[2] = new BaseNumber(Base.BASE_2, bin1Comp);
                    results[3] = new BaseNumber(Base.BASE_2, bin2Comp);
                } else { // If the decimal value is positive then the rest of the binary numbers are the same
                    BaseNumber bin = baseConverter.convertTo(Base.BASE_2);
                    for (int i = 1; i < results.length; i++) {
                        results[i] = bin;
                    }
                }
                break;
            case Sign_Magnitude: // TODO Sign Mag
                results[1] = n;
                break;
            case Ones_Complement: // TODO One's Comp
                results[2] = n;
                break;
            case Twos_Complement: // TODO Two's Comp
                results[3] = n;
                break;
        }
        System.out.println(Arrays.toString(results));
        return results;
    }
}
