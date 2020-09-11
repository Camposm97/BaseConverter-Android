package com.campos.baseconverter;

import com.campos.baseconverter.model.Base;
import com.campos.baseconverter.model.BaseConverter;
import com.campos.baseconverter.model.BaseNumber;
import com.campos.baseconverter.model.InvalidBaseNumberException;

import org.junit.Test;

import java.nio.file.LinkPermission;

import static org.junit.Assert.*;

public class BaseConverterTest {
    @Test
    public void convertTest() throws InvalidBaseNumberException {
        String value = "0";
        BaseNumber input = new BaseNumber(Base.BASE_10, value);
        BaseConverter converter = new BaseConverter(input, Base.BASE_2);
        BaseNumber result = converter.convert();
        System.out.println(result);
    }

    @Test
    public void convertBinaryToDecimal() throws InvalidBaseNumberException {
        String input = "10001";
        BaseNumber baseNumber = new BaseNumber(Base.BASE_2, input);
        BaseConverter baseConverter = new BaseConverter(baseNumber);
        BaseNumber result = baseConverter.convertToDecimal(baseNumber);
        assertEquals("17", result.getValue());
    }

    @Test
    public void convertHexToDecimal() throws InvalidBaseNumberException {
        String input = "11"; // Which equals 17 in decimal
        BaseNumber baseNumber = new BaseNumber(Base.BASE_16, input);
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
        BaseNumber baseNumber = new BaseNumber(Base.BASE_10, input);
        BaseConverter baseConverter = new BaseConverter(baseNumber);
        BaseNumber result = baseConverter.convertDecimalToBase(baseNumber, Base.BASE_2);
        assertEquals("10110", result.getValue());
    }

    @Test
    public void convertDecimalToHex() throws InvalidBaseNumberException {
        String input = "26";
        BaseNumber baseNumber = new BaseNumber(Base.BASE_10, input);
        BaseConverter baseConverter = new BaseConverter(baseNumber);
        BaseNumber result = baseConverter.convertDecimalToBase(baseNumber, Base.BASE_16);
        assertEquals("1A", result.getValue());
    }

    @Test
    public void convertDecimalToOctal() throws InvalidBaseNumberException {
        String input = "22";
        BaseNumber baseNumber = new BaseNumber(Base.BASE_10, input);
        BaseConverter baseConverter = new BaseConverter(baseNumber);
        BaseNumber result = baseConverter.convertDecimalToBase(baseNumber, Base.BASE_8);
        assertEquals("26", result.getValue());
    }

    @Test
    public void convertBinaryToHex() throws InvalidBaseNumberException {
        String strBin = "11010";
        BaseNumber input = new BaseNumber(Base.BASE_2, strBin);
        BaseConverter baseConverter = new BaseConverter(input);
        baseConverter.setConvertTo(Base.BASE_16);
        BaseNumber result = baseConverter.convert();
        assertEquals("1A", result.getValue());
    }

    @Test
    public void convertOctalToBinary() throws InvalidBaseNumberException {
        String strOctal = "77";
        BaseNumber baseNumber = new BaseNumber(Base.BASE_8, strOctal);
        BaseConverter baseConverter = new BaseConverter(baseNumber);
        baseConverter.setConvertTo(Base.BASE_2);
        BaseNumber result = baseConverter.convert();
        assertEquals("111111", result.getValue());
    }

    @Test
    public void convertHexToHex() throws InvalidBaseNumberException {
        String strHex = "A117";
        BaseNumber input = new BaseNumber(Base.BASE_16, strHex);
        Base convertTo = Base.BASE_16;
        BaseConverter baseConverter = new BaseConverter(input, convertTo);
        BaseNumber result = baseConverter.convert();
        assertEquals("A117", result.getValue());
    }

    @Test
    public void getMainResults() throws InvalidBaseNumberException {
        String strBin = "1111";
        BaseNumber input= new BaseNumber(Base.BASE_2, strBin);
        BaseConverter baseConverter = new BaseConverter(input);
        BaseNumber[] results = baseConverter.getMainResults();
        String[] expectedResults = {"1111", "17", "15", "F"};
        for (int i = 0; i < results.length; i++) {
            assertEquals(expectedResults[i], results[i].getValue());
        }
    }

    @Test
    public void getAllResults() throws InvalidBaseNumberException {
        String strBin = "100011";
        BaseNumber input = new BaseNumber(Base.BASE_2, strBin);
        BaseConverter baseConverter = new BaseConverter(input);
        BaseNumber[] results = baseConverter.getAllResults();
        String[] expectedResults = {"100011", "1022", "203", "120", "55", "50", "43", "38", "35",
                "32", "2B", "29", "27", "25", "23", "21", "1H", "1G", "1F", "1E", "1D", "1C", "1B",
                "1A", "19", "18", "17", "16", "15", "14", "13", "12", "11", "10", "Z"};
        for (int i = 0; i < results.length; i++) {
            assertEquals(expectedResults[i], results[i].getValue());
        }
    }
}
