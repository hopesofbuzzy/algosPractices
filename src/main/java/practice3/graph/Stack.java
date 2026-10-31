package practice3.graph;

public class Stack {
    Node top;

    public boolean isEmpty() { return top == null; }

    public void push(int value) {
        top = new Node(top, value);
    }

    public int pop() {
        if (top == null) {
            throw new IllegalStateException("Стек пуст!");
        }
        int value = top.getValue();
        top = top.getNext();
        return value;
    }
}
