package projecteuler.problem001_010;

import projecteuler.SolutionTemplate;
import projecteuler.library.Util;

public class Problem004 implements SolutionTemplate {
    public static void main(String[] args) {
        System.out.println(new Problem004().getSolution());
    }
    @Override
    public String getSolution() {
        int max = 0;

        for(int a = 100; a <= 999; a++) {
            for(int b = a; b <= 999; b++) {
                int product = a*b;
                if(product > max && Util.isPalindromic(String.valueOf(product))) {
                    max = product;
                }
            }
        }
        return String.valueOf(max);
    }
}
