package projecteuler.problem041_050;

import projecteuler.SolutionTemplate;

public class Problem045 implements SolutionTemplate {
    public static void main(String[] args) {
        System.out.println(new Problem045().getSolution());
    }

    @Override
    public String getSolution() {
        long triangleIndex = 1;
        long pentagonalIndex = 1;
        long hexagonalIndex = 144;

        for(;;hexagonalIndex++) {
            long hex = hexagonal(hexagonalIndex);

            while(triangle(triangleIndex) < hex) triangleIndex++;
            if(hex == triangle(triangleIndex)) {
                while (pentagonal(pentagonalIndex) < hex) pentagonalIndex++;

                if (hex == pentagonal(pentagonalIndex)) break;
            }
        }
        return Long.toString(hexagonal(hexagonalIndex));
    }

    private long triangle(long n) {
        return n * (n+1) / 2;
    }

    private long pentagonal(long n) {
        return n*(3*n-1) / 2;
    }

    private long hexagonal(long n) {
        return n*(2*n - 1);
    }
}
