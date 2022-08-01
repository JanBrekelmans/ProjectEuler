package projecteuler.problem001_010;

import projecteuler.SolutionTemplate;

public class Problem009 implements SolutionTemplate {
    public static void main(String[] args) {
        System.out.println(new Problem009().getSolution());
    }

    @Override
    public String getSolution() {
        for(int a = 1; a < 1000; a++) {
            for(int b = a+1; b < 1000; b++) {
                int c = 1000 - a - b;
                if(a*a + b*b == c*c) {
                    return Integer.toString(a*b*c);
                }
            }
        }
        return null;
    }
}
