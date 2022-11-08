package projecteuler.problem091_100;

import projecteuler.SolutionTemplate;

public class Problem092 implements SolutionTemplate {
    private final static int LIMIT = 10_000_000;

    private final static int CACHE_SIZE = 1_000;
    private final static int[] MEMOIZATION = new int[CACHE_SIZE + 1];

    public static void main(String[] args) {
        System.out.println(new Problem092().getSolution());
    }

    @Override
    public String getSolution() {
        MEMOIZATION[1] = 1;
        MEMOIZATION[89] = 89;

        int total = 0;

        for(int i = 1; i < LIMIT; i++) {
            if(computeChain(i) == 89) total++;
        }


        return Integer.toString(total);
    }

    private int computeChain(int n) {
        if(n <= CACHE_SIZE && MEMOIZATION[n] != 0) {
            return MEMOIZATION[n];
        }

        int sum = 0;
        while(n > 0) {
            long m = n % 10;
            sum += m*m;
            n /= 10;
        }

        int nextChain = computeChain(sum);
        if(nextChain <= CACHE_SIZE) {
            MEMOIZATION[n] = nextChain;
        }

        return nextChain;
    }
}
