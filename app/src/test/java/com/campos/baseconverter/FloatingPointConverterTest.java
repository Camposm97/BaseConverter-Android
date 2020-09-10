package com.campos.baseconverter;

import com.campos.baseconverter.model.Base;
import com.campos.baseconverter.model.BaseNumber;
import com.campos.baseconverter.model.InvalidBaseNumberException;
import com.campos.baseconverter.model.FloatingPointerConverter;

import org.junit.Test;

public class FloatingPointConverterTest {
    @Test
    public void convertToBinTest() throws InvalidBaseNumberException {
        BaseNumber number = new BaseNumber(Base.BASE_10, "15.125");
        FloatingPointerConverter converter = new FloatingPointerConverter(number);
        BaseNumber result = converter.convert(Base.BASE_2);
        System.out.println("before: " + number);
        System.out.println("after: " + result);
    }

    @Test
    public void convertToDecTest() throws InvalidBaseNumberException {
        BaseNumber number = new BaseNumber(Base.BASE_16, "A.A");
        FloatingPointerConverter converter = new FloatingPointerConverter(number);
        String result = converter.convertToDec();
        System.out.println(result);
    }

    @Test
    public void convertTest() throws InvalidBaseNumberException{
        BaseNumber number = new BaseNumber(Base.BASE_10, "15.125");
        Base convertTo = Base.BASE_10;
        FloatingPointerConverter converter = new FloatingPointerConverter(number);
        BaseNumber result = converter.convert(convertTo);
        System.out.println(result);
    }
}
