import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] candy = new int[N + 1][M + 1];
        int[][] dp = new int[N + 1][M + 1];

        // Initialize the candy map
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                candy[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DP to calculate the maximum candies that can be collected
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = candy[i][j];
                if (i > 1) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + candy[i][j]); // 가장 위쪽줄은 제외
                if (j > 1) dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + candy[i][j]); // 가장 왼쪽줄인경우는 제외
                if (i > 1 && j > 1) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + candy[i][j]);
            }
        }

        // The result is in the bottom-right corner of the DP table
        System.out.println(dp[N][M]);
    }
}
