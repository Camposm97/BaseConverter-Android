package com.campos.baseconverter;

import com.campos.baseconverter.model.Base;
import com.campos.baseconverter.model.BaseConverter;

import org.junit.Test;
import static org.junit.Assert.*;

public class BaseConverterTest {
    @Test
    public void convertBinaryToDecimal() {
        BaseConverter baseConverter = new BaseConverter();
        String input = "10001";
        String result = baseConverter.convertToDecimal(input, Base.BINARY);
        assertEquals("17", result);
    }

    @Test
    public void convertHexToDecimal() {
        BaseConverter baseConverter = new BaseConverter();
        String input = "11"; // Which equals 17 in decimal
        String result = baseConverter.convertToDecimal(input, Base.HEXADECIMAL);
        assertEquals("17", result);
    }

    @Test
    public void convertBase3ToDecimal() {
        BaseConverter baseConverter = new BaseConverter();
        String input = "21";
        String result = baseConverter.convertToDecimal(input, Base.BASE_3);
        assertEquals("7", result);
    }

}
