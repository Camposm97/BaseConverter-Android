package com.campos.baseconverter.model;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.SubscriptSpan;

import java.io.Serializable;

/**
 * TODO: Get rid of InvalidNumberException and instead return null if there's a problem
 */
public class BaseNumber implements Serializable {
    public static BaseNumber[] getMain() {
        BaseNumber numBin = new BaseNumber(Base.BASE_2, "");
        BaseNumber numOct = new BaseNumber(Base.BASE_8, "");
        BaseNumber numDec = new BaseNumber(Base.BASE_10, "");
        BaseNumber numHex = new BaseNumber(Base.BASE_16, "");
        return new BaseNumber[] {numBin, numOct, numDec, numHex};
    }

    public static BaseNumber[] getAll() {
        BaseNumber[] arr = new BaseNumber[Base.values().length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new BaseNumber(Base.values()[i], "");
        }
        return arr;
    }

    private Base base;
    private String value;

    public BaseNumber(Base base, String value) {
        this.base = base;
        this.value = value;
    }

    public Base getBase() {
        return base;
    }

    public String getValue() {
        return value;
    }

    public int size() {
        return value.length();
    }

    public SpannableString toSpanString() {
        String radix = String.valueOf(base.getRadix());
        String str = "(" + value + ")" + radix;
        SubscriptSpan span = new SubscriptSpan();
        SpannableString spanStr = new SpannableString(str);
        spanStr.setSpan(span, str.length() - radix.length(), str.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spanStr;
    }

    public boolean hasDecimals() {
        return value.contains(".");
    }

    @Override
    public String toString() {
        return "(" + value + ")" + base.getRadix();
    }

    public static BaseNumber deepCopy(BaseNumber number) {
        return new BaseNumber(number.getBase(), number.getValue());
    }
}
