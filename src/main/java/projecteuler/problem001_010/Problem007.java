package projecteuler.problem001_010;

import projecteuler.SolutionTemplate;
import projecteuler.library.Primes;

import java.util.Arrays;

public class Problem007 implements SolutionTemplate {
    private final static int INDEX = 10_001;

    public static void main(String[] args) {
        System.out.println(new Problem007().getSolution());
    }
    @Override
    public String getSolution() {
        int upperBound = Primes.getUpperBoundForNthPrime(INDEX);

        return Integer.toString(Primes.getPrimesUntil(upperBound).get(INDEX-1));
    }
}
