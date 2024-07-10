import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<int[]>> graph;
    static int[] dist;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) { // n+1개의 정점
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) { // m개의 양방향 간선
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b, c}); // 양방향 간선
            graph.get(b).add(new int[]{a, c}); // 양방향 간선
        }

        result = new int[n + 1];
        dist = new int[n + 1];
        dijkstra(1);

        System.out.println(n - 1);
        for (int i = 2; i <= n; i++) {
            System.out.println(result[i] + " " + i);
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentCost = current[1];

            if (currentCost > dist[currentNode]) continue;

            for (int[] edge : graph.get(currentNode)) {
                int nextNode = edge[0];
                int nextCost = currentCost + edge[1];

                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    result[nextNode] = currentNode;
                    pq.add(new int[]{nextNode, nextCost});
                }
            }
        }
    }
}