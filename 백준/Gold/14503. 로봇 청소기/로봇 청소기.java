import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] room;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1}; // 북, 동, 남, 서 순서
    static int count = 0;
    static boolean flag;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");

        int robotX = Integer.parseInt(st.nextToken());
        int robotY = Integer.parseInt(st.nextToken());
        int robotHead = Integer.parseInt(st.nextToken());
        room = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        clean(robotX, robotY, robotHead);
        System.out.println(count);
    }

    static void clean(int x, int y, int head) {
        // 현재 위치가 더럽다면 청소
        if (room[x][y] == 0) {
            room[x][y] = 2; // 현재 위치 청소
            count++;
        }
        flag = false;
        for (int i = 0; i < 4; i++) {
            int nextHead = (head + 3) % 4; // 반시계 방향으로 90도 회전한 방향이 청소할 구역인지
            int nextX = x + dx[nextHead];
            int nextY = y + dy[nextHead];
            if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                if (room[nextX][nextY] == 0) {
                    clean(nextX, nextY, nextHead);
                    flag = true; // 청소할 구역이 있는 경우
                    break;
                }
            }
            head = (head + 3) % 4; // 반시계 90도 회전
        }


        if (!flag) { // 네 방향이 모두 청소된곳이거나 벽인 경우
            int nextHead = (head + 2) % 4; // 후진
            int nextX = x + dx[nextHead];
            int nextY = y + dy[nextHead];
            if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) { // 후진할 공간이 있을 경우
                if (room[nextX][nextY] != 1) {
                    clean(nextX, nextY, head); // 후진
                }
            }
        }
    }
}