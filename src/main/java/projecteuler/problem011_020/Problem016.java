package projecteuler.problem011_020;

import projecteuler.SolutionTemplate;

import java.math.BigInteger;

public class Problem016 implements SolutionTemplate {
    public static void main(String[] args) {
        System.out.println(new Problem016().getSolution());
    }

    @Override
    public String getSolution() {
        BigInteger bigInteger = BigInteger.ONE.shiftLeft(1000);
        int total  = 0;

        for(char c: bigInteger.toString().toCharArray()) {
            total += (c - '0');
        }

        return Integer.toString(total);
    }
}
