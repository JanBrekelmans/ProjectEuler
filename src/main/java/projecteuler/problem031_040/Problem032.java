package projecteuler.problem031_040;

import projecteuler.SolutionTemplate;
import projecteuler.library.NumberUtil;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Problem032 implements SolutionTemplate {
    private final static int LIMIT = 10000; // As 99*99 = 9801, the rhs must be smaller than this number
    public static void main(String[] args) {
        System.out.println(new Problem032().getSolution());
    }

    @Override
    public String getSolution() {
        int sum = 0;
        for(int rhs = 1; rhs < LIMIT; rhs++) {
            if(hasPandigitalProduct(rhs)) {
                sum += rhs;
            }
        }
        return Integer.toString(sum);
    }

    private boolean hasPandigitalProduct(int rhs) {
        for(int a = 1; a < rhs; a++) {
            if(rhs%a == 0) {
                int b = rhs / a;
                if (isPandigital("" + rhs + a + b)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isPandigital(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray).equals("123456789");
    }
}
