import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1}; // 상, 하, 좌, 우
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new char[R][C];
        visited = new boolean[R][C];
        int answer = 0;

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = input.charAt(j);
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] == '#') {
                    if (!visited[i][j]) {
                        bfs(i, j);
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (!visited[nx][ny]) {
                        if (graph[nx][ny] == '#') {
                            visited[nx][ny] = true;
                            bfs(nx, ny);
                        }
                    }
                }
            }
        }
    }
}