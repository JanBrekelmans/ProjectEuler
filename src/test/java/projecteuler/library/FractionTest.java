package projecteuler.library;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FractionTest {
    @Test
    public void fractionEqualityTest() {
        Fraction f1 = new Fraction(BigInteger.valueOf(1), BigInteger.valueOf(2));
        Fraction f2 = new Fraction(BigInteger.valueOf(2), BigInteger.valueOf(4));

        assertEquals(f1, f2);
    }

    @Test public void fractionInequalitTest() {
        Fraction f1 = new Fraction(BigInteger.valueOf(1), BigInteger.valueOf(3));
        Fraction f2 = new Fraction(BigInteger.valueOf(2), BigInteger.valueOf(4));

        assertTrue(f1.compareTo(f2) < 0);
    }
}
