package projecteuler.problem031_040;

import projecteuler.SolutionTemplate;

public class Problem039 implements SolutionTemplate {
    private final static int LIMIT = 1000;

    public static void main(String[] args) {
        System.out.println(new Problem039().getSolution());
    }

    @Override
    public String getSolution() {
        int numSolutions = 0;
        int perimeter = 0;

        for(int p = 3; p <= LIMIT; p++) {
            int counter = 0;

            for(int a = 1; a <= p/3; a++) {
                for(int b = 1; b < p-a; b++) {
                    int c = p - a - b;
                    if(c*c == a*a + b*b) counter++;
                }
            }

            if(counter > numSolutions) {
                numSolutions = counter;
                perimeter = p;
            }
        }

        return Integer.toString(perimeter);
    }
}
