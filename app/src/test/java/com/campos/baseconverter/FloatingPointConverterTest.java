package com.campos.baseconverter;

import com.campos.baseconverter.model.Base;
import com.campos.baseconverter.model.BaseNumber;
import com.campos.baseconverter.model.InvalidBaseNumberException;
import com.campos.baseconverter.model.FloatingPointerConverter;

import org.junit.Test;

public class FloatingPointConverterTest {
    @Test
    public void convertToBinStrTest() throws InvalidBaseNumberException {
        BaseNumber number = new BaseNumber(Base.BASE_10, "15.125");
        FloatingPointerConverter precisionConverter = new FloatingPointerConverter(number);
        String result = precisionConverter.convertToBinStr();
        System.out.println("before: " + number.getValue());
        System.out.println("after: " + result);
    }

    @Test
    public void convertToDecTest() throws InvalidBaseNumberException {
        BaseNumber number = new BaseNumber(Base.BASE_16, "A.A");
        FloatingPointerConverter precisionConverter = new FloatingPointerConverter(number);
        String result = precisionConverter.convertToDec();
        System.out.println(result);
    }

    public void convertTest() throws InvalidBaseNumberException{
        BaseNumber number = new BaseNumber(Base.BASE_10, "15.125");
        FloatingPointerConverter converter = new FloatingPointerConverter(number);
        String result = converter.convert();
    }
}
