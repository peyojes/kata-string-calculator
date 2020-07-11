package com.kata;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    public void emptyString_Add_return0() throws Exception {
        assertEquals(0, calculator.Add(""));
    }

    @Test
    public void one_Add_one() throws Exception {
        assertEquals(1, calculator.Add("1"));
    }

    @Test
    public void oneAndTwo_Add_Three() throws Exception {
        assertEquals(3, calculator.Add("1,2"));
    }

    @Test
    public void fourTwosome_Add_8() throws Exception {
        assertEquals(8, calculator.Add("2,2,2,2"));
    }

    @Test
    public void expressionWithTwoLines_Add_sumOfTwoExpressions() throws Exception {
        assertEquals(6, calculator.Add("1\n2,3"));
    }

    @Test
    public void expressionWithCommasAndNewLine_Add_zero() throws Exception {
        assertEquals(0, calculator.Add("1,\n2,3"));
    }

    @Test
    public void defineNewDelimiter_Add_normalBehaviourButChangedDelimiter() throws Exception {
        assertEquals(5, calculator.Add("//[;]\n1;4"));
    }

    @Test
    public void negativeNumber_Add_throwException() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("negatives not allowed");
        calculator.Add("-1,2");
    }

    @Test
    public void numberGreaterOneThousand_Add_zeroInsteadOfThousand() throws Exception {
        assertEquals(2, calculator.Add("1001,2"));
    }

    @Test
    public void defineNewDelimiterWithFewChar_Add_normalBehaviourWithChangedDelimiter() throws Exception {
        assertEquals(6, calculator.Add("//[***]\n1***2***3"));
    }

    @Test
    public void defineFewDelimiterWithChar_Add_normalBehaviourWithChangedDelimiter() throws Exception {
        assertEquals(6, calculator.Add("//[*][%]\n1*2%3"));
    }

    @Test
    public void defineFewDelimiterWithFewChar_Add_normalBehaviourWithChangedDelimiter() throws Exception {
        assertEquals(6, calculator.Add("//[***][%%]\n1***2%%3"));
    }

}
