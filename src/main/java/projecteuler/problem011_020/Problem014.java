package projecteuler.problem011_020;

import projecteuler.SolutionTemplate;

public class Problem014 implements SolutionTemplate {
    private final static int LIMIT = 1_000_000;
    private final static int CACHE_SIZE = 1_000_000;
    private long[] cache = new long[CACHE_SIZE+1];

    public static void main(String[] args) {
        System.out.println(new Problem014().getSolution());
    }

    @Override
    public String getSolution() {
        for(int i = 0; i <= CACHE_SIZE; i++) {
            cache[i] = -1;
        }

        int longest_index = -1;
        long longest_chain = -1;

        for(int i = 2; i < LIMIT; i++) {
            long current_chain = findSequenceLength(i);
            if(current_chain > longest_chain) {
                longest_chain = current_chain;
                longest_index = i;
            }
        }

        return Integer.toString(longest_index);
    }

    private long findSequenceLength(long n) {
        if(n < 0){
            throw new IllegalArgumentException("Negative number");
        }
        if(n == 1) return 0;

        if(n <= CACHE_SIZE) {
            int m = (int) n;
            if(cache[m] != -1) {
                return cache[m];
            }
            long result = findSequenceLength(nextCollatz(m)) + 1;
            cache[m] = result;
            return result;

        } else {
            return findSequenceLength(nextCollatz(n)) + 1;
        }
    }

    private long nextCollatz(long n) {
        if(n%2 == 0) {
            return n/2;
        }
        return 3*n+1;
    }
}
