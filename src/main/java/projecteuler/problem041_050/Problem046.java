package projecteuler.problem041_050;

import projecteuler.SolutionTemplate;
import projecteuler.library.NumberUtil;
import projecteuler.library.PrimeUtil;

import java.util.List;

public class Problem046 implements SolutionTemplate {
    private final static int LIMIT = 1_000_000;
    private final List<Integer> PRIMES = PrimeUtil.getPrimesUntil(LIMIT);

    public static void main(String[] args) {
        System.out.println(new Problem046().getSolution());
    }

    @Override
    public String getSolution() {
        int oddNumber = 7;

        while(true) {
            oddNumber += 2;

            if(PrimeUtil.isPrime(oddNumber)) continue;

            boolean found = true;
            for(Integer prime: PRIMES) {
                if(prime >= oddNumber) break;

                int squareRoot = NumberUtil.integerSquareRoot((oddNumber - prime)/2);
                if(oddNumber == prime + 2*squareRoot*squareRoot) {
                    found = false;
                }
            }

            if(found) break;

        }

        return Integer.toString(oddNumber);
    }
}
