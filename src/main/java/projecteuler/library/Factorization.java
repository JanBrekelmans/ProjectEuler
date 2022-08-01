package projecteuler.library;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Factorization {
    public static ArrayList<Long> getFactors(long n) {
        ArrayList<Long> factors = new ArrayList<>();

        if(n < 0) n = -n;
        if(n > 1) {
            while (n % 2L == 0) {
                factors.add(2L);
                n /= 2L;
            }

            for(long i = 3L; i < n; i+=2L) {
                while(n%i == 0) {
                    factors.add(i);
                    n /= i;
                }
                if(n == 1L) {
                    break;
                }
            }

            if(n != 1L)factors.add(n);
        }
        return factors;
    }

    public static Set<Long> getFactorSet(long n) {
        return new HashSet<>(getFactors(n));
    }

    public static long gcd(long a, long b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }

    public static long lcm(List<Long> numbers) {
        long result = 1;
        for(long n: numbers) {
            result = result * (n/gcd(n, result));
        }

        return result;
    }
}
