package practice3;

import graphs.AdjacencyListGraph;
import graphs.Graph;
import graphs.Stack;

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    void main() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int s = scanner.nextInt();

        AdjacencyListGraph graph = new AdjacencyListGraph(n, true);
        for (int i = 0; i < m; i++) {
            graph.addEdge(scanner.nextInt(), scanner.nextInt(), 0);
        }


        Stack stack = new Stack();
        int index = 1;
        int[] visited = new int[n];
        stack.push(s);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            visited[current] = index++;
            graph.forEachOutgoing(current, (to, weight) -> {
                if (visited[to] == 0) {
                    stack.push(to);
                }
            });
        }

        System.out.println(Arrays.toString(visited));
    }
}
