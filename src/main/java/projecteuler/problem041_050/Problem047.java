package projecteuler.problem041_050;

import projecteuler.SolutionTemplate;
import projecteuler.library.PrimeUtil;

import java.util.List;

public class Problem047 implements SolutionTemplate {
    private final static int LIMIT = 1_000_000;

    public static void main(String[] args) {
        System.out.println(new Problem047().getSolution());
    }

    @Override
    public String getSolution() {
        int[] primeFactors = new int[LIMIT];

        for(int i = 2; i < LIMIT; i++) {
            if(primeFactors[i] == 0) {
                for(int j = i; j < LIMIT; j += i) {
                    primeFactors[j]++;
                }
            }
        }

        for(int i = 644; i < LIMIT; i++) {
            if(primeFactors[i] == 4) {
                boolean consecutive = true;
                for(int j = 0; j < 4 && i+j < LIMIT; j++) {
                    if(primeFactors[i+j] != 4) consecutive = false;
                }
                if(consecutive) return Integer.toString(i);
            }
        }
        return null;
    }
}
