package projecteuler.problem231_240;

import projecteuler.SolutionTemplate;

public class Problem235 implements SolutionTemplate {
    private final static int LIMIT = 5000;
    private final static double TARGET = -600_000_000_000.;
    private final static double MARGIN = 0.000_000_000_000_01;

    public static void main(String[] args) {
        System.out.println(new Problem235().getSolution());
    }

    @Override
    public String getSolution() {
        double lower = 1.0;
        double upper = 1.1;

        while(upper - lower > MARGIN)
        {
            double center = 0.5*(upper + lower);
            double res = u(center);
            if(res < TARGET) {
                upper = center;
            } else {
                lower = center;
            }
        }

        return String.format("%.12f",0.5*(upper+lower));
    }

    double u(double r) {
        if(r == 1.0) {
            return uSlow(r);
        }

        double numerator = 3*(300-LIMIT)*Math.pow(r, LIMIT+1) + 3*(LIMIT-299)*Math.pow(r, LIMIT) - 900*r + 897;
        double denominator = (r-1)*(r-1);

        return numerator / denominator;
    }

    double uSlow(double r) {
        double result = 0;

        for(int k = 1; k <= LIMIT; k++) {
            result += (900-3*k)*Math.pow(r, k-1);
        }

        return result;
    }
}
