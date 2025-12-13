package com.education.ztu;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

import Classes.Operations;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class OperationTest {

    @Test
    public void testAddition() {
        Assert.assertEquals(10.0, Operations.addition(1, 2, 3, 4), 0.001);
    }

    @Test
    public void testSubtraction() {
        assertEquals(0.0, Operations.subtraction(10, 5, 5), 0.001);
    }

    @Test
    public void testMultiplication() {
        assertEquals(24.0, Operations.multiplication(2, 3, 4), 0.001);
    }

    @Test
    public void testDivision() {
        assertEquals(2.0, Operations.division(8, 2, 2), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        Operations.division(1, 0);
    }

    @Test
    public void testAverage() {
        assertEquals(2.5, Operations.average(1, 2, 3, 4), 0.001);
    }

    @Test
    public void testMaximum() {
        assertEquals(4.0, Operations.maximum(1, 2, 3, 4), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaximumNoNumbers() {
        Operations.maximum();
    }

    @Test
    public void testMinimum() {
        assertEquals(1.0, Operations.minimum(1, 2, 3, 4), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinimumNoNumbers() {
        Operations.minimum();
    }

    @Test
    @Parameters({"1, 2, 3, 6", "2, 3, 4, 9"})
    public void testAdditionWithParams(double a, double b, double c, double expected) {
        assertThat(Operations.addition(a, b, c)).isEqualTo(expected);
    }
}