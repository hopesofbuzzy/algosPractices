package graphs;

public class DisjointSet {

    private final int[] parent;
    private final int[] size;
    private final long[] weight;

    public DisjointSet(int v) {
        this.parent = new int[v];
        this.size = new int[v];
        for (int vertex = 0; vertex < v; vertex++) {
            this.parent[vertex] = vertex;
            this.size[vertex] = 1;
        }
        this.weight = new long[v];
    }

    public boolean union(int first, int second, long weight) {
        int firstRoot = find(first);
        int secondRoot = find(second);

        if (firstRoot == secondRoot) return false;
        if (size[firstRoot] < size[secondRoot]) {
            int temp = firstRoot;
            firstRoot = secondRoot;
            secondRoot = temp;
        }

        parent[secondRoot] = firstRoot;
        size[firstRoot] += size[secondRoot];
        this.weight[firstRoot] += weight;
        return true;
    }

    public long getVertexWeight(int vertex) {
        return weight[vertex];
    }

    public int find(int vertex) {
        if (parent[vertex] == vertex) return vertex;

        parent[vertex] = find(parent[vertex]);
        return parent[vertex];
    }
}
