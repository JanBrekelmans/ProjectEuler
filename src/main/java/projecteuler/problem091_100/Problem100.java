package projecteuler.problem091_100;

import projecteuler.SolutionTemplate;
import projecteuler.library.NumberUtil;
import projecteuler.library.pells_equation.PellsEquationBigIntegerSolver;
import projecteuler.library.pells_equation.PellsEquationsSolver;
import projecteuler.library.Util;

import java.math.BigInteger;

public class Problem100 implements SolutionTemplate {
    private final static long LIMIT = 1_000_000_000_000L;
    public static void main(String[] args) {
        System.out.println(new Problem100().getSolution());
    }

    /**
     * The equation b/(b+r) * (b-1)/(b+r-1) = 1/2 can be written as
     * b = 1/2 * (sqrt(8*r*r + 1) + 2*r + 1).<br>
     * As sqrt(8*r*r + 1) needs to be an integer, we have 8*r*r + 1 = x*x, or x*x - 8*r*r = 1, which is a Pell's equation.<br>
     * The fundamental solution is given by (3,1), and from this the (b,r) pair can be determined. We will generate new pairs until
     *  b+r > 10^12.
     * @return
     */

    @Override
    public String getSolution() {
        PellsEquationBigIntegerSolver pellsEquationsSolver = new PellsEquationBigIntegerSolver(3, 1, 8);
        Util.Pair<BigInteger, BigInteger> solutionPair = pellsEquationsSolver.nextSolution();
        BigInteger r = solutionPair.b();
        BigInteger b = solveForB(r);
        while(r.add(b).compareTo(BigInteger.valueOf(LIMIT)) < 0) {
            solutionPair = pellsEquationsSolver.nextSolution();
            r = solutionPair.b();
            b = solveForB(r);
        }

        return b.toString();
    }

    private BigInteger solveForB(BigInteger r) {
        BigInteger sqrt = NumberUtil.integerSquareRoot(r.multiply(r).multiply(BigInteger.valueOf(8)).add(BigInteger.ONE));
        return (sqrt.add(BigInteger.TWO.multiply(r)).add(BigInteger.ONE)).divide(BigInteger.TWO);
    }
}
