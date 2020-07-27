package com.campos.baseconverter;

import com.campos.baseconverter.model.Base;
import com.campos.baseconverter.model.BaseComparator;

import org.junit.Test;
import static org.junit.Assert.*;

public class BaseComparatorTest {
    @Test
    public void equalsZero() {
        int value = 0;
        BaseComparator baseComparator = new BaseComparator();
        Base[] arr = Base.values();
        for (Base base : arr) {
            value = baseComparator.compare(base, base);
            assertEquals(0, value);
        }
    }

    @Test
    public void equalsOne() {
        BaseComparator baseComparator = new BaseComparator();
        int value = baseComparator.compare(Base.BINARY, Base.DECIMAL);
        assertEquals(1, value); // 1 = We're converting to a higher base
    }

    @Test
    public void equalsNegativeOne() {
        BaseComparator baseComparator = new BaseComparator();
        int value = baseComparator.compare(Base.DECIMAL, Base.BINARY);
        assertEquals(-1, value); // 2 = We're converting to a lower base
    }
}
