package projecteuler.problem021_030;

import projecteuler.SolutionTemplate;

public class Problem028 implements SolutionTemplate {
    private final static int LAYERS = 500;

    public static void main(String[] args) {
        System.out.println(new Problem028().getSolution());
    }

    @Override
    public String getSolution() {
        int sum = 1;
        for(int N = 1; N <= LAYERS; N++) {
            sum += 4 * (2*N+1)*(2*N+1) - 12*N;
        }
        return Integer.toString(sum);
    }
}
