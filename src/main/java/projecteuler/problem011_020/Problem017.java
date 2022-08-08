package projecteuler.problem011_020;

import projecteuler.SolutionTemplate;

public class Problem017 implements SolutionTemplate {
    private final static String[] ONES = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    private final static String[] TENS = {
            "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static void main(String[] args) {
        System.out.println(new Problem017().getSolution());
    }

    @Override
    public String getSolution() {
        int total = 0;
        for(int i = 1; i <= 1000; i++) {
            total += numberToWords(i).length();
        }

        return Integer.toString(total);
    }

    private String numberToWords(int n) {
        if(n < 20) {
            return ONES[n];
        } else if (n < 100) {
            return TENS[n/10] + (n%10 == 0? "": ONES[n%10]);
        } else if (n < 1000) {
            return ONES[n/100] + "hundred" + (n%100 == 0? "": "and" + numberToWords(n%100));
        } else if (n == 1000) {
            return "onethousand";
        }
        throw new IllegalArgumentException("Number not supported");
    }
}
