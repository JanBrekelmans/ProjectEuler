package projecteuler.problem041_050;

import projecteuler.SolutionTemplate;

import java.math.BigInteger;

public class Problem048 implements SolutionTemplate {
    private final static int LIMIT = 1000;

    public static void main(String[] args) {
        System.out.println(new Problem048().getSolution());
    }

    @Override
    public String getSolution() {
        BigInteger result = BigInteger.ZERO;
        BigInteger modulus = BigInteger.valueOf(10000000000L);

        for(int i = 1; i <= LIMIT; i++) {
            BigInteger a = BigInteger.valueOf(i).pow(i).mod(modulus);
            result = result.add(a).mod(modulus);
        }

        return result.toString();
    }
}
