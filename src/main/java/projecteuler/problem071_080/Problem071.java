package projecteuler.problem071_080;

import projecteuler.SolutionTemplate;
import projecteuler.library.Fraction;
import projecteuler.library.NumberUtil;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Problem071 implements SolutionTemplate {
    private final static int LIMIT = 1_000;

    public static void main(String[] args) {
        System.out.println(new Problem071().getSolution());
    }

    @Override
    public String getSolution() {
        Set<Fraction> fractionSet = new HashSet<>();
        int counter = 0;

        for(int d = 1; d <= LIMIT; d++) {
            for(int n = 1; n < d; n++) {
                if(NumberUtil.gcd(n,d) != 1) continue;
                fractionSet.add(new Fraction(BigInteger.valueOf(n), BigInteger.valueOf(d)));
                counter++;
            }
        }
        return null;
    }
}
