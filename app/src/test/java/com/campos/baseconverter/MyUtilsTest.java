package com.campos.baseconverter;

import org.junit.Test;

import static com.campos.baseconverter.util.MyUtils.*;
import static org.junit.Assert.assertEquals;

public class MyUtilsTest {
    @Test
    public void formatBinStrTest() {
        String binStr = "10101";
        String result = formatBinStr(binStr);
        assertEquals("0001 0101", result);
    }

    @Test
    public void spaceBinStrTest() {
        String binStr = "10101";
        String result = spaceBinStr(binStr);
        assertEquals("1 0101", result);
    }

    @Test
    public void completeBinStrTest1() {
        // Tests whole number
        String binStr = "1";
        String result = completeBinStr(binStr);
        assertEquals("0001", result);
    }

    @Test
    public void completeBinStrTest2() {
        // Tests floating point number
    }
}
