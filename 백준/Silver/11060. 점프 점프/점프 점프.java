import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] maze;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        maze = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            maze[i] = Integer.parseInt(st.nextToken());
        }
        bfs();
    }
    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0] = true;
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int cur = tmp[0];
            int count = tmp[1];
            if (cur == N - 1) {
                System.out.println(count);
                return;
            }
            for (int i = 1; i <= maze[cur]; i++) {
                if (cur + i < N) {
                    if (!visited[cur + i]) {
                        queue.offer(new int[]{cur + i, count + 1});
                        visited[cur + i] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}