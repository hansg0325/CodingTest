import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<long[]>> graph = new ArrayList<>();
    static long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = new long[n + 1];

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            long u = Long.parseLong(st.nextToken());
            long v = Long.parseLong(st.nextToken());
            graph.get((int) u).add(new long[]{v, i});
            graph.get((int) v).add(new long[]{u, i});
        }
        System.out.println(dijkstra());
    }
    static long dijkstra() {
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.add(new long[]{1, 0});
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;
        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            int currentNode = (int) current[0];
            long currentCost = current[1];

            if (currentCost > dist[currentNode]) {
                continue;
            }

            for (long[] edge : graph.get(currentNode)) {
                int nextNode = (int) edge[0];
                long nextCost = edge[1];
                if (currentCost <= nextCost) {
                    nextCost++;
                } else {
                    nextCost = ((long) Math.ceil(((double) currentCost - nextCost) / m)) * m + nextCost + 1;
                }
                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.add(new long[]{nextNode, nextCost});
                }
            }
        }
        return dist[n] == Long.MAX_VALUE ? -1 : dist[n];
    }
}
