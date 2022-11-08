package projecteuler.problem031_040;

import projecteuler.SolutionTemplate;
import projecteuler.library.Primes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Problem037 implements SolutionTemplate {
    private final static int LIMIT = 10_000_000;

    public static void main(String[] args) {
        System.out.println(new Problem037().getSolution());
    }

    @Override
    public String getSolution() {
        List<Integer> truncatablePrimes = new ArrayList<>();
        Deque<Integer> maybeTruncatablePrimes = new ArrayDeque<>(List.of(3,7));

        List<Integer> suffixTerms = List.of(1,2,3,5,7,9);

        int counter = 0;
        while(truncatablePrimes.size() < 11 && counter++ < 1_000_000) {
            int maybePrime = maybeTruncatablePrimes.poll();
            if(Primes.isPrime(maybePrime)) {
                for(Integer suffix: suffixTerms) {
                    int maybeNewPrime = suffix*getMagnitude(maybePrime)*10 + maybePrime;
                    maybeTruncatablePrimes.add(maybeNewPrime);
                }

                if(maybePrime > 10 && isRightTruncatablePrime(maybePrime)) {
                    truncatablePrimes.add(maybePrime);
                }
            }
        }

        return Integer.toString(truncatablePrimes.stream().reduce((a,b) -> a+b).get());
    }

    private boolean isRightTruncatablePrime(int n) {
        while(n > 0) {
            if(!Primes.isPrime(n)) return false;
            n /= 10;
        }
        return true;
    }

    private int getMagnitude(int n) {
        int multiplier = 1;
        while(n >= 10) {
            multiplier *= 10;
            n /= 10;
        }

        return multiplier;
    }
}
