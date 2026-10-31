package practice3;

import graphs.*;
import practice3.graph.EdgeListGraph;

import java.util.*;

public class Task3 {
    void main() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        EdgeListGraph graph = new EdgeListGraph(n);
        for (int i = 0; i < m; i++) {
            graph.addEdge(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }

        List<Edge> edges = new ArrayList<>();
        graph.forEachEdge(edges::add);
        edges.sort(Comparator.comparingLong(Edge::weight));

        DisjointSet disjointSet = new DisjointSet(graph.vertexCount());

        for (Edge edge : edges) {
            disjointSet.union(edge.from(), edge.to(), edge.weight());
        }

        Map<Integer, Long> components =  new HashMap<>();
        for (int i = 0; i < graph.vertexCount(); i++) {
            int root = disjointSet.find(i);
            components.put(root, disjointSet.getVertexWeight(root));
        }

        long sum = 0;
        for (long val : components.values()) {
            sum += val;
        }

        // System.out.printf("% %d",, sum);
        System.out.println(components.values());
        System.out.println(sum);
    }
}
