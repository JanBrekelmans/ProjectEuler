package projecteuler.library.tree;

import java.util.*;

public class MinimumSpanningTreeKruskal {
    private final List<Edge> edges;
    private final List<Node> nodes;
    private final Map<Node, Node> nodeToRootNode = new HashMap<>();
    private final Map<Node, Integer> nodeRankMap = new HashMap<>();

    public final List<Edge> minimumSpanningTree = new ArrayList<>();
    public final int cost;

    public MinimumSpanningTreeKruskal(List<Node> nodes, List<Edge> edges) {
        this.edges = new ArrayList<>(edges);
        this.nodes = nodes;

        this.edges.sort(Comparator.comparingInt(Edge::weight));

        nodes.forEach(n -> {
            nodeToRootNode.put(n, null);
            nodeRankMap.put(n, 0);
        });

        for(Edge edge: this.edges) {
            Node rootNode1 = findRoot(edge.v1());
            Node rootNode2 = findRoot(edge.v2());

            if(rootNode1 != rootNode2) {
                minimumSpanningTree.add(edge);
                union(rootNode1, rootNode2);
            }
        }

        cost = minimumSpanningTree.stream().map(e -> e.weight()).reduce(0, (a,b) -> a+b);
    }

    private Node findRoot(Node n) {
        Node maybeRoot = nodeToRootNode.get(n);

        if(maybeRoot == null) {
            nodeToRootNode.put(n, n);
            return n;
        } else if (maybeRoot.equals(n)) {
            return n;
        } else {
            Node rootNode = findRoot(maybeRoot);
            nodeToRootNode.put(n, rootNode);
            return rootNode;
        }
    }

    private void union(Node n1, Node n2) {
        Node r1 = findRoot(n1);
        Node r2 = findRoot(n2);

        int rank1 = nodeRankMap.get(r1);
        int rank2 = nodeRankMap.get(r2);

        if(rank1 < rank2) {
            nodeToRootNode.put(r1, r2);
        } else if (rank1 > rank2) {
            nodeToRootNode.put(r2, r1);
        } else {
            nodeToRootNode.put(r1,r2);
            nodeRankMap.compute(r2, (k,v) -> v+1);
        }
    }
}
