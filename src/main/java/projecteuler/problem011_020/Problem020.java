package projecteuler.problem011_020;

import projecteuler.SolutionTemplate;
import projecteuler.library.Factorial;

import java.math.BigInteger;

public class Problem020 implements SolutionTemplate {
    public static void main(String[] args) {
        System.out.println(new Problem020().getSolution());
    }
    @Override
    public String getSolution() {
        BigInteger largeFactorial = Factorial.factorial(100);
        int total = 0;

        for(char c: largeFactorial.toString().toCharArray()) {
            total += (c - '0');
        }
        return Integer.toString(total);
    }
}
