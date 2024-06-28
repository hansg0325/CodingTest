import java.util.Scanner;

public class Main {
    static final int MOD = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        long[][] dp = new long[N+1][10];
        
        // Initialize base case for length 1
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        // Fill the dp table
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j > 0) {
                    dp[i][j] += dp[i-1][j-1];
                }
                if (j < 9) {
                    dp[i][j] += dp[i-1][j+1];
                }
                dp[i][j] %= MOD;
            }
        }

        // Calculate the result
        long result = 0;
        for (int j = 0; j <= 9; j++) {
            result = (result + dp[N][j]) % MOD;
        }

        System.out.println(result);
    }
}
