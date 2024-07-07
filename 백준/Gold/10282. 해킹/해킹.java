import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int T = Integer.parseInt(st.nextToken());


        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            List<List<int[]>> graph = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            for (int k = 0; k < d; k++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                graph.get(b).add(new int[]{a, s});
            }

            int[] dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[c] = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.add(new int[]{c, 0});
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
                    }
                }
            }

            int count = 0;
            int max = Integer.MIN_VALUE;
            for (int l = 1; l <= n; l++) {
                if (dist[l] != Integer.MAX_VALUE) {
                    count++;
                    max = Math.max(max, dist[l]);
                }
            }
            bw.write(count + " " + max + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}