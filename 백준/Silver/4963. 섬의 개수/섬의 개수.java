import java.io.*;
import java.util.*;

public class Main {
    static int w;
    static int h;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1, -1, 1, -1, 1};
    static int[] dy = {1, -1, 0, 0, -1, 1, 1, -1};
    static boolean[][] visit;
    static int count; // 섬의 개수
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) { // w와 h가 0이 되면 종료
            st = new StringTokenizer(br.readLine(), " ");

            // w 지도의 너비, h 지도의 높이
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            // 0이 되면 종료
            if (w == 0 && h == 0) {
                break;
            }

            //지도 배열 선언
            map = new int[h][w];
            //방문한 곳 배열 선언
            visit = new boolean[h][w];
            //지도 입력
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            count = 0;


            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visit[i][j]) { // 섬이 있고 방문하지 않았다면 bfs 함수실행
                        bfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void bfs(int x, int y) {
        visit[x][y] = true;

        //8방탐색
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            //지도범위 안에 있을 경우
            if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                if (map[nx][ny] == 1 && !visit[nx][ny]) { //8방탐색한곳이 방문하지않고, 섬이 존재할경우
                    bfs(nx, ny);
                }
            }
        }
    }
}