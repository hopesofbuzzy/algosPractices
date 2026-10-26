package graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kruskal {

    public static void kruskal(EdgeGraph graph) {
        // 1. Получить все рёбра
        List<Edge> edges = new ArrayList<>();
        graph.forEachEdge(edges::add);
        // 2. Сортировка рёбер по весу
        edges.sort(Comparator.comparingLong(Edge::weight));
        // 3. Создать DSU
        DisjointSet set = new DisjointSet(graph.vertexCount());

        List<Edge> selected = new ArrayList<>();
        long totalWeight = 0;
        // 4. Перебираем рёбра и строим остов
        // Кол-во рёбер = кол-во вершин - 1
        for (Edge edge : edges) {
            // from to
            
        }
    }
}
