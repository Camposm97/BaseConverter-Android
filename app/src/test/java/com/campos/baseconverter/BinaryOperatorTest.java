package com.campos.baseconverter;

import com.campos.baseconverter.model.num.Base;
import com.campos.baseconverter.model.num.BaseNumber;
import com.campos.baseconverter.model.num.BinaryOperator;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BinaryOperatorTest {
    @Test
    public void testToSignMag() {
        BinaryOperator op = new BinaryOperator();
        String result = op.toSignMag("0111", true);
        String expected = "1111";
        assertEquals(expected, result);
    }

    @Test
    public void testToOnesComp() {
        BinaryOperator op = new BinaryOperator();
        String result = op.toOnesComp("0101");
        String expected = "1010";
        assertEquals(expected, result);
    }

    @Test
    public void testToTwosComp() {
        BinaryOperator op = new BinaryOperator();
        String result = op.toTwosComp("1001");
        String expected = "0111";
        assertEquals(expected, result);
    }

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
