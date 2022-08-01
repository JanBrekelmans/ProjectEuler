package projecteuler.library;

import java.util.ArrayList;
import java.util.List;

public class Primes {
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
}
