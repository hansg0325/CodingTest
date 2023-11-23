import java.io.*;
import java.util.*;

public class Main {
    static int N,result, count, nx, ny;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1}; // 상하좌우 4방탐색
    static int[] dy = {1, -1, 0, 0};
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        // graph 초기화
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                // 건물의 높이들이 담긴 리스트
                if (!list.contains(graph[i][j])) { // 중복체크
                    list.add(graph[i][j]);
                }
            }
        }

        result = 1;
        for (Integer height : list) { // 0부터 끝까지 탐색하는것은 비효율적이기 때문에 리스트 활용
            count = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && graph[i][j] >= height) {
                        count++;
                        dfs(height, i, j);
                    }
                }
            }
            result = Math.max(result, count); // 새로탐색한결과 중에 더 큰값 저장
        }
        System.out.println(result);
    }

    static void dfs(int height, int x, int y) {
        visited[x][y] = true;
        // 4방탐색
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) { // 그래프 범위 안에 있을 경우
                if (!visited[nx][ny]) { // 방문하지 않은 건물인 경우
                    if (graph[nx][ny] >= height) { // 그 건물이 물의 높이보다 높을 경우
                        dfs(height, nx, ny);  // 상하좌우 인접한 건물을 찾는다
                    }
                }
            }
        }
    }

}
