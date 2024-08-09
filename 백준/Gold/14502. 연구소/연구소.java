import java.io.*;
import java.util.*;

public class Main {
    static int N, M, result = 0;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backTracking(0);
        System.out.println(result);
    }

    static void backTracking(int depth) {
        if (depth == 3) {
            result = Math.max(result, checkSafeArea(bfs()));
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1; // 벽을세움
                    backTracking(depth + 1);
                    map[i][j] = 0; // 벽을 되돌려놓음
                }
            }
        }
    }
    static int[][] bfs() {
        int[][] newMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, newMap[i], 0, M);
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (newMap[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (newMap[nx][ny] == 0) {
                        newMap[nx][ny] = 2;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return newMap;
    }
    static int checkSafeArea(int[][] newMap) {
        int safeArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (newMap[i][j] == 0) {
                    safeArea++;
                }
            }
        }
        return safeArea;
    }
}
