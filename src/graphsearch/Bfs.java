package graphsearch;

import java.util.*;

public class Bfs {
    private Integer[][] graph;
    private int numberOfVertices;

    public Bfs (Integer[][] graph) {
        this.graph = graph;
        this.numberOfVertices = graph.length;
    }

    public void performBFS(int startVertex) {
        boolean[] visited = new boolean[numberOfVertices];
        List<Integer> bfsOrder = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        visited[startVertex] = true;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            bfsOrder.add(currentVertex);

            for (int i = 0; i < numberOfVertices; i++) {
                if (graph[currentVertex][i] != null && graph[currentVertex][i] > 0 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        printBFSResult(bfsOrder);
    }

    private void printBFSResult(List<Integer> bfsOrder) {
        System.out.print("너비 우선 탐색  \n");
        for (int i = 0; i < bfsOrder.size(); i++) {
            System.out.print((bfsOrder.get(i) + 1));
            if (i < bfsOrder.size() - 1) {
                System.out.print(" – ");
            }
        }
        System.out.println();
    }
}
