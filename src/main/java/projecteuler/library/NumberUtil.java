package projecteuler.library;

public class NumberUtil {
    public static int integerSquareRoot(int n) {
        if(n < 0) throw new IllegalArgumentException("Negative number");
        int r = 0;
        for(int i = 1<<15; i > 0; i= i>>>1) {
            r |= i;

            if(r*r > n || r > 46340) r ^= i;
        }
        return r;
    }
}
