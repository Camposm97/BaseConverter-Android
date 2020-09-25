package com.campos.baseconverter;

import com.campos.baseconverter.model.IEEE754;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class IEEE754Test {
    /*
    TODO:
     - If you pass a value of 0.0 and pass that into formatBinStr, it will crash the program (StringIndexOutOfBounds)
     */
    @Test
    public void testFormatBinStr1() {
        String value = "100.0";
        IEEE754 ieee754 = new IEEE754();
        String[] arr = ieee754.formatBinStr(value);
        assertEquals("1.000", arr[0]);
        assertEquals("2", arr[1]);
    }

    @Test
    public void testFormatBinStr2() {
        String value = "0.01";
        IEEE754 ieee754 = new IEEE754();
        String[] arr = ieee754.formatBinStr(value);
        assertEquals("1.0", arr[0]);
        assertEquals("-2", arr[1]);
    }

    @Test
    public void testFormatBinStr3() {
        String value = "1.01";
        IEEE754 ieee754 = new IEEE754();
        String[] arr = ieee754.formatBinStr(value);
        assertEquals("1.01", arr[0]);
        assertEquals("0", arr[1]);
    }
}
