package projecteuler.problem001_010;

import projecteuler.SolutionTemplate;
import projecteuler.library.Factorization;

import java.util.Set;

public class Problem003 implements SolutionTemplate {
    private final static long NUMBER = 600_851_475_143L;

    public static void main(String[] args) {
        System.out.println(new Problem003().getSolution());
    }
    @Override
    public String getSolution() {
        Set<Long> factors = Factorization.getFactorSet(NUMBER);
        return factors.stream().max(Long::compare).get().toString();
    }
}
