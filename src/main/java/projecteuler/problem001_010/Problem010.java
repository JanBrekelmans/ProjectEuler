package projecteuler.problem001_010;

import projecteuler.SolutionTemplate;
import projecteuler.library.Primes;

import java.util.List;

public class Problem010 implements SolutionTemplate {
    private final static int LIMIT = 2_000_000;

    public static void main(String[] args) {
        System.out.println(new Problem010().getSolution());
    }

    @Override
    public String getSolution() {
        List<Integer> primes = Primes.getPrimesUntil(LIMIT);

        long sum = primes.stream().map(Integer::longValue).reduce(0L, (a, b) -> a + b);
        return Long.toString(sum);
    }
}
