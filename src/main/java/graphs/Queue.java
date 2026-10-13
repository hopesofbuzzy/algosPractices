package graphs;

public class Queue {
    private Node head;
    private Node tail;

    boolean isEmpty() {
        return head == null;
    }

    void enqueue(int val) {
        Node node = new Node(val, null);
        if (head == null) {
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
    }

    int dequeue() {
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
