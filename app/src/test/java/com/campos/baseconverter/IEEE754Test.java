package com.campos.baseconverter;

import com.campos.baseconverter.model.IEEE754;

import org.junit.Test;

import java.util.Arrays;

public class IEEE754Test {
    /*
    TODO:
     - If you pass a value of 0.0 and pass that into formatBinStr, it will crash the program (StringIndexOutOfBounds)
     */
    @Test
    public void testFormatBinStr1() {
        String value = "100.0";
        IEEE754 ieee = new IEEE754();
        String[] resultArr = ieee.formatBinStr(value);
        System.out.println(Arrays.toString(resultArr));
    }
}
