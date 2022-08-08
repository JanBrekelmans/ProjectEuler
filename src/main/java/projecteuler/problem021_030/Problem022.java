package projecteuler.problem021_030;

import projecteuler.SolutionTemplate;
import projecteuler.library.tree.Edge;
import projecteuler.library.tree.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Problem022 implements SolutionTemplate {
    public static void main(String[] args) {
        System.out.println(new Problem022().getSolution());
    }

    @Override
    public String getSolution() {
         long total = 0;

        List<String> names = getNames();
        Collections.sort(names);

        for(int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            int nameSum = 0;
            for(char c: name.toCharArray()) {
                if(c == '\"') continue;
                nameSum += c - 'A' + 1;
            }

            total += (i+1) * nameSum;
        }

        return Long.toString(total);
    }

    private List<String> getNames() {
        List<String> names = new ArrayList<>();

        try {
            File myObj = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("problem021_030/p022_names.txt")).getFile());
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Arrays.stream(data.split(",")).forEach(s -> names.add(s));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return names;
    }
}
