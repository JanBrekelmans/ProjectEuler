package projecteuler.library;

import java.math.BigInteger;

public class Fraction implements Comparable<Fraction> {
    private final BigInteger numerator, denominator;

    public Fraction(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = numerator.gcd(denominator);

        if(denominator.signum() == -1) {
            denominator = denominator.negate();
            numerator = numerator.negate();
        }

        this.numerator = numerator.divide(gcd);
        this.denominator = denominator.divide(gcd);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Fraction other) {
            return numerator.equals(other.numerator) && denominator.equals(other.denominator);
        }
        return false;
    }

    @Override
    public int compareTo(Fraction o) {
        return numerator.multiply(o.denominator).compareTo(denominator.multiply(o.numerator));
    }

    @Override
    public int hashCode() {
        return numerator.hashCode() + denominator.hashCode();
    }
}
