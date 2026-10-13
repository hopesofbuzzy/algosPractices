package graphs;

import java.util.function.Consumer;

public interface EdgeGraph extends Graph {
    void forEachEdge(Consumer<?> consumer);
}
