package graphs;

public class Stack {
    private Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int val) {
        top = new Node(val, top);
    }

    public int pop() {
        if (top == null) {
            throw new IllegalStateException("stack is empty");
        }
        Node current = top;
        top = top.getNext();
        return current.getValue();
    }
}
