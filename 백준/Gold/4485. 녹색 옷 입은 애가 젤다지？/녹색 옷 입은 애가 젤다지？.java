import org.w3c.dom.html.HTMLParagraphElement;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 탐색
    static int[] dy = {0, 0, -1, 1};
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int count = 0;

        while (true) {
            count++;
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            if (N == 0) {
                break;
            }
            graph = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println("Problem " + count + ": " + dijkstra());
        }
        br.close();
    }

    static int dijkstra() {
        // 우선 순위 큐에는 int[] = {x좌표, y좌표, 가중치} 가 담긴다
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);


        int[][] distance = new int[N][N]; // 가중치 배열
        for (int i = 0; i < N; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE); // 모든 가중치 INF로 설정
        }
        queue.offer(new int[]{0, 0, graph[0][0]}); // 좌표 (0, 0) 큐에 추가
        distance[0][0] = graph[0][0];

        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            int x = tmp[0];
            int y = tmp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (distance[nx][ny] > distance[x][y] + graph[nx][ny]) { // 현재 가중치가 새로 찾은 가중치보다 클 경우
                        distance[nx][ny] = distance[x][y] + graph[nx][ny]; // 갱신
                        queue.offer(new int[]{nx, ny, distance[nx][ny]}); // 갱신이 되었다면 큐에 추가
                    }
                }
            }
        }
        return distance[N - 1][N - 1]; // 도착 지점 좌표의 가중치 반환
    }
}