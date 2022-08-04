package projecteuler.problem011_020;

import projecteuler.SolutionTemplate;
import projecteuler.library.NumberUtil;

public class Problem012 implements SolutionTemplate {
    public static void main(String[] args) {
        System.out.println(new Problem012().getSolution());
    }
    @Override
    public String getSolution() {
        int triangleNumber = 1;
        for(int i = 2;triangleNumber > 0;i++) {
            triangleNumber += i;

            if(getDivisors(triangleNumber) > 500) {
                return Integer.toString(triangleNumber);
            }
        }

        throw new RuntimeException("No number found");
    }

    private int getDivisors(int n) {
        int total = 0;
        int iSqrt = NumberUtil.integerSquareRoot(n);

        for(int i = 1; i < iSqrt; i++) {
            if(n%i == 0) total += 2;
        }

        if(iSqrt*iSqrt == n) total += 1;

        return total;
    }
}
