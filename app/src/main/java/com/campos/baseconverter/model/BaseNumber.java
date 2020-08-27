package com.campos.baseconverter.model;

import com.campos.baseconverter.util.MyUtils;

import java.math.BigInteger;

public class BaseNumber {
    private Base base;
    private String value;

    public BaseNumber(Base base, String value) throws InvalidBaseNumberException {
        if (MyUtils.isValidBaseNum(base, value)) {
            this.base = base;
            this.value = value;
        } else {
            throw new InvalidBaseNumberException();
        }
    }

    public Base getBase() {
        return base;
    }

    public String getValue() {
        return value;
    }
}
