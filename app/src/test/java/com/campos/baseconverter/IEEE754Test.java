package com.campos.baseconverter;

import com.campos.baseconverter.model.Base;
import com.campos.baseconverter.model.BaseNumber;
import com.campos.baseconverter.model.IEEE754;

import org.junit.Test;

public class IEEE754Test {
    @Test
    public void method() {
        IEEE754 ieee754 = new IEEE754();
        BaseNumber input = new BaseNumber(Base.BASE_2, "1110.101");
        ieee754.toSinglePrecision(input);
    }
}
