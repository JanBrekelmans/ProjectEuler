package projecteuler.library;

import org.junit.jupiter.api.Test;
import projecteuler.library.tree.Edge;
import projecteuler.library.tree.MinimumSpanningTreeKruskal;
import projecteuler.library.tree.Node;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumSpanningTreeTest {
    Node n0 = new Node("0"),
            n1 = new Node("1"),
            n2 = new Node("2"),
            n3 = new Node("3"),
            n4 = new Node("4"),
            n5 = new Node("5");

    Edge e0 = new Edge(n0, n1, 4),
            e1 = new Edge(n0, n2, 1),
            e2 = new Edge(n0, n3, 5),
            e3 = new Edge(n1, n3, 2),
            e4 = new Edge(n1, n4, 3),
            e5 = new Edge(n1, n5, 3),
            e6 = new Edge(n3, n2, 2),
            e7 = new Edge(n3, n4, 1),
            e8 = new Edge(n2, n4, 8),
            e9 = new Edge(n4, n5, 4);

    @Test
    public void MinimumSpanningTreeKruskalTest() {
        List<Node> nodes = List.of(n0,n1,n2,n3,n4,n5);
        List<Edge> edges = List.of(e0,e1,e2,e3,e4,e5,e6,e7,e8,e9);

        MinimumSpanningTreeKruskal minimumSpanningTreeKruskal = new MinimumSpanningTreeKruskal(nodes, edges);

        int cost = minimumSpanningTreeKruskal.cost;

        assertEquals(cost, 9);
    }

}
