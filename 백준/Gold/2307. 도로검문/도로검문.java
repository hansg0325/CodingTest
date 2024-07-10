import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<int[]>> graph;
    static int[] dist;
    static int[] parent;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b, t});
            graph.get(b).add(new int[]{a, t});
        }

        int original = dijkstra();
        if (original == INF) {
            System.out.println(-1);
            return;
        }

        int maxDelay = 0;
        for (int i = 2; i <= n; i++) {
            int u = parent[i];
            int v = i;
            for (int j = 0; j < graph.get(u).size(); j++) {
                if (graph.get(u).get(j)[0] == v) {
                    int[] edge = graph.get(u).get(j);
                    graph.get(u).remove(j);
                    for (int k = 0; k < graph.get(v).size(); k++) {
                        if (graph.get(v).get(k)[0] == u) {
                            graph.get(v).remove(k);
                            break;
                        }
                    }

                    int tmp = dijkstra();
                    if (tmp == INF) {
                        System.out.println(-1);
                        return;
                    }
                    int delay = tmp - original;
                    maxDelay = Math.max(maxDelay, delay);

                    graph.get(u).add(j, edge);
                    graph.get(v).add(new int[]{u, edge[1]});
                    break;
                }
            }
        }

        System.out.println(maxDelay);
    }

    static int dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{1, 0});
        dist = new int[n + 1];
        parent = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentCost = current[1];

            if (currentCost > dist[currentNode]) {
                continue;
            }

            for (int[] edge : graph.get(currentNode)) {
                int nextNode = edge[0];
                int nextCost = edge[1] + currentCost;

                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.add(new int[]{nextNode, nextCost});
                    parent[nextNode] = currentNode;
                }
            }
        }

        return dist[n];
    }
}
