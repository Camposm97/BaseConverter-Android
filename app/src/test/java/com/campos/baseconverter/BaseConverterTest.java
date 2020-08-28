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
    public void convertBinaryToDecimal() throws InvalidBaseNumberException {
        String input = "10001";
        BaseNumber baseNumber = new BaseNumber(Base.BINARY, input);
        BaseConverter baseConverter = new BaseConverter(baseNumber);
        BaseNumber result = baseConverter.convertToDecimal(baseNumber);
        assertEquals("17", result.getValue());
    }

    @Test
    public void convertHexToDecimal() throws InvalidBaseNumberException {
        String input = "11"; // Which equals 17 in decimal
        BaseNumber baseNumber = new BaseNumber(Base.HEXADECIMAL, input);
        BaseConverter baseConverter = new BaseConverter(baseNumber);
        BaseNumber result = baseConverter.convertToDecimal(baseNumber);
        assertEquals("17", result.getValue());
    }

    @Test
    public void convertBase3ToDecimal() throws InvalidBaseNumberException {
        String input = "21";
        BaseNumber baseNumber = new BaseNumber(Base.BASE_3, input);
        BaseConverter baseConverter = new BaseConverter(baseNumber);
        BaseNumber result = baseConverter.convertToDecimal(baseNumber);
        assertEquals("7", result.getValue());
    }

    @Test
    public void convertDecimalToBinary() throws InvalidBaseNumberException {
        String input = "22";
        BaseNumber baseNumber = new BaseNumber(Base.DECIMAL, input);
        BaseConverter baseConverter = new BaseConverter(baseNumber);
        BaseNumber result = baseConverter.convertDecimalToBase(baseNumber, Base.BINARY);
        assertEquals("10110", result.getValue());
    }

    @Test
    public void convertDecimalToHex() throws InvalidBaseNumberException {
        String input = "26";
        BaseNumber baseNumber = new BaseNumber(Base.DECIMAL, input);
        BaseConverter baseConverter = new BaseConverter(baseNumber);
        BaseNumber result = baseConverter.convertDecimalToBase(baseNumber, Base.HEXADECIMAL);
        assertEquals("1A", result.getValue());
    }

    @Test
    public void convertDecimalToOctal() throws InvalidBaseNumberException {
        String input = "22";
        BaseNumber baseNumber = new BaseNumber(Base.DECIMAL, input);
        BaseConverter baseConverter = new BaseConverter(baseNumber);
        BaseNumber result = baseConverter.convertDecimalToBase(baseNumber, Base.OCTAL);
        assertEquals("26", result.getValue());
    }

    @Test
    public void convertBinaryToHex() throws InvalidBaseNumberException {
        String strBin = "11010";
        BaseNumber input = new BaseNumber(Base.BINARY, strBin);
        BaseConverter baseConverter = new BaseConverter(input);
        baseConverter.setConvertTo(Base.HEXADECIMAL);
        BaseNumber result = baseConverter.convert();
        assertEquals("1A", result.getValue());
    }

    @Test
    public void convertOctalToBinary() throws InvalidBaseNumberException {
        String strOctal = "77";
        BaseNumber baseNumber = new BaseNumber(Base.OCTAL, strOctal);
        BaseConverter baseConverter = new BaseConverter(baseNumber);
        baseConverter.setConvertTo(Base.BINARY);
        BaseNumber result = baseConverter.convert();
        assertEquals("111111", result.getValue());
    }

//    @Test
//    public void convertHexToHex() throws InvalidBaseNumberException {
//        String input = "S117";
//        Base convertFrom = Base.HEXADECIMAL;
//        Base convertTo = Base.HEXADECIMAL;
//        BaseConverter baseConverter = new BaseConverter(convertFrom, convertTo, input);
//        String result = baseConverter.convert();
//        assertEquals("S117", result);
//    }

//    @Test
//    public void getMainResults() throws InvalidBaseNumberException {
//        String input = "1111";
//        BaseConverter baseConverter = new BaseConverter();
//        baseConverter.setConvertFrom(Base.BINARY);
//        baseConverter.setInput(input);
//        String[] results = baseConverter.getMainResults();
//        String[] expectedResults = {"1111", "17", "15", "F"};
//        System.out.println(Arrays.toString(results));
//        assertArrayEquals(expectedResults, results);
//    }

//    @Test
//    public void getAllResults() throws InvalidBaseNumberException {
//        String input = "100011";
//        BaseConverter baseConverter = new BaseConverter();
//        baseConverter.setConvertFrom(Base.BINARY);
//        baseConverter.setInput(input);
//        String[] results = baseConverter.getAllResults();
//        String[] expectedResults = {"100011", "1022", "203", "120", "55", "50", "43", "38", "35",
//                "32", "2B", "29", "27", "25", "23", "21", "1H", "1G", "1F", "1E", "1D", "1C", "1B",
//                "1A", "19", "18", "17", "16", "15", "14", "13", "12", "11", "10", "Z"};
////        System.out.println(Arrays.toString(results));
//        assertArrayEquals(expectedResults, results);
//    }
}
