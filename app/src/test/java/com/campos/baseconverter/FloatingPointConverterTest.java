package com.campos.baseconverter;

import com.campos.baseconverter.model.Base;
import com.campos.baseconverter.model.BaseNumber;
import com.campos.baseconverter.model.FloatingPointerConverter;
import com.campos.baseconverter.model.InvalidBaseNumberException;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FloatingPointConverterTest {
    @Test
    public void convertTest1() throws InvalidBaseNumberException {
        final String expectedValue1 = "1111.001";
        final String expectedValue2 = "15.125";
        BaseNumber input = new BaseNumber(Base.BASE_10, "15.125");
        Base convertTo1 = Base.BASE_2;
        Base convertTo2 = Base.BASE_10;
        FloatingPointerConverter converter = new FloatingPointerConverter(input);
        converter.setScale(3);
        BaseNumber result1 = converter.convert(convertTo1);
        converter.setInput(result1);
        BaseNumber result2 = converter.convert(convertTo2);
        assertEquals(expectedValue1, result1.getValue());
        assertEquals(expectedValue2, result2.getValue());
    }
}
