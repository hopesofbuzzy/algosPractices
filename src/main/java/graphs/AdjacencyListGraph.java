package graphs;

import java.util.function.Consumer;

// Список смежностей.
public class AdjacencyListGraph implements Graph {
    private final AdjacencyListNode[] heads;
    private final boolean directed;

    public AdjacencyListGraph(int vertex, boolean directed) {
        if (vertex <= 0) {
            throw new IllegalArgumentException("vertex count must be > 0");
        }
        this.heads = new AdjacencyListNode[vertex];
        this.directed = directed;
    }





    @Override
    public int vertexCount() {
        return this.heads.length;
    }

    @Override
    public void addEdge(int from, int to, long weight) {
        this.heads[from] = new AdjacencyListNode(to, weight, this.heads[from]);
        if (!directed) {
            this.heads[to] = new AdjacencyListNode(from, weight, this.heads[to]);
        }


    }

    @Override
    public boolean containsEdge(int from, int to) {
        for (AdjacencyListNode node = this.heads[from]; node != null; node = node.getNext()) {
            if (node.getTo() == to) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void forEachOutgoing(int from, EdgeConsumer consumer) {
        // to, weight
        for (AdjacencyListNode node = this.heads[from];
             node != null;
             node = node.getNext()
        ) {
            consumer.accept(node.getTo(), node.getWeight());
        }
    }
}
