import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
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
        
        int year = 0;
        while (true) {
            year++;
            // 1년 경과 후 빙산의 높이를 줄입니다.
            int[][] nextMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > 0) {
                        int count = 0;
                        for (int d = 0; d < 4; d++) {
                            int ni = i + dx[d];
                            int nj = j + dy[d];
                            if (map[ni][nj] == 0) {
                                count++;
                            }
                        }
                        nextMap[i][j] = Math.max(0, map[i][j] - count);
                    }
                }
            }
            map = nextMap;
            
            // 빙산 덩어리 개수를 셉니다.
            int count = countIcebergs();
            if (count == 0) {
                // 모든 빙산이 녹음
                System.out.println(0);
                break;
            } else if (count > 1) {
                // 두 개 이상의 덩어리로 분리됨
                System.out.println(year);
                break;
            }
        }
    }
    
    static int countIcebergs() {
        visited = new boolean[N][M];
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            
            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] > 0 && !visited[nx][ny]) {
                    queue.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
