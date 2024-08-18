import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, answer = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 팀 크기를 1명부터 N-1명까지 선택
        for (int teamSize = 1; teamSize <= N / 2; teamSize++) {
            solve(0, 0, teamSize);
        }

        System.out.println(answer);
    }

    static void solve(int depth, int idx, int teamSize) {
        if (depth == teamSize) {
            answer = Math.min(calculate(), answer);
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                solve(depth + 1, i + 1, teamSize);
                visited[i] = false;
            }
        }
    }

    static int calculate() {
        int start = 0, link = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i] && visited[j]) {
                    start += arr[i][j];
                } else if (!visited[i] && !visited[j]) {
                    link += arr[i][j];
                }
            }
        }
        int diff = Math.abs(start - link);
        return diff;
    }
}
