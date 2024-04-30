import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] graph;
    static int[] dx = {1, 0}; // 아래쪽
    static int[] dy = {0, 1}; // 오른쪽
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();

    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {

            int tmp[] = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            if (x == (M - 1) && y == (N - 1)) {
                System.out.println("Yes");
                return;
            }
            for (int i = 0; i < 2; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < M && ny < N) { // graph 범위일경우
                    if (graph[nx][ny] == 1) { // 갈수 있는 칸일 경우
                        if (!visited[nx][ny]) { // 방문하지 않은 칸일 경우
                            visited[nx][ny] = true;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        System.out.println("No");
    }
}