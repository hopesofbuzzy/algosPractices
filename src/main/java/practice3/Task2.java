package practice3;

import graphs.*;

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    void main() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int s = scanner.nextInt();

        AdjacencyListGraph graph = new AdjacencyListGraph(n, true);
        for (int i = 0; i < m; i++) {
            graph.addEdge(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }

        System.out.println(Arrays.toString(dijkstra(graph, s)));
    }

    public static long[] dijkstra(Graph graph, int start) {
        long[] distance = new long[graph.vertexCount()];
        int[] parents = new int[graph.vertexCount()];
        Arrays.fill(distance, Long.MAX_VALUE);
        Arrays.fill(parents, -1);

        MinHeap heap = new MinHeap();
        distance[start] = 0;
        heap.add(start, 0);
        while (!heap.isEmpty()) {
            HeapEntry entry = heap.removeMin();
            if (entry.distance() != distance[entry.vertex()]) continue;

            graph.forEachOutgoing(entry.vertex(), (to, weight) -> {
                if (entry.distance() + weight < distance[to]) {
                    distance[to] = entry.distance() + weight;
                    parents[to] = entry.vertex();
                    heap.add(to, distance[to]);
                }
            });
        }
        return distance;
    }
}
