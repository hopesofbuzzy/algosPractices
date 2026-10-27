package graphs;

public class DFS {

    public static boolean[] search(Graph graph, int start) {
        boolean[] visited = new boolean[graph.vertexCount()];
        Stack stack = new Stack();
        stack.push(start);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (visited[v]) continue;
            visited[v] = true;
            graph.forEachOutgoing(v, (to, weight) -> {
                if (!visited[to]) {
                    stack.push(to);
                }
            });
        }

        return visited;
    }
}
