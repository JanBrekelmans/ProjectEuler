package projecteuler.problem011_020;

import projecteuler.SolutionTemplate;
import projecteuler.library.Factorial;

public class Problem015 implements SolutionTemplate {
    public static void main(String[] args) {
        System.out.println(new Problem015().getSolution());
    }

    @Override
    public String getSolution() {
        return Factorial.binomial(40,20).toString();
    }
}
