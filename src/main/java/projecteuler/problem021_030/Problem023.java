package projecteuler.problem021_030;

import projecteuler.SolutionTemplate;
import projecteuler.library.Factorization;

import java.util.List;
import java.util.stream.IntStream;

public class Problem023 implements SolutionTemplate {
    private final static int LOWER_LIMIT = 12;
    private final static int UPPER_LIMIT = 28_124;

    public static void main(String[] args) {
        System.out.println(new Problem023().getSolution());
    }

    @Override
    public String getSolution() {
        int[] abundantNumbers = IntStream.range(LOWER_LIMIT, UPPER_LIMIT).filter(i -> Factorization.getSumOfProperDivisors(i) > i).toArray();
        boolean[] canBeWrittenAsSum = new boolean[UPPER_LIMIT];

        canBeWrittenAsSum[0] = true;

        for(int i = 0; i < abundantNumbers.length; i++) {
            for(int j = i; j < abundantNumbers.length; j++) {
                int sum = abundantNumbers[i] + abundantNumbers[j];
                if(sum >= UPPER_LIMIT) break;
                canBeWrittenAsSum[sum] = true;
            }
        }

        int total = 0;
        for(int i = 0; i < canBeWrittenAsSum.length; i++) {
            if(!canBeWrittenAsSum[i]) total += i;
        }

        return Integer.toString(total);
    }
}
