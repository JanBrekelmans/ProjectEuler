package projecteuler.problem031_040;

import projecteuler.SolutionTemplate;

public class Problem031 implements SolutionTemplate {
    private final static int LIMIT = 200;
    private final static int[] COINS = {1, 2, 5, 10, 20, 50, 100, 200};

    public static void main(String[] args) {
        System.out.println(new Problem031().getSolution());
    }

    @Override
    public String getSolution() {
        int[] numberOfWays = new int[LIMIT + 1];
        numberOfWays[0] = 1;
        for (int c : COINS) {
            for (int i = 0; i <= LIMIT; i++) {
                if (i - c >= 0) {
                    numberOfWays[i] += numberOfWays[i - c];
                }
            }
        }

        return Integer.toString(numberOfWays[200]);
    }
}
