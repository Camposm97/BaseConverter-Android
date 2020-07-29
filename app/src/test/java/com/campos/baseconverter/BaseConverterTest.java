package com.campos.baseconverter;

import com.campos.baseconverter.model.Base;
import com.campos.baseconverter.model.BaseConverter;

import org.junit.Test;
import static org.junit.Assert.*;

public class BaseConverterTest {
    @Test
    public void convertToDecimal() {
        BaseConverter baseConverter = new BaseConverter();
        String input = "1010";
        String result = baseConverter.convertToDecimal("1010", Base.BINARY);
        assertEquals("10", result);
    }
}
