package practice3.graph;

public class AdjacencyListNode {
    int to;
    int weight;
    AdjacencyListNode next;

    public AdjacencyListNode(int to, int weight, AdjacencyListNode next) {
        this.to = to;
        this.weight = weight;
        this.next = next;
    }

    public int getTo() {
        return to;
    }

    public int getWeight() {
        return weight;
    }

    public AdjacencyListNode getNext() {
        return next;
    }
}
