package projecteuler.library.pells_equation;

import projecteuler.library.Util;

import java.math.BigInteger;

public class PellsEquationBigIntegerSolver {
    public final BigInteger x1, y1;
    public final BigInteger n;
    public BigInteger xk, yk;
    public long k;

    public PellsEquationBigIntegerSolver(BigInteger x1, BigInteger y1, BigInteger n) {
        this.x1 = x1;
        this.y1 = y1;
        this.n = n;
        reset();
    }

    public PellsEquationBigIntegerSolver(long x1, long y1, long n) {
        this(BigInteger.valueOf(x1), BigInteger.valueOf(y1), BigInteger.valueOf(n));
    }

    public Util.Pair<BigInteger, BigInteger> nextSolution() {
        if(k++ == 1) {
            return new Util.Pair<>(x1, y1);
        }
        BigInteger xt = x1.multiply(xk).add(n.multiply(y1).multiply(yk));
        BigInteger yt = x1.multiply(yk).add(y1.multiply(xk));
        xk = xt;
        yk = yt;
        return new Util.Pair<>(xk, yk);
    }

    public void reset() {
        k = 1;
        xk = x1;
        yk = y1;
    }
}
