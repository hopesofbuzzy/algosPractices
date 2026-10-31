package practice3.graph;

public interface Graph {
    int vertexCount();
    void addEdge(int from, int to, int weight);
    boolean containsEdge(int from, int to);
    void forEachOutgoing(int from, EdgeConsumer consumer);
}
