package graphs;

import java.util.Arrays;

public class BFS {
    public static int[] search(Graph graph, int start) {
        int vertex = graph.vertexCount();
        boolean[] visited = new boolean[vertex];

        int[] parent = new int[vertex];
        Arrays.fill(parent, -1);
        Queue queue = new Queue();
        visited[start] = true;
        queue.enqueue(start);

        while (!queue.isEmpty()) {
            int current = queue.dequeue();
            graph.forEachOutgoing(current, (to, weight) -> {
                if (!visited[to]) {
                    visited[to] = true;
                    parent[to] = current;
                    queue.enqueue(to);
                }
            });
        }

        return parent;
    }
}
