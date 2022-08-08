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

    public static int getSumOfDivisors(int n) {
        int sum = 1;
        int p = 2;

        while(p*p <= n && n > 1) {
            if(n%p == 0) {
                int j = p*p;
                n /= p;
                while(n%p == 0) {
                    j *= p;
                    n /= p;
                }
                sum *= (j-1);
                sum /= (p-1);
            }
            if(p == 2) {
                p = 3;
            } else {
                p += 2;
            }
        }

        if(n > 1) sum *= n+1;

        return sum;
    }

    public static int getSumOfProperDivisors(int n) {
        return getSumOfDivisors(n) - n;
    }
}
