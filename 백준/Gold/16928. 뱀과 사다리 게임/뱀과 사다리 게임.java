import java.io.*;
import java.util.*;

public class Main {
    static int[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        graph = new int[101];
        for (int i = 1; i <= 100; i++) {
            graph[i] = i;
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u] = v;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u] = v;
        }

        int result = bfs(1);
        System.out.println(result);
    }

    static int bfs(int startNode) {
        int[] check = new int[101];
        Queue<Integer> q = new LinkedList<>();
        q.offer(startNode);
        check[startNode] = 0;

        while (true) {
            int visitedNum = q.poll();
            for (int i = 1; i <= 6; i++) {
                int newNode = visitedNum + i;

                if (newNode > 100) {
                    continue;
                }

                if (check[graph[newNode]] == 0) {
                    q.offer(graph[newNode]);
                    check[graph[newNode]] = check[visitedNum] + 1;
                }
                if (graph[newNode] == 100) {
                    return check[100];
                }
            }
        }
    }
}