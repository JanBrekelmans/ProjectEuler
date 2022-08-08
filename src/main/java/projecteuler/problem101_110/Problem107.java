package projecteuler.problem101_110;

import projecteuler.SolutionTemplate;
import projecteuler.library.tree.Edge;
import projecteuler.library.tree.MinimumSpanningTreeKruskal;
import projecteuler.library.tree.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Problem107 implements SolutionTemplate {
    public static void main(String[] args) {
        System.out.println(new Problem107().getSolution());
    }

    @Override
    public String getSolution() {
        List<Node> nodes = new ArrayList<>();
        for(int i = 0; i < 40; i++) {
            nodes.add(new Node(Integer.toString(i)));
        }
        List<Edge> edges = new ArrayList<>();

        readAndStoreEdges(nodes, edges);

        MinimumSpanningTreeKruskal minimumSpanningTreeKruskal = new MinimumSpanningTreeKruskal(nodes, edges);

        int totalCost = edges.stream().map(e -> e.weight()).reduce(0, (a,b) -> a+b);
        int minimumSpanningTreeCost = minimumSpanningTreeKruskal.cost;

        return Integer.toString(totalCost - minimumSpanningTreeCost);
    }

    private void readAndStoreEdges(List<Node> nodes, List<Edge> edges) {
        try {
            File myObj = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("problem101_110/p107_network.txt")).getFile());
            Scanner myReader = new Scanner(myObj);
            int rowNumber = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] weights = data.split(",");

                for(int colNumber = rowNumber+1; colNumber < weights.length; colNumber++) {
                    if(weights[colNumber].equals("-")) continue;

                    Node n1 = nodes.get(rowNumber);
                    Node n2 = nodes.get(colNumber);
                    int weight = Integer.parseInt(weights[colNumber]);
                    edges.add(new Edge(n1,n2,weight));
                }
                rowNumber++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
