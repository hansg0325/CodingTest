import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] office;
    static ArrayList<CCTV> cctvs = new ArrayList<>();
    static int minBlindSpot = Integer.MAX_VALUE;
    
    static int[] dx = {-1, 0, 1, 0}; // 상우하좌
    static int[] dy = {0, 1, 0, -1}; 
    
    static class CCTV {
        int x, y, type;
        
        CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        office = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] >= 1 && office[i][j] <= 5) {
                    cctvs.add(new CCTV(i, j, office[i][j]));
                }
            }
        }
        
        dfs(0, office);
        System.out.println(minBlindSpot);
    }
    
    static void dfs(int idx, int[][] map) {
        if (idx == cctvs.size()) {
            int blindSpot = countBlindSpot(map);
            minBlindSpot = Math.min(minBlindSpot, blindSpot);
            return;
        }
        
        CCTV cctv = cctvs.get(idx);
        int[][] directions = getDirections(cctv.type);
        
        for (int[] dir : directions) {
            int[][] tempMap = copyMap(map);
            for (int d : dir) {
                watch(tempMap, cctv.x, cctv.y, d);
            }
            dfs(idx + 1, tempMap);
        }
    }
    
    static int[][] getDirections(int type) {
        switch (type) {
            case 1:
                return new int[][]{{0}, {1}, {2}, {3}};
            case 2:
                return new int[][]{{0, 2}, {1, 3}};
            case 3:
                return new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 0}};
            case 4:
                return new int[][]{{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}};
            case 5:
                return new int[][]{{0, 1, 2, 3}};
            default:
                return new int[0][];
        }
    }
    
    static void watch(int[][] map, int x, int y, int dir) {
        int nx = x;
        int ny = y;
        
        while (true) {
            nx += dx[dir];
            ny += dy[dir];
            
            if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 6) {
                break;
            }
            
            if (map[nx][ny] == 0) {
                map[nx][ny] = 7; // 감시할 수 있는 영역을 표시
            }
        }
    }
    
    static int countBlindSpot(int[][] map) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
    
    static int[][] copyMap(int[][] map) {
        int[][] newMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[i][j] = map[i][j];
            }
        }
        return newMap;
    }
}
