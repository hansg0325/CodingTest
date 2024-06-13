import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> tree = new ArrayList<>(); // 트리 선언
        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>()); // 자식노드가 없는 부모노드 n+1개 생성
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        int[] parent = new int[n + 1]; // 각 노드의 부모를 저장
        boolean[] visited = new boolean[n + 1]; // 노드 방문 여부를 체크
        Queue<Integer> queue = new LinkedList<>(); // 큐를 사용해 bfs로직 수행
        queue.add(1); // 루트노드는 1
        visited[1] = true; // 루트노드는 방문함

        while (!queue.isEmpty()) {
            int node = queue.poll(); // 큐에 담긴 노드를 선택
            for (int neighbor : tree.get(node)) { // 선택한 노드와 연결된 모든 노드를 탐색
                if (!visited[neighbor]) { // 선택한 노드와 연결된 노드가 방문하지 않았다면 진행
                    visited[neighbor] = true; // 방문한것으로 체크
                    parent[neighbor] = node; // 선택한 노드와 연결된 노드는 선택한 노드의 자식임
                    queue.add(neighbor); // 큐에 추가
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) { // 2번노드부터 부모노드를 출력
            sb.append(parent[i]).append('\n');
        }

        System.out.print(sb);
    }
}
