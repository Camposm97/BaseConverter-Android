package com.campos.baseconverter;

import com.campos.baseconverter.model.Base;
import com.campos.baseconverter.model.BaseConverter;
import com.campos.baseconverter.model.BaseNumber;
import com.campos.baseconverter.model.InvalidBaseNumberException;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BaseConverterTest {
    @Test
    public void convertBinaryToDecimal() {

        String input = "10001";
        BaseNumber baseNumber = new BaseNumber(Base.BINARY, input);
        BaseConverter baseConverter = new BaseConverter();
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

    @Test
    public void convertDecimalToBinary() {
        BaseConverter baseConverter = new BaseConverter();
        String input = "22";
        String result = baseConverter.convertDecimalToBase(input, Base.BINARY);
        assertEquals("10110", result);
    }

    @Test
    public void convertDecimalToHexadecimal() {
        BaseConverter baseConverter = new BaseConverter();
        String input = "26";
        String result = baseConverter.convertDecimalToBase(input, Base.HEXADECIMAL);
        assertEquals("1A", result);
    }

    @Test
    public void convertDecimalToOctal() {
        BaseConverter baseConverter = new BaseConverter();
        String input = "22";
        String result = baseConverter.convertDecimalToBase(input, Base.OCTAL);
        assertEquals("26", result);
    }

    @Test
    public void convertBinaryToHex() throws InvalidBaseNumberException {
        BaseConverter baseConverter = new BaseConverter();
        String strBin = "11010";
        baseConverter.setInput(strBin);
        baseConverter.setConvertFrom(Base.BINARY);
        baseConverter.setConvertTo(Base.HEXADECIMAL);
        String result = baseConverter.convert();
        assertEquals("1A", result);
    }

    @Test
    public void convertOctalToBinary() throws InvalidBaseNumberException {
        BaseConverter baseConverter = new BaseConverter();
        String strOctal = "77";
        baseConverter.setInput(strOctal);
        baseConverter.setConvertFrom(Base.OCTAL);
        baseConverter.setConvertTo(Base.BINARY);
        String result = baseConverter.convert();
        assertEquals("111111", result);
    }

    @Test
    public void convertHexToHex() throws InvalidBaseNumberException {
        String input = "S117";
        Base convertFrom = Base.HEXADECIMAL;
        Base convertTo = Base.HEXADECIMAL;
        BaseConverter baseConverter = new BaseConverter(convertFrom, convertTo, input);
        String result = baseConverter.convert();
        assertEquals("S117", result);
    }

    @Test
    public void getMainResults() throws InvalidBaseNumberException {
        String input = "1111";
        BaseConverter baseConverter = new BaseConverter();
        baseConverter.setConvertFrom(Base.BINARY);
        baseConverter.setInput(input);
        String[] results = baseConverter.getMainResults();
        String[] expectedResults = {"1111", "17", "15", "F"};
        System.out.println(Arrays.toString(results));
        assertArrayEquals(expectedResults, results);
    }

    @Test
    public void getAllResults() throws InvalidBaseNumberException {
        String input = "100011";
        BaseConverter baseConverter = new BaseConverter();
        baseConverter.setConvertFrom(Base.BINARY);
        baseConverter.setInput(input);
        String[] results = baseConverter.getAllResults();
        String[] expectedResults = {"100011", "1022", "203", "120", "55", "50", "43", "38", "35",
                "32", "2B", "29", "27", "25", "23", "21", "1H", "1G", "1F", "1E", "1D", "1C", "1B",
                "1A", "19", "18", "17", "16", "15", "14", "13", "12", "11", "10", "Z"};
//        System.out.println(Arrays.toString(results));
        assertArrayEquals(expectedResults, results);
    }
}
