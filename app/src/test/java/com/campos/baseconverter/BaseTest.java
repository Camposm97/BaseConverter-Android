package com.campos.baseconverter;

import com.campos.baseconverter.model.num.BaseNumber;

import org.junit.Test;

import static com.campos.baseconverter.model.num.Base.BASE_2;
import static com.campos.baseconverter.model.num.Base.isValidBaseNum;
import static org.junit.Assert.assertEquals;

public class BaseTest {
    @Test
    public void testIsValidBaseNum() {
        BaseNumber input = new BaseNumber(BASE_2, "1.01");
        assertEquals(true, isValidBaseNum(input));
    }
}
