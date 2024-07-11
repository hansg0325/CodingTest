import java.io.*;
import java.util.*;

public class Main {
    // 간선 정보를 저장할 Edge 클래스
    static class Edge {
        int to, cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static int n, p, k; // 컴퓨터의 수, 케이블의 수, 무료 케이블의 수
    static List<Edge>[] graph; // 그래프를 인접 리스트로 표현
    static final int INF = Integer.MAX_VALUE; // 무한대를 나타내는 값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 입력을 통해 컴퓨터 수, 케이블 수, 무료 케이블 수를 받음
        n = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int maxCost = 0; // 가장 비싼 케이블의 비용을 저장하기 위한 변수
        // 케이블 정보를 입력받고 그래프에 추가
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, cost));
            graph[v].add(new Edge(u, cost));
            maxCost = Math.max(maxCost, cost); // 가장 비싼 케이블 비용 업데이트
        }

        // 이진 탐색 범위 설정
        int left = 0, right = maxCost;
        int result = -1; // 결과를 저장할 변수
        
        // 이진 탐색을 통해 최소 비용을 찾음
        while (left <= right) {
            int mid = (left + right) / 2;
            if (dijkstra(mid)) {
                result = mid;
                right = mid - 1; // 가능한 경우 더 낮은 비용을 찾기 위해 right를 줄임
            } else {
                left = mid + 1; // 불가능한 경우 비용을 높이기 위해 left를 늘림
            }
        }

        // 결과 출력
        System.out.println(result);
    }

    // 다익스트라 알고리즘을 수정하여 특정 비용 이하의 간선을 우선적으로 사용
    static boolean dijkstra(int maxEdgeCost) {
        // 우선순위 큐를 사용하여 최소 비용을 가지는 경로를 찾음
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[n + 1]; // 각 노드까지의 비용을 저장
        Arrays.fill(dist, INF); // 초기 값을 무한대로 설정
        dist[1] = 0; // 시작 노드는 0으로 설정
        pq.add(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int used = current[1];

            // 현재 노드와 연결된 모든 간선을 탐색
            for (Edge edge : graph[u]) {
                int v = edge.to;
                int newUsed = used + (edge.cost > maxEdgeCost ? 1 : 0); // 비용이 maxEdgeCost를 초과하면 사용된 간선으로 카운트
                
                // 더 적은 비용으로 v에 도달할 수 있다면 업데이트
                if (newUsed < dist[v]) {
                    dist[v] = newUsed;
                    pq.add(new int[]{v, newUsed});
                }
            }
        }

        // N번 노드에 도달할 수 있는지 여부를 반환
        return dist[n] <= k;
    }
}
