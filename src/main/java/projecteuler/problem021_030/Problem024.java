package projecteuler.problem021_030;

import projecteuler.SolutionTemplate;

public class Problem024 implements SolutionTemplate {
    private final static int LIMIT = 1_000_000;

    public static void main(String[] args) {
        System.out.println(new Problem024().getSolution());
    }

    @Override
    public String getSolution() {
        int[] array = {0,1,2,3,4,5,6,7,8,9};

        for(int i = 0; i < LIMIT-1; i++) {
            getNextPermutation(array);
        }

        String result = "";
        for(int x: array) result += x;
        return result;
    }

    private void getNextPermutation(int[] array) {
        int i = array.length-1;

        while(i > 0 && array[i-1] >= array[i]) {
            i--;
        }

        if(i <= 0) return; // Last permutation already reached

        int j = array.length - 1;
        while(array[j] <= array[i-1]) {
            j--;
        }
        swap(array, i-1, j);

        for(int k = array.length - 1; i< k; k--) {
            swap(array, k, i++);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
