package projecteuler.problem031_040;

import projecteuler.SolutionTemplate;

public class Problem040 implements SolutionTemplate {
    public static void main(String[] args) {
        System.out.println(new Problem040().getSolution());
    }

    private final static int LIMIT = 1_000_000;
    @Override
    public String getSolution() {
        char[] numbers = new char[LIMIT+1];

        int num = 0;
        int index = 0;

        while(true) {
            char[] chars = Integer.toString(num++).toCharArray();

            for(int i = 0; i < chars.length && i + index < LIMIT+1; i++) {
                numbers[index + i] = chars[i];
            }
            index += chars.length;

            if(index > LIMIT + 1) break;
        }

        int mag = 1;
        int total = 1;
        while(mag <= LIMIT) {
            total *= numbers[mag] - '0';
            mag *= 10;
        }

        return Integer.toString(total);
    }
}
