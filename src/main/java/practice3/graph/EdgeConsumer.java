package practice3.graph;

@FunctionalInterface
public interface EdgeConsumer {
    void accept(int to, int weight);
}
