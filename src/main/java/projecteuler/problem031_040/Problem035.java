package projecteuler.problem031_040;

import projecteuler.SolutionTemplate;
import projecteuler.library.PrimeUtil;

import java.util.ArrayList;
import java.util.List;

public class Problem035 implements SolutionTemplate {
    private final static int LIMIT = 1_000_000;

    public static void main(String[] args) {
        System.out.println(new Problem035().getSolution());
    }

    @Override
    public String getSolution() {
        boolean[] sieve = PrimeUtil.primeSieve(LIMIT);
        List<Integer> primes = PrimeUtil.getPrimesUntil(LIMIT);

        int total = 0;

        for(int prime: primes) {
            if(!sieve[prime]) continue;

            int temp = 0;

            for(Integer maybePrime: getCirculars(prime)) {
                temp += sieve[maybePrime] ? 1: 0;
                sieve[maybePrime] = false;
            }

            if(temp == getCirculars(prime).size()){
                total += temp;
            }
        }

        return Integer.toString(total);
    }

    private List<Integer> getCirculars(int prime) {
        int digits = 0;
        int mag = 1;
        int number = prime;

        while(number > 0) {
            digits++;
            number /= 10;
            mag *= 10;
        }

        mag /= 10;

        int maybePrime = prime;
        List<Integer> maybePrimes = new ArrayList<>();
        for(int i = 0; i < digits; i++) {
            maybePrimes.add(maybePrime);
            maybePrime = mag*(maybePrime % 10) + maybePrime / 10;
            if(maybePrime == prime) break;
        }

        return maybePrimes;
    }
}
