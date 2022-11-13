package projecteuler.problem041_050;

import projecteuler.SolutionTemplate;
import projecteuler.library.NumberUtil;

import java.util.ArrayList;
import java.util.List;

public class Problem044 implements SolutionTemplate {
    public static void main(String[] args) {
        System.out.println(new Problem044().getSolution());
    }

    @Override
    public String getSolution() {
        long n = 1;
        List<Long> pentagonals = new ArrayList<>();

        while(true) {
            long newPentagonal = getPentagonalNumber(n++);

            for(Long p: pentagonals) {
                if(isPentagonal(newPentagonal - p) && isPentagonal(newPentagonal + p)) {
                    return Long.toString(newPentagonal - p);
                }
            }

            pentagonals.add(newPentagonal);
        }
    }

    private long getPentagonalNumber(long n) {
        return n*(3*n-1) / 2;
    }

    private boolean isPentagonal(long p) {
        long n = (NumberUtil.integerSquareRoot(24*p + 1) + 1)/6;
        return p == getPentagonalNumber(n);
    }
}
