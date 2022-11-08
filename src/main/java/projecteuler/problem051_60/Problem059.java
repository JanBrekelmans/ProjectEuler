package projecteuler.problem051_60;

import projecteuler.SolutionTemplate;
import projecteuler.library.tree.Edge;
import projecteuler.library.tree.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Problem059 implements SolutionTemplate {
    public static void main(String[] args) {
        System.out.println(new Problem059().getSolution());
    }

    @Override
    public String getSolution() {
        char[] bestKey = null;
        double bestFit = -100_000;

        Set<String> dictionary = getDictionaryWords();

        char[] encryptedChars = readEncryptedText();
        for(char x = 'a'; x <= 'z'; x++) {
            for(char y = 'a'; y <= 'z'; y++) {
                for(char z = 'a'; z <= 'z'; z++) {
                    char[] key = {x,y,z};
                    char[] decryptedText = decrypt(encryptedChars, key);

                    double currentFit = frequencyAnalysis(decryptedText, dictionary);
                    if(currentFit > bestFit) {
                        bestKey = key;
                        bestFit = currentFit;
                    }
                }
            }
        }

        int total = 0;
        for(char c: decrypt(encryptedChars, bestKey)) {
            total += c;
        }

        return Integer.toString(total);
    }

    private char[] decrypt(char[] text, char[] key) {
        char[] result = new char[text.length];
        for(int i = 0; i < text.length; i++) {
            result[i] = (char) (text[i] ^ key[i%key.length]);
        }
        return result;
    }

    private double frequencyAnalysis(char[] text, Set<String> dictionary) {
        String[] possibleWords = new String(text).toLowerCase(Locale.ROOT).split(" ");
        double fit = 0.0;


        for(String possibleWord: possibleWords) {
            if(dictionary.contains(possibleWord)) {
                fit += 5.0;
            } else {
                 fit -= 2.0;
            }
        }

        return fit;
    }

    private char[] readEncryptedText() {
        char[] encryptedChars = null;
        try {
            File myObj = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("problem051_60/p059_cipher.txt")).getFile());
            Scanner myReader = new Scanner(myObj);
            int rowNumber = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] splitText = data.split(",");

                encryptedChars = new char[splitText.length];
                for(int i = 0; i < splitText.length; i++) {
                    encryptedChars[i] = (char) Integer.parseInt(splitText[i]);
                }
                break;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return encryptedChars;
    }

    private Set<String> getDictionaryWords() {
        Set<String> words = new HashSet<>();
        try {
            File myObj = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("util/dictionary.txt")).getFile());
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                words.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return words;
    }
}
