import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[][] resources = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                resources[i][j] = scanner.nextInt();
            }
        }

        int[][] dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = resources[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + resources[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + resources[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + resources[i][j];
                }
            }
        }

        System.out.println(dp[N - 1][M - 1]);
    }
}
