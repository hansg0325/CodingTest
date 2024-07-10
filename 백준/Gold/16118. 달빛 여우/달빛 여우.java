import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<int[]>> graph;
    static long[] foxDist;
    static long[][] wolfDist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
            graph.get(a).add(new int[]{b, c * 2}); // 양방향 간선
            graph.get(b).add(new int[]{a, c * 2}); // 양방향 간선
        }

        foxDist = new long[n + 1];
        wolfDist = new long[2][n + 1];
        dijkstraFox(1);
        dijkstraWolf(1);

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (foxDist[i] < Math.min(wolfDist[0][i], wolfDist[1][i])) {
                count++;
            }
        }
        System.out.println(count);
    }

    static void dijkstraFox(int start) {
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        Arrays.fill(foxDist, Long.MAX_VALUE);
        foxDist[start] = 0;
        pq.add(new long[]{start, 0});

        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            int currentNode = (int) current[0];
            long currentCost = current[1];

            if (currentCost > foxDist[currentNode]) continue;

            for (int[] edge : graph.get(currentNode)) {
                int nextNode = edge[0];
                long nextCost = currentCost + edge[1];

                if (nextCost < foxDist[nextNode]) {
                    foxDist[nextNode] = nextCost;
                    pq.add(new long[]{nextNode, nextCost});
                }
            }
        }
    }

    static void dijkstraWolf(int start) {
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        Arrays.fill(wolfDist[0], Long.MAX_VALUE);
        Arrays.fill(wolfDist[1], Long.MAX_VALUE);
        wolfDist[0][start] = 0;
        pq.add(new long[]{start, 0, 0});

        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            int currentNode = (int) current[0];
            long currentCost = current[1];
            int state = (int) current[2];

            if (currentCost > wolfDist[state][currentNode]) continue;

            for (int[] edge : graph.get(currentNode)) {
                int nextNode = edge[0];
                long nextCost = edge[1];
                if (state == 0) { // 뛸수있는상태라 뛰어감
                    nextCost /= 2;
                } else { // 이미 뛴 상태라 더 느리게 감
                    nextCost *= 2;
                }
                nextCost += currentCost;

                int nextState = state == 0 ? 1 : 0;

                if (nextCost < wolfDist[nextState][nextNode]) {
                    wolfDist[nextState][nextNode] = nextCost;
                    pq.add(new long[]{nextNode, nextCost, nextState});
                }
            }
        }
    }
}
