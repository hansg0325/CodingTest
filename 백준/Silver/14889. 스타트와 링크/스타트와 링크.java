import java.io.*;
import java.util.*;

public class Main {
    static int N, result = Integer.MAX_VALUE;
    static int[][] graph;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        // graph 초기화
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(result);
    }

    static void dfs(int depth, int idx) {
        if (depth == N / 2) { // N/2 번 탐색 후 팀이 완성될경우
            teamDiff(); // 두 팀의 전력차를 비교하는 함수
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }

    }

    static void teamDiff() {
        int teamStart = 0;
        int teamLink = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    teamStart += graph[i][j];
                    teamStart += graph[j][i];
                } else if (!visited[i] && !visited[j]) {
                    teamLink += graph[i][j];
                    teamLink += graph[j][i];
                }
            }
        }

        // 음수가 나올수 있기 때문에 절대값으로 비교
        int diff = Math.abs(teamStart - teamLink);
        result = Math.min(result, diff);
    }
}
