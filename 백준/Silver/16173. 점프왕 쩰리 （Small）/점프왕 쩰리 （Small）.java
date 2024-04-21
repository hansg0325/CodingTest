import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dx = {1, 0}; // 아래, 오른쪽
    static int[] dy = {0, 1}; // 아래, 오른쪽
    static int[][] graph;
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        bfs();

    }
    static void bfs() {
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            if (graph[x][y] == -1) {
                System.out.println("HaruHaru");
                return;
            }
            for (int i = 0; i < 2; i++) {
                int nx = x + dx[i] * graph[x][y];
                int ny = y + dy[i] * graph[x][y];
                if (nx < N && ny < N && !visited[nx][ny]) { // graph 범위 내라면
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        System.out.println("Hing");
    }
}