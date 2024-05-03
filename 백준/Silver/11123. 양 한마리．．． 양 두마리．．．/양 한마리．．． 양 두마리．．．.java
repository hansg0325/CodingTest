import java.io.*;
import java.util.*;

public class Main {
    static char[][] graph;
    static boolean[][] visited;
    static int T, H, W, answer = 0;
    static Queue<int[]> queue;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {-0, 0, -1, 1};
    static ArrayList<int[]> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            graph = new char[H][W];
            visited = new boolean[H][W];
            queue = new LinkedList<>();
            list = new ArrayList<>();
            answer = 0;
            for (int j = 0; j < H; j++) {
                String input = br.readLine();
                for (int k = 0; k < W; k++) {
                    graph[j][k] = input.charAt(k);
                }
            }
            for (int j = 0; j < H; j++) {
                for (int k = 0; k < W; k++) {
                    if (graph[j][k] == '#') {
                        if (!visited[j][k]) {
                            queue.offer(new int[]{j, k});
                            visited[j][k] = true;
                            bfs();
                            answer++;
                        }
                    }
                }
            }
            bw.write(answer + "\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
                    if (graph[nx][ny] == '#') {
                        if (!visited[nx][ny]) {
                            visited[nx][ny] = true;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }
}