import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] dist;
    static List<List<int[]>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());


        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        dist = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(u).add(new int[]{v, cost});
        }

        for (int i = 1; i <= N; i++) {
            dijkstra(i);
        }


        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            max = Math.max(dist[X][i] + dist[i][X], max);
        }
        System.out.println(max);
    }

    static void dijkstra(int start) {
        Arrays.fill(dist[start], Integer.MAX_VALUE);
        dist[start][start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentCost = current[1];

            if (currentCost > dist[start][currentNode]) {
                continue;
            }

            for (int[] edge : graph.get(currentNode)) {
                int nextNode = edge[0];
                int nextCost = edge[1] + currentCost;

                if (nextCost < dist[start][nextNode]) {
                    dist[start][nextNode] = nextCost;
                    pq.add(new int[]{nextNode, nextCost});
                }
            }
        }
    }
}