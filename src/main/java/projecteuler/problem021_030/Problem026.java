package projecteuler.problem021_030;

import projecteuler.SolutionTemplate;

public class Problem026 implements SolutionTemplate {
    private final static int LIMIT = 1_000;

    public static void main(String[] args) {
        System.out.println(new Problem026().getSolution());
    }

    @Override
    public String getSolution() {
        int longestCycle = 0;
        int longestCyleIndex = 0;

        for(int i = 2; i < LIMIT; i++) {
            if (getRepeatingLength(i) > longestCycle) {
                longestCycle = getRepeatingLength(i);
                longestCyleIndex = i;
            }
        }
        return Integer.toString(longestCyleIndex);
    }

    private int getRepeatingLength(int n) {
        int[] remainders = new int[n];
        int value = 1;
        int position = 0;

        while(remainders[value] == 0 && value != 0) {
            remainders[value] = position;
            value *= 10;
            value %= n;
            position++;
        }

        return position - remainders[value];
    }
}
