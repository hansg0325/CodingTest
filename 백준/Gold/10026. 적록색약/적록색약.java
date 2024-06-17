import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] NVisited;
    static boolean[][] AbVisited;
    static char[][] graph;
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        NVisited = new boolean[N][N];
        AbVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = input.charAt(j);
            }
        }

        int NCount = 0;
        int AbCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!NVisited[i][j]) {
                    queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    NVisited[i][j] = true;
                    normal(graph[i][j]);
                    NCount++;
                }
                if (!AbVisited[i][j]) {
                    queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    AbVisited[i][j] = true;
                    abnormal(graph[i][j]);
                    AbCount++;
                }
            }
        }
        System.out.println(NCount + " " + AbCount);
    }

    static void normal(char c) {
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (!NVisited[nx][ny]) {
                        if (graph[nx][ny] == c) {
                            NVisited[nx][ny] = true;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }

    static void abnormal(char c) {
        boolean Blue = false;
        if (c == 'B') {
            Blue = true;
        }
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (!AbVisited[nx][ny]) {
                        if (Blue) {
                            if (graph[nx][ny] == c) {
                                AbVisited[nx][ny] = true;
                                queue.add(new int[]{nx, ny});
                            }
                        } else {
                            if (graph[nx][ny] != 'B') {
                                AbVisited[nx][ny] = true;
                                queue.add(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }
    }
}