package practice3.graph;

import graphs.Edge;
import graphs.EdgeConsumer;
import graphs.EdgeGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class EdgeListGraph implements EdgeGraph {
    List<Edge> edges = new ArrayList<>();
    int size;

    public EdgeListGraph(int size) {
        this.size = size;
    }

    public int vertexCount() { return size; }

    public void addEdge(int from, int to, long weight) {
        if (from >= size || to >= size) {
            throw new IllegalArgumentException("Индекс вне графа!");
        }
        edges.add(new Edge(from, to, weight));
    }

    public boolean containsEdge(int from, int to) {
        for (Edge edge : edges) {
            if (edge.from() == from && edge.to() == to) {
                return true;
            }
        }
        return false;
    }

    public void forEachOutgoing(int from, EdgeConsumer consumer) { }

    public void forEachEdge(Consumer<Edge> consumer) {
        for (Edge edge : edges) {
            consumer.accept(edge);
        }
    }
}
