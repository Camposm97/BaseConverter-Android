package com.campos.baseconverter.model;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.SubscriptSpan;

import java.io.Serializable;

public class BaseNumber implements Serializable {
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

    public SpannableString toSpannableString() {
        String str = "(" + value + ")" + base.getRadix();
        SubscriptSpan span = new SubscriptSpan();
        SpannableString s = new SpannableString(str);
        s.setSpan(span, str.length() - 1, str.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return s;
    }

    @Override
    public String toString() {
        return "(" + value + ")" + base.getRadix();
    }
}
