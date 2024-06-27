import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        final int MOD = 9901;

        int[][] dp = new int[N + 1][3];

        dp[1][0] = 1; // 첫 번째 칸에 사자를 배치하지 않은 경우
        dp[1][1] = 1; // 첫 번째 칸의 왼쪽에 사자를 배치한 경우
        dp[1][2] = 1; // 첫 번째 칸의 오른쪽에 사자를 배치한 경우

        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD;
        }

        int result = (dp[N][0] + dp[N][1] + dp[N][2]) % MOD;
        System.out.println(result);
    }
}

