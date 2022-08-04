package projecteuler.problem181_190;

import projecteuler.SolutionTemplate;
import projecteuler.library.Primes;

public class Problem187 implements SolutionTemplate {
    private final static int LIMIT = 100_000_000;
    public static void main(String[] args) {
        System.out.println(new Problem187().getSolution());
    }
    @Override
    public String getSolution() {
        var primes = Primes.getPrimesUntil(LIMIT/2);
        int total = 0;
        int lastIndex = 0;

        for(int i = 0; i < primes.size(); i++) {
            int p1 = primes.get(i);
            lastIndex = i;
            while(lastIndex < primes.size()-1 && p1 * primes.get(lastIndex) <= LIMIT){
                lastIndex++;
            }
            if(lastIndex == primes.size()-1) lastIndex++;

            total += lastIndex - i;
        }

        return Integer.toString(total);
    }
}
