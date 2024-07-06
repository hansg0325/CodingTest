import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 도시의 수와 버스의 수 입력
        int n = sc.nextInt(); // 도시의 수 (1 ≤ N ≤ 1,000)
        int m = sc.nextInt(); // 버스의 수 (1 ≤ M ≤ 100,000)
        
        // 그래프 초기화
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>()); // 각 도시에 대한 연결 리스트 초기화
        }
        
        // 그래프 입력 받기
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(); // 출발 도시 번호
            int v = sc.nextInt(); // 도착 도시 번호
            int cost = sc.nextInt(); // 버스 비용
            graph.get(u).add(new int[]{v, cost}); // 출발 도시 u에서 도착 도시 v로 가는 비용 cost
        }
        
        // 시작점과 끝점 입력
        int start = sc.nextInt(); // 출발점 도시 번호
        int end = sc.nextInt(); // 도착점 도시 번호
        
        // 다익스트라 알고리즘으로 최소 비용 계산
        int[] dist = new int[n + 1]; // 시작점에서 각 도시에 대한 최소 비용을 저장할 배열
        Arrays.fill(dist, Integer.MAX_VALUE); // 초기 값을 무한대로 설정
        dist[start] = 0; // 시작점에서 시작점으로의 비용은 0
        
        // 우선순위 큐 (Priority Queue)를 사용하여 다익스트라 알고리즘 구현
        // 우선순위 큐는 비용이 작은 순서대로 처리하기 위해 Comparator를 사용
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0}); // 시작점을 큐에 추가 (도시 번호, 현재 비용)
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll(); // 큐에서 가장 작은 비용의 노드를 꺼냄
            int currentNode = current[0]; // 현재 노드
            int currentCost = current[1]; // 현재 노드까지의 비용
            
            // 현재 노드까지의 비용이 이미 저장된 최소 비용보다 크면 무시
            if (currentCost > dist[currentNode]) continue;
            
            // 현재 노드와 인접한 모든 노드에 대해 처리
            for (int[] edge : graph.get(currentNode)) {
                int nextNode = edge[0]; // 인접한 노드
                int nextCost = currentCost + edge[1]; // 현재 노드를 거쳐 인접한 노드로 가는 비용
                
                // 새로운 경로가 더 짧은 경우 갱신
                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost; // 최소 비용 갱신
                    pq.add(new int[]{nextNode, nextCost}); // 갱신된 노드를 큐에 추가
                }
            }
        }
        
        // 결과 출력
        System.out.println(dist[end]); // 출발점에서 도착점까지의 최소 비용 출력
    }
}
