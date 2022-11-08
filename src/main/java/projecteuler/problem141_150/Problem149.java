package projecteuler.problem141_150;

import projecteuler.SolutionTemplate;

public class Problem149 implements SolutionTemplate {
    private final static int SIZE = 20;
    private final long[][] grid = new long[SIZE][SIZE];

    public static void main(String[] args) {
        System.out.println(new Problem149().getSolution());
    }

    @Override
    public String getSolution() {
        fillGrid();
        return Long.toString(findMaxInDirections());
    }

    private long findMaxInDirections() {
        long max = 0;
        // Horizontal direction
        for(int i = 0; i < SIZE; i++) {
            long currentMax = 0;
            for(int j = 0; j < SIZE; j++) {
                long current = grid[i][j] + (currentMax > 0? currentMax: 0);
                currentMax = Math.max(current, currentMax);
            }
            max = Math.max(currentMax, max);
        }

        // Vertical direction
        for(int j = 0; j < SIZE; j++) {
            long currentMax = 0;
            for(int i = 0; i < SIZE; i++) {
                long current = grid[i][j] + (currentMax > 0? currentMax: 0);
                currentMax = Math.max(current, currentMax);
            }
            max = Math.max(currentMax, max);
        }

        // Diagonal direction from top side
        for(int i = 0; i < SIZE; i++) {
            long currentMax = 0;
            for(int j = 0; i+j < SIZE; j++) {
                long current = grid[i][i+j] + (currentMax > 0? currentMax: 0);
                currentMax = Math.max(current, currentMax);
            }
            max = Math.max(currentMax, max);
        }

        // Diagonal direction from left side
        for(int j = 0; j < SIZE; j++) {
            long currentMax = 0;
            for(int i = 0; i+j < SIZE; i++) {
                long current = grid[i+j][j] + (currentMax > 0? currentMax: 0);
                currentMax = Math.max(current, currentMax);
            }
            max = Math.max(currentMax, max);
        }

        // Diagonal direction from top side
        for(int i = 0; i < SIZE; i++) {
            long currentMax = 0;
            for(int j = SIZE - 1; i-j >= 0 && j >= 0; j--) {
                try {
                    long current = grid[i][i - j] + (currentMax > 0 ? currentMax : 0);
                    currentMax = Math.max(current, currentMax);
                } catch (Exception e) {
                    var t = 1;
                }

            }
            max = Math.max(currentMax, max);
        }

        // Diagonal direction from left side
        for(int j = 0; j < SIZE; j++) {
            long currentMax = 0;
            for(int i = SIZE - 1; j - i >= 0 && i >= 0; i--) {
                long current = grid[j-i][j] + (currentMax > 0? currentMax: 0);
                currentMax = Math.max(current, currentMax);
            }
            max = Math.max(currentMax, max);
        }

        return max;
    }

    private void fillGrid() {
        LFG generator = new LFG();
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                grid[i][j] = generator.next();
            }
        }
    }

    private static class LFG {
        long[] previous = new long[55];
        int index = 1;

        long next() {
            long result;
            if(index <= 55) {
                result = (100003 - 200003L*index + 300007L*index*index*index) % 1000000 - 500000;
            } else {
                int index24 = (index - 1 - 24) % 55;
                int index55 = (index - 1 - 55) % 55;

                result = (previous[index24] + previous[index55] + 1000000) % 1000000 - 500000;
            }
            previous[(index - 1) % 55] = result;
            index++;
            return result;
        }


    }
}
