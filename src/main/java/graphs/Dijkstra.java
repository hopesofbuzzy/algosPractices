package graphs;

import java.util.Arrays;

public class Dijkstra {
    private static final long INF = Long.MAX_VALUE;

    public static DijkstraResult dijkstra(Graph graph, int start) {
        long[] distance = new long[graph.vertexCount()];
        int[] parent = new int[graph.vertexCount()];

        Arrays.fill(distance, INF);
        Arrays.fill(parent, -1);

        MinHeap heap = new MinHeap();
        distance[start] = 0;
        heap.add(start, 0);

        while (!heap.isEmpty()) {
            HeapEntry current = heap.removeMin();

            if (current.distance() != distance[current.vertex()]) continue;

            graph.forEachOutgoing(
                    current.vertex(),
                    ((to, weight) -> {
                        long candidate = current.distance() + weight;
                        if (candidate < distance[to]) {
                            distance[to] = candidate;
                            parent[to] = current.vertex();
                            heap.add(to, candidate);
                        }
                    })
            );
        }

        return new DijkstraResult(distance, parent);
    }
}
