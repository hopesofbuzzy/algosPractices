package graphs;

@FunctionalInterface
public interface EdgeConsumer {
    void accept(int to, long weight);
}
