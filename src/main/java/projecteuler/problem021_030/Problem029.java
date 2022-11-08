package projecteuler.problem021_030;

import projecteuler.SolutionTemplate;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Problem029 implements SolutionTemplate {
    public static void main(String[] args) {
        System.out.println(new Problem029().getSolution());
    }

    @Override
    public String getSolution() {
        Set<String> powers = new HashSet<>();
        for(int a = 2; a <= 100; a++) {
            for(int b = 2; b <= 100; b++) {
                powers.add(BigInteger.valueOf(a).pow(b).toString());
            }
        }
        return Integer.toString(powers.size());
    }
}
