import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        int[][] dpMax = new int[N][3];
        int[][] dpMin = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dpMax[0][0] = arr[0][0];
        dpMax[0][1] = arr[0][1];
        dpMax[0][2] = arr[0][2];
        dpMin[0][0] = arr[0][0];
        dpMin[0][1] = arr[0][1];
        dpMin[0][2] = arr[0][2];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dpMax[i][j] = arr[i][j] + Math.max(dpMax[i - 1][j], dpMax[i - 1][j + 1]);
                    dpMin[i][j] = arr[i][j] + Math.min(dpMin[i - 1][j], dpMin[i - 1][j + 1]);
                } else if (j == 1) {
                    dpMax[i][j] = arr[i][j] + Math.max(dpMax[i - 1][j - 1], Math.max(dpMax[i - 1][j], dpMax[i - 1][j + 1]));
                    dpMin[i][j] = arr[i][j] + Math.min(dpMin[i - 1][j - 1], Math.min(dpMin[i - 1][j], dpMin[i - 1][j + 1]));
                } else if (j == 2) {
                    dpMax[i][j] = arr[i][j] + Math.max(dpMax[i - 1][j - 1], dpMax[i - 1][j]);
                    dpMin[i][j] = arr[i][j] + Math.min(dpMin[i - 1][j - 1], dpMin[i - 1][j]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            max = Math.max(max, dpMax[N - 1][i]);
            min = Math.min(min, dpMin[N - 1][i]);
        }
        System.out.println(max + " " + min);

        /**
         * dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j+1])
         *
         * dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1])
         *
         * dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])
         */



    }
}
