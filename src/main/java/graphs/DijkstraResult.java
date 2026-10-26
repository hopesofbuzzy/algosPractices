package graphs;

public class DijkstraResult {
    private static final long INF = Long.MAX_VALUE;

    private final long[] distance;
    private final int[] parent;

    public DijkstraResult(long[] distance, int[] parent) {
        this.distance = distance;
        this.parent = parent;
    }

    public int[] pathTo(int target) {
        if (distance[target] == INF) return new int[0];

        int len = 0;
        for (int v = target; v != -1; v = parent[v]) len++;

        int[] path = new int[len];
        int current = target;
        for (int i = len - 1; i >= 0; i--) {
            path[i] = current;
            current = parent[current];
        }

        return path;
    }
}
