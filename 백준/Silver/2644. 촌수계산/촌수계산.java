import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] dist;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        dist = new int[n + 1];
        visited = new boolean[n + 1];

        st = new StringTokenizer(br.readLine(), " ");
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        System.out.println(bfs(p1, p2));
    }

    static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        dist[start] = 0;
        visited[start] = true;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 0; i < graph.get(cur).size(); i++) {
                if (!visited[graph.get(cur).get(i)]) {
                    dist[graph.get(cur).get(i)] = dist[cur] + 1;
                    if (graph.get(cur).get(i) == end) {
                        return dist[graph.get(cur).get(i)];
                    }
                    queue.offer(graph.get(cur).get(i));
                    visited[graph.get(cur).get(i)] = true;
                }
            }
        }
        return -1;
    }
}