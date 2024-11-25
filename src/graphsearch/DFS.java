package graphsearch;

import java.util.ArrayList;

public class DFS {
    private ArrayList<Integer> traversalOrder;

    public DFS() {
        traversalOrder = new ArrayList<>();
    }

    public void dfs(Integer[][] graph, int startNode) {
        boolean[] visited = new boolean[graph.length];
        traversalOrder.clear(); // 이전 탐색 결과 초기화
        dfsUtil(graph, startNode, visited);

        System.out.println("깊이 우선 탐색" + "\n" + formatTraversal());
    }

    private void dfsUtil(Integer[][] graph, int currentNode, boolean[] visited) {
        visited[currentNode] = true;
        traversalOrder.add(currentNode + 1); // 탐색 순서에 추가 (노드 번호는 1부터)

        for (int i = 0; i < graph.length; i++) {
            if (graph[currentNode][i] != Integer.MAX_VALUE && !visited[i]) {
                dfsUtil(graph, i, visited);
            }
        }
    }

    private String formatTraversal() {
        return String.join(" – ", traversalOrder.stream().map(String::valueOf).toArray(String[]::new));
    }
}