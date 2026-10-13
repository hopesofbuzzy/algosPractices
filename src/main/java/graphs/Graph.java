package graphs;

import java.util.function.Consumer;

public interface Graph {
    int vertexCount();
    void addEdge(int from, int to, long weight);
    boolean containsEdge(int from, int to);
    void forEachOutgoing(int from, EdgeConsumer consumer);
}
