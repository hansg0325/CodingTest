import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] playersStats;
    static boolean[] positions;
    static int C, max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        C = Integer.parseInt(br.readLine());
        for (int i = 0; i < C; i++) {
            playersStats = new int[11][11];
            positions = new boolean[11];

            for (int j = 0; j < 11; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < 11; k++) {
                    playersStats[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            max = Integer.MIN_VALUE;
            lineUp(0, 0);
            System.out.println(max);
        }
    }

    static void lineUp(int idx, int sum) {
        if (idx == 11) {
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < 11; i++) {
            if (!positions[i] && playersStats[idx][i] != 0) {
                positions[i] = true;
                lineUp(idx + 1, sum + playersStats[idx][i]);
                positions[i] = false;
            }
        }
    }
}
