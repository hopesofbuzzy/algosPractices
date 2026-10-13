package graphs;

import java.util.Arrays;

public class Main {
    static void main() {
        AdjacencyListGraph graph = new AdjacencyListGraph(4, false);
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 2, 2);
        boolean[] result = DFS.search(graph, 3);
        System.out.println(Arrays.toString(result));
    }
}
