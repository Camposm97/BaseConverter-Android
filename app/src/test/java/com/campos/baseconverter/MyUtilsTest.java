package com.campos.baseconverter;

import org.junit.Test;

import static com.campos.baseconverter.util.MyUtils.*;
import static org.junit.Assert.assertEquals;

public class MyUtilsTest {
    @Test
    public void formatBinStrTest1() {
        // Tests Whole Number
        String binStr = "10101";
        String result = formatBinStr(binStr);
        assertEquals("0001 0101", result);
    }

    @Test
    public void formatBinStrTest2() {
        // Tests Floating Point Number
        String binStr = "10100.1101001";
        String result = formatBinStr(binStr);
        assertEquals("0001 0100.1101 0010", result);
    }

    @Test
    public void spaceBinStrTest() {
        String binStr = "10101";
        String result = spaceBinStr(binStr);
        assertEquals("1 0101", result);
    }

    @Test
    public void completeBinStrTest() {
        String binStr = "1";
        String result = completeBinStr(binStr, 0);
        assertEquals("0001", result);
    }
}
