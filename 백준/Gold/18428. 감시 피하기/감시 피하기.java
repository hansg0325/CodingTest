import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static boolean flag = false;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        setUpObstacles(0);

        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static void setUpObstacles(int count) {
        if (flag) {
            return;
        }
        if (count == 3) {
            if (monitorStudents()) {
                flag = true;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'X') {
                    map[i][j] = 'O';
                    setUpObstacles(count + 1);
                    map[i][j] = 'X';
                }
            }
        }
    }
    static boolean monitorStudents() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'T') {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        while (nx >= 0 && nx < N && ny >= 0 & ny < N) {
                            if (map[nx][ny] == 'O') {
                                break;
                            }
                            if (map[nx][ny] == 'S') {
                                return false;
                            } else {
                                nx += dx[k];
                                ny += dy[k];
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
