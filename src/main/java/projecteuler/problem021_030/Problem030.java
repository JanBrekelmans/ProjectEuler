package projecteuler.problem021_030;

import projecteuler.SolutionTemplate;

public class Problem030 implements SolutionTemplate {
    private final static int UPPER_LIMIT = 354295; // We have that 6*9^5 <= 354294, so we only need to check those

    public static void main(String[] args) {
        System.out.println(new Problem030().getSolution());
    }

    @Override
    public String getSolution() {
        int total = 0;

        for(int n = 2; n <= UPPER_LIMIT; n++) {
            if(getFifthPowerDigitSum(n) == n) {
                total += n;
            }
        }
        return Integer.toString(total);
    }

    private int getFifthPowerDigitSum(int n) {
        int sum = 0;
        while(n > 0 ) {
            int t = n% 10;
            sum += t*t*t*t*t;
            n /= 10;
        }
        return sum;
    }
}
