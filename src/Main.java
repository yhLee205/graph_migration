import graphsearch.Bfs;
import graphsearch.Dijkstra;
import graphsearch.FileRead;

public class Main {
    public static void main(String[] args) {
        // 파일 읽기
        String input1Path = "files/input1.txt";
        FileRead fileRead1 = new FileRead(input1Path);

        for (int i = 0; i < fileRead1.capacity.size(); i++) {
            Integer[][] graph = fileRead1.capacity.get(i);
            System.out.println("\n그래프 [" + (i + 1) + "]");
            System.out.println("----------------------------");
            // BFS 수행
            Bfs bfs = new Bfs(graph);
            bfs.performBFS(0); // 시작 정점 1 (0 인덱스)
            System.out.println();

            System.out.println("=========================");
        }



        FileRead fileRead = new FileRead("files/input2.txt");

        for (int i = 0; i < fileRead.capacity.size(); i++) {
            Integer[][] graph = fileRead.capacity.get(i);
            Dijkstra dijkstra = new Dijkstra(graph);
            System.out.println("\n그래프 [" + (i + 1) + "]");
            System.out.println("----------------------------");
            dijkstra.findShortestPaths(0); // 시작 정점 1 (0번 인덱스)
            System.out.println("=========================");
        }
    }
}