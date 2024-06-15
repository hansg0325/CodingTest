import java.io.*;
import java.util.*;

public class Main {
    static int L, W;
    static char[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        graph = new char[L][W];
        Queue<int[]> LandPos = new LinkedList<>();
        for (int i = 0; i < L; i++) {
            String input = br.readLine();
            for (int j = 0; j < W; j++) {
                graph[i][j] = input.charAt(j);
                if (graph[i][j] == 'L') {
                    LandPos.add(new int[]{i, j});
                }
            }
        }

        int Treasure = 0;
        while (!LandPos.isEmpty()) {
            int[] Land = LandPos.poll();
            int LandX = Land[0];
            int LandY = Land[1];
            Treasure = Math.max(Treasure, bfs(LandX, LandY));
        }
        System.out.println(Treasure);
    }

    static int bfs(int LandX, int LandY) {
        int max = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{LandX, LandY, 0});
        boolean[][] visited = new boolean[L][W];
        visited[LandX][LandY] = true;
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            int count = tmp[2];
            max = Math.max(max, count);
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < L && ny >= 0 && ny < W) {
                    if (!visited[nx][ny]) {
                        if (graph[nx][ny] == 'L') {
                            visited[nx][ny] = true;
                            queue.add(new int[]{nx, ny, count + 1});
                        }
                    }
                }
            }
        }
        return max;
    }
}