import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] maze;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = input.charAt(j) - '0';
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        visited = new boolean[N][M];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            int count = tmp[2];
            if (x == N - 1 && y == M - 1) {
                System.out.println(count);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && maze[nx][ny] == 1) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, count + 1});
                    }
                }
            }
        }
    }
}
