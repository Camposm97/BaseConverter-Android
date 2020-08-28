package com.campos.baseconverter.model;

import java.util.LinkedList;

public class ConversionHistory {
    private static ConversionHistory convertHistory;

    public static void init() {
        convertHistory = new ConversionHistory();
    }

    public static ConversionHistory getConvertHistory() {
        return convertHistory;
    }

    private LinkedList<BaseNumber> baseNumbers;

    private ConversionHistory() {
        this.baseNumbers = new LinkedList<>();
    }


}
