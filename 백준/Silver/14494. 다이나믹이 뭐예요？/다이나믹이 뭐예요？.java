import java.util.Scanner;

public class Main {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();

        long[][] dp = new long[n+1][m+1];
        
        dp[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) continue;
                if (i > 1) dp[i][j] = (dp[i][j] + dp[i-1][j]) % MOD;
                if (j > 1) dp[i][j] = (dp[i][j] + dp[i][j-1]) % MOD;
                if (i > 1 && j > 1) dp[i][j] = (dp[i][j] + dp[i-1][j-1]) % MOD;
            }
        }

        System.out.println(dp[n][m]);
    }
}
