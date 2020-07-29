package com.campos.baseconverter.model;

import java.util.LinkedList;
import java.util.List;

public class NumberSystem {
    private DataRepresentation dataRepr;
    private BaseConverter baseConverter;

    public NumberSystem() {
        dataRepr = DataRepresentation.UNSIGNED;
        baseConverter = new BaseConverter();
    }

    public void setDataRepr(DataRepresentation dataRepr) {
        this.dataRepr = dataRepr;
    }

    public BaseConverter getBaseConverter() {
        return baseConverter;
    }

    public List<String> getMainResults(String input, Base base) {
        List<String> list = new LinkedList<>();
        String result = baseConverter.convertToDecimal(input, base);
        return list;
    }

    public List<String> getAllResults(String input, Base base) {
        List<String> list = new LinkedList<>();
        String result = baseConverter.convertToDecimal(input, base);
        for (Base b : Base.values()) {
            String str = baseConverter.convertDecimalToBase(result, b);
            list.add(str);
        }
        return list;
    }
}
