package com.campos.baseconverter;

import com.campos.baseconverter.model.BinaryOperator;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BinaryOperatorTest {
    @Test
    public void testFlipBits() {
        String s = "1001";
        BinaryOperator op = new BinaryOperator();
        char[] result = op.flipBits(s.toCharArray());
        char[] expected = "0110".toCharArray();
        assertArrayEquals(expected, result);
    }

    @Test
    public void testAddOne1() {
        String s = "1001";
        BinaryOperator op = new BinaryOperator();
        char[] result = op.addOne(s.toCharArray());
        char[] expected = "1010".toCharArray();
        assertArrayEquals(expected, result);
    }

    @Test
    public void testAddOne2() {
        String s = "1111";
        BinaryOperator op = new BinaryOperator();
        char[] result = op.addOne(s.toCharArray());
        char[] expected = "0000".toCharArray();
        assertArrayEquals(expected, result);
    }
}
