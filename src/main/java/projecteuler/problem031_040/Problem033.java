package projecteuler.problem031_040;

import projecteuler.SolutionTemplate;
import projecteuler.library.Fraction;

public class Problem033 implements SolutionTemplate {
    public static void main(String[] args) {
        System.out.println(new Problem033().getSolution());
    }

    @Override
    public String getSolution() {
        Fraction fraction = new Fraction(1,1);
        for(int d = 10; d <= 99; d++) {
            for(int n = 10; n < d; n++) {
                int n1 = n%10;
                int n2 = n/10;
                int d1 = d%10;
                int d2 = d/10;

                if(n1 == d2 && n2*d == d1*n) {
                    fraction = fraction.multiply(new Fraction(n,d));
                } else if (n2 == d1 && n1*d == d2*n) {
                    fraction = fraction.multiply(new Fraction(n,d));
                }
            }
        }

        return fraction.getDenominator().toString();
    }
}
