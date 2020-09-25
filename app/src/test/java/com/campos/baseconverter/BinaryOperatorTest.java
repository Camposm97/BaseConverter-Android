package com.campos.baseconverter;

import com.campos.baseconverter.model.BinaryOperator;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryOperatorTest {
    @Test
    public void testFlipBits() {
        String s = "1001";
        BinaryOperator op = new BinaryOperator();
        char[] result = op.flipBits(s.toCharArray());
        char[] expected = {'0', '1', '1', '0'};
        assertArrayEquals(expected, result);
    }
}
