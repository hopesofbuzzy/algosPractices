package practice3;

import graphs.AdjacencyListGraph;
import graphs.DisjointSet;
import graphs.Edge;
import graphs.Graph;
import graphs.Queue;
import practice3.graph.EdgeListGraph;

import java.util.*;

public class Task4 {
    void main() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        AdjacencyListGraph graph = new AdjacencyListGraph(n, true);
        for (int i = 0; i < m; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            graph.addEdge(from, to, 0);
        }

        System.out.println(sort(graph));
    }

    public static String sort(Graph graph) {
        int[] inDegree = new int[graph.vertexCount()];
        // System.out.println(graph.vertexCount());
        for (int i = 0; i < graph.vertexCount(); i++) {
            graph.forEachOutgoing(i, (to, weight) -> inDegree[to]++);
        }

        // Создаём очередь и вставляем в неё вершины с inDegree == 0
        graphs.Queue queue = new Queue();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.enqueue(i);
            }
        }

        if (queue.isEmpty()) {
            return "CYCLE";
        }

        // Результирующий массив
        int[] order = new int[graph.vertexCount()];
        int index = 1;
        while (!queue.isEmpty()) {
            int current = queue.dequeue();
            if (order[current] != 0) {
                return "CYCLE";
            }
            order[current] = index++;
            graph.forEachOutgoing(current, (to, weight) -> {
                inDegree[to]--;
                if (inDegree[to] == 0) {
                    queue.enqueue(to);
                }
            });
        }

        for (int degree : inDegree) {
            if (degree > 0) {
                return "CYCLE";
            }
        }
        return Arrays.toString(order);
    }
}
