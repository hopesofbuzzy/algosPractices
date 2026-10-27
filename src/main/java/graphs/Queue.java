package graphs;

public class Queue {
    private Node head;
    private Node tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(int val) {
        Node node = new Node(val, null);
        if (head == null) {
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("queue is empty");
        }

        Node current = head;
        head = current.getNext();
        if (head == null) {
            tail = null;
        }
        return current.getValue();
    }
}
