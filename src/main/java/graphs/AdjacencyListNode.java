package graphs;

public class AdjacencyListNode {
    private int to;
    private long weight;
    private AdjacencyListNode next;

    public AdjacencyListNode(int to, long weight, AdjacencyListNode next) {
        this.to = to;
        this.weight = weight;
        this.next = next;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public AdjacencyListNode getNext() {
        return next;
    }

    public void setNext(AdjacencyListNode next) {
        this.next = next;
    }
}
