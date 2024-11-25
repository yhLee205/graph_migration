package graphsearch;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {

    private Integer[][] graph;
    private int numberOfVertices;

    public Dijkstra(Integer[][] graph) {
        this.graph = graph;
        this.numberOfVertices = graph.length;
    }

    public void findShortestPaths(int startVertex) {
        int[] distances = new int[numberOfVertices];
        boolean[] visited = new boolean[numberOfVertices];
        int[] predecessors = new int[numberOfVertices];

        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(predecessors, -1);
        distances[startVertex] = 0;

        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Vertex(startVertex, 0));

        while (!priorityQueue.isEmpty()) {
            Vertex current = priorityQueue.poll();
            int currentIndex = current.index;

            if (visited[currentIndex]) {
                continue;
            }

            visited[currentIndex] = true;

            for (int i = 0; i < numberOfVertices; i++) {
                Integer edgeWeight = graph[currentIndex][i];
                if (edgeWeight != null && edgeWeight > 0 && !visited[i]) {
                    int newDist = distances[currentIndex] + edgeWeight;
                    if (newDist < distances[i]) {
                        distances[i] = newDist;
                        predecessors[i] = currentIndex;
                        priorityQueue.add(new Vertex(i, newDist));
                    }
                }
            }
        }

        printSolution(startVertex, distances, predecessors);
    }

    private void printSolution(int startVertex, int[] distances, int[] predecessors) {
        System.out.println("시작점: " + (startVertex + 1));
        for (int i = 0; i < distances.length; i++) {
            if (i != startVertex) {
                System.out.print("정점 [" + (i + 1) + "]: ");
                printPath(i, predecessors);
                System.out.println(", 길이: " + distances[i]);
            }
        }
    }

    private void printPath(int currentVertex, int[] predecessors) {
        if (currentVertex == -1) {
            return;
        }
        StringBuilder path = new StringBuilder();
        buildPath(path, currentVertex, predecessors);
        System.out.print(path.toString());
    }

    private void buildPath(StringBuilder path, int currentVertex, int[] predecessors) {
        if (predecessors[currentVertex] == -1) {
            path.append(currentVertex + 1);
            return;
        }
        buildPath(path, predecessors[currentVertex], predecessors);
        path.append(" - ").append(currentVertex + 1);
    }

    private static class Vertex implements Comparable<Vertex> {
        int index;
        int distance;

        Vertex(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Vertex other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
}
