import java.io.*;
import java.util.*;

public class Main {
    static int N, answer = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            backTracking(i, i, 0, 0);
        }
        System.out.println(answer);
    }

    /**
     * @param start : 메서드 실행 전 위에서 정해줌
     * @param now : 현재 내가 위치한 도시
     * @param sum : 현재위치한 도시까지 사용한 비용
     * @param depth
     */
    static void backTracking(int start, int now, int sum, int depth) { 
        if (depth == N - 1) { // 모든 도시를 모두 방문한 경우, N-1인 이유는 백트래킹 메서드를 실행하기 전에 이미 방문함
            if (map[now][start] != 0) { // 마지막 도시에서 처음 도시로 가는 비용 더하기
                sum += map[now][start];
                answer = Math.min(answer, sum); // 최종적으로 나온 비용
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) { // 방문하지 않은 도시일경우
                if (map[now][i] != 0) { // 갈수 있는 도시일경우
                    visited[i] = true; // 방문했다면 true
                    backTracking(start, i, sum + map[now][i], depth + 1);
                    visited[i] = false; // 방문이 끝나면 false
                }
            }
        }
    }
}