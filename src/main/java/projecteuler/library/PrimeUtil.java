package projecteuler.library;

import java.util.ArrayList;
import java.util.List;

public class PrimeUtil {
    public static int getUpperBoundForNthPrime(int n) {
        if(n <= 6) return 6;
        return (int) (n*(Math.log(n) + Math.log(Math.log(n))));
    }

    public static boolean[] primeSieve(int n) {
        boolean[] result = new boolean[n+1];
        for(int i = 2; i <= n; i++) {
            result[i] = true;
        }
        result[0] = false;
        result[1] = false;

        for(int i = 2; i <= n; i++) {
            if(result[i]) {
                for(int j = 2*i; j <= n; j+= i) {
                    result[j] = false;
                }
            }
        }

        return result;
    }

    public static List<Integer> getPrimesUntil(int n) {
        List<Integer> result = new ArrayList<>();

        boolean[] primeSieve = primeSieve(n);

        for(int i = 2; i <= n; i++) {
            if(primeSieve[i]) result.add(i);
        }

        return result;
    }

    public static boolean isPrime(int n) {
        if(n <= 1) return false;
        if(n%2 == 0 || n% 3 == 0) {
            return n == 2 || n == 3;
        }

        for(int i = 6; i <= NumberUtil.integerSquareRoot(n)+1; i++) {
            if(n % (i-1) == 0) return false;
            if(n % (i+1) == 0) return false;
        }

        return true;
    }
}
