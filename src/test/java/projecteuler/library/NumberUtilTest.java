package projecteuler.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberUtilTest {
    @Test public void integerSqrt0() {assertEquals(0, NumberUtil.integerSquareRoot(0));}
    @Test public void integerSqrt1() {assertEquals(1, NumberUtil.integerSquareRoot(1));}
    @Test public void integerSqrt2() {assertEquals(1, NumberUtil.integerSquareRoot(2));}
    @Test public void integerSqrt5() {assertEquals(2, NumberUtil.integerSquareRoot(5));}
    @Test public void integerSqrt100() {assertEquals(10, NumberUtil.integerSquareRoot(100));}
    @Test public void integerSqrt100001() {assertEquals(316, NumberUtil.integerSquareRoot(100001));}
    @Test public void integerSqrtIntMax() {assertEquals(46340, NumberUtil.integerSquareRoot(Integer.MAX_VALUE));}

}
