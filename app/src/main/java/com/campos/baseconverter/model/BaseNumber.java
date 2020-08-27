package com.campos.baseconverter.model;

/*
Replace parameters that take in a base and string representing the value for that base
(specifically in BaseConverter)
 */
public class BaseNumber {
    private Base base;
    private String value;

    public BaseNumber(Base base, String value) throws InvalidBaseNumberException {
        if (Base.isValidBaseNum(base, value)) {
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

    public int size() {
        return value.length();
    }

    @Override
    public String toString() {
        return "BaseNumber{" +
                "base=" + base +
                ", value='" + value + '\'' +
                '}';
    }
}
