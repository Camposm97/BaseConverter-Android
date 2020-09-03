package com.campos.baseconverter;

import org.junit.Test;

import static com.campos.baseconverter.util.MyUtils.*;
import static org.junit.Assert.assertEquals;

public class MyUtilsTest {
    @Test
    public void completeBinStrTest() {
        String binStr = "10";
        String result = completeBinStr(binStr);
        assertEquals("0010", result);
    }
}
