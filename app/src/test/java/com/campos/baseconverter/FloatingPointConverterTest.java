package com.campos.baseconverter;

import com.campos.baseconverter.model.Base;
import com.campos.baseconverter.model.BaseNumber;
import com.campos.baseconverter.model.InvalidBaseNumberException;
import com.campos.baseconverter.model.FloatingPointerConverter;

import org.junit.Test;

import java.math.BigDecimal;

public class FloatingPointConverterTest {
    @Test
    public void convertTest() throws InvalidBaseNumberException {
        BaseNumber number = new BaseNumber(Base.BASE_10, "15.125");
        System.out.println(number);
        Base convertTo = Base.BASE_36;
        FloatingPointerConverter converter = new FloatingPointerConverter(number);
        converter.setPrecision(2);
        BaseNumber result = converter.convert(convertTo);
        System.out.println(result);
        FloatingPointerConverter converter1 = new FloatingPointerConverter(result);
        System.out.println(converter1.convert(Base.BASE_10));
    }
}
