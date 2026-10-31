package practice3.graph;

public class AdjacencyListGraph implements Graph {
    private AdjacencyListNode[] heads;

    public AdjacencyListGraph(int vertexCount) {
        this.heads = new AdjacencyListNode[vertexCount];
    }

    public int vertexCount() { return heads.length; }

    public void addEdge(int from, int to, int weight) {
        heads[from] = new AdjacencyListNode(to, weight, heads[from]);
    }

    public boolean containsEdge(int from, int to) {
        for (AdjacencyListNode node = heads[from]; node != null; node = node.getNext()) {
            if (node.getTo() == to) {
                return true;
            }
        }
        return false;
    }

    public void forEachOutgoing(int from, EdgeConsumer consumer) {
        for (AdjacencyListNode node = heads[from];
        node.getNext() != null;
        node = node.getNext()) {
            consumer.accept(node.getTo(), node.getWeight());
        }
    }
}
