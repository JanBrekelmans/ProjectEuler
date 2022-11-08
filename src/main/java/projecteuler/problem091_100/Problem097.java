package projecteuler.problem091_100;

import projecteuler.SolutionTemplate;

import java.math.BigInteger;

public class Problem097 implements SolutionTemplate {
    private final static int C = 28433;
    private final static int E = 7830457;

    public static void main(String[] args) {
        System.out.println(new Problem097().getSolution());
    }

    @Override
    public String getSolution() {
        BigInteger modulus = BigInteger.TEN.pow(10);

        BigInteger exponent = BigInteger.valueOf(2).pow(E).mod(modulus);
        BigInteger num = BigInteger.valueOf(C).multiply(exponent).add(BigInteger.ONE).mod(modulus);

        return num.toString();
    }
}
