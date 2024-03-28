import java.io.*;
import java.util.*;

public class Main {
    static int R, C, K, answer = 0;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new char[R][C];
        visited = new boolean[R][C];
        visited[R-1][0] = true;

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = input.charAt(j);
            }
        }

        dfs(R-1, 0, 1); // 시작지점은 왼쪽 아래
        System.out.println(answer);

    }

    static void dfs(int x, int y, int k) {
        if (x == 0 && y == C - 1) { // 오른쪽 위에 도착했을 경우
            if (k == K) { // 이동한 거리가 K일 경우
                answer++; // 1씩 증가
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < R && ny >= 0 && ny < C) { // graph 안에 있는경우
                if (!visited[nx][ny] && graph[nx][ny] != 'T') { // 방문하지 않은곳인 면서 T가 아닌곳
                    visited[nx][ny] = true;
                    dfs(nx, ny, k + 1);
                    visited[nx][ny] = false;
                }
            }
        }
    }
}