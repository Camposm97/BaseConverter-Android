package com.campos.baseconverter;

import com.campos.baseconverter.model.num.FloatingPointConverter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FloatingPointConverterTest {
    /*
    TODO:
     - If you pass a value of 0.0 and pass that into formatBinStr, it will crash the program (StringIndexOutOfBounds)
     */
    @Test
    public void testToSinglePrecision1() {
        String value = "101.001";
        FloatingPointConverter ieee754 = new FloatingPointConverter();
        ieee754.toSinglePrecision(value); // TODO finish this test
    }

    @Test
    public void testFormatBinStr1() {
        String value = "100.0";
        FloatingPointConverter ieee754 = new FloatingPointConverter();
        String[] arr = ieee754.formatBinStr(value);
        assertEquals("1.000", arr[0]);
        assertEquals("2", arr[1]);
    }

    @Test
    public void testFormatBinStr2() {
        String value = "0.01";
        FloatingPointConverter ieee754 = new FloatingPointConverter();
        String[] arr = ieee754.formatBinStr(value);
        assertEquals("1.0", arr[0]);
        assertEquals("-2", arr[1]);
    }

    @Test
    public void testFormatBinStr3() {
        String value = "1.01";
        FloatingPointConverter ieee754 = new FloatingPointConverter();
        String[] arr = ieee754.formatBinStr(value);
        assertEquals("1.01", arr[0]);
        assertEquals("0", arr[1]);
    }

    @Test
    public void testFormatBinStr4() {
        String value = "101.001";
        FloatingPointConverter ieee754 = new FloatingPointConverter();
        String[] arr = ieee754.formatBinStr(value);
        assertEquals("1.01001", arr[0]);
        assertEquals("2", arr[1]);
    }
}
