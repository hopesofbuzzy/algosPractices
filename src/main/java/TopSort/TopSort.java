package TopSort;

import graphs.AdjacencyListGraph;
import graphs.DFS;
import graphs.Graph;
import graphs.Queue;

import java.util.Arrays;

public class TopSort {
    static void main() {
        AdjacencyListGraph graph = new AdjacencyListGraph(5, true);
        graph.addEdge(0, 2, 0);
        graph.addEdge(1, 2, 0);
        graph.addEdge(2, 3, 0);
        graph.addEdge(2, 4, 0);
//        boolean[] result = DFS.search(graph, 3);
        System.out.println(Arrays.toString(sort(graph)));
    }

    public static int[] sort(Graph graph) {
        int[] inDegree = new int[graph.vertexCount()];
        for (int i = 0; i < graph.vertexCount(); i++) {
            System.out.printf("Вершина %d \n", i);
            graph.forEachOutgoing(i, (to, weight) -> inDegree[to]++);
        }
        System.out.println(Arrays.toString(inDegree));

        // Создаём очередь и вставляем в неё вершины с inDegree == 0
        Queue queue = new Queue();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.enqueue(i);
            }
        }

        // Результирующий массив
        int[] order = new int[graph.vertexCount()];
        int index = 1;
        while (!queue.isEmpty()) {
            int current = queue.dequeue();
            order[current] = index++;
            graph.forEachOutgoing(current, (to, weight) -> {
                inDegree[to]--;
                if (inDegree[to] == 0) {
                    queue.enqueue(to);
                }
            });
        }
        return order;
     }
}
