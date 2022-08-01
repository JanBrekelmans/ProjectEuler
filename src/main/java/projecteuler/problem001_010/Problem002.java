package projecteuler.problem001_010;

import projecteuler.SolutionTemplate;

public class Problem002 implements SolutionTemplate {
    private final static int LIMIT = 4_000_000;

    public static void main(String[] args){
        System.out.println(new Problem002().getSolution());
    }
    @Override
    public String getSolution() {
        int a = 1, b = 2;
        int sum = 0;

        while(a < LIMIT) {
            if(a%2 == 0) sum += a;

            int temp = b;
            b += a;
            a = temp;
        }

        return String.valueOf(sum);
    }
}
