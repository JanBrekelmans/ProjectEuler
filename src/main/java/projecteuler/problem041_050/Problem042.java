package projecteuler.problem041_050;

import projecteuler.SolutionTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Problem042 implements SolutionTemplate {
    private final int LIMIT = 50;
    private final boolean[] CACHE = new boolean[LIMIT*(LIMIT + 1) / 2 + 1];

    public static void main(String[] args) {
        System.out.println(new Problem042().getSolution());
    }

    @Override
    public String getSolution() {
        fillCache();

        int total = 0;

        for(var word: getWords()) {
            if(CACHE[getWordValue(word)]) total++;
        }

        return Integer.toString(total);
    }

    private void fillCache() {
        Arrays.fill(CACHE, false);
        for(int i = 1; i <= LIMIT; i++) {
            CACHE[i * (i+1) / 2] = true;
        }
    }

    private List<String> getWords() {
        List<String> words = new ArrayList<>();

        try {
            File myObj = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("problem041_050/p042_words.txt")).getFile());
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String wordLine = myReader.nextLine();
                String[] splitWords = wordLine.replace("\"", "").split(",");
                words.addAll(Arrays.asList(splitWords));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return words;
    }

    private int getWordValue(String word) {
        int sum = 0;
        for(char c: word.toCharArray()) {
            sum += c - 'A' + 1;
        }
        return sum;
    }
}
