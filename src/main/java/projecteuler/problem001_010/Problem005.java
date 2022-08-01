package projecteuler.problem001_010;

import projecteuler.SolutionTemplate;
import projecteuler.library.Factorization;

import java.util.List;
import java.util.stream.LongStream;

public class Problem005 implements SolutionTemplate {
    public static void main(String[] args) {
        System.out.println(new Problem005().getSolution());
    }
    @Override
    public String getSolution() {
        List<Long> numbers = LongStream.range(1, 21).boxed().toList();
        long result = Factorization.lcm(numbers);

        return Long.toString(result);
    }
}
