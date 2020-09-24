package com.campos.baseconverter;

import com.campos.baseconverter.model.IEEE754;

import org.junit.Test;

import java.util.Arrays;

public class IEEE754Test {
    @Test
    public void testFormatBinStr1() {
        String value = "00.00";
        IEEE754 ieee = new IEEE754();
        String[] resultArr = ieee.formatBinStr(value);
        System.out.println(Arrays.toString(resultArr));
    }
}
