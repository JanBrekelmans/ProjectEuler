package projecteuler.problem021_030;

import projecteuler.SolutionTemplate;

import java.math.BigInteger;

public class Problem025 implements SolutionTemplate {
    private final static int NUMBER_LENGTH = 1_000;

    public static void main(String[] args) {
        System.out.println(new Problem025().getSolution());
    }

    @Override
    public String getSolution() {
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        int index = 1;

        while(a.toString().length() < NUMBER_LENGTH) {
            BigInteger temp = b;
            b = b.add(a);
            a = temp;
            index++;
        }

        return Integer.toString(index);
    }
}
