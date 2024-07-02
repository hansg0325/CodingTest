import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int S = scanner.nextInt();
        int M = scanner.nextInt();

        int[] V = new int[N];
        for (int i = 0; i < N; i++) {
            V[i] = scanner.nextInt();
        }

        boolean[][] dp = new boolean[N + 1][M + 1];
        dp[0][S] = true;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (dp[i - 1][j]) {
                    if (j + V[i - 1] <= M) {
                        dp[i][j + V[i - 1]] = true;
                    }
                    if (j - V[i - 1] >= 0) {
                        dp[i][j - V[i - 1]] = true;
                    }
                }
            }
        }

        int maxVolume = -1;
        for (int j = 0; j <= M; j++) {
            if (dp[N][j]) {
                maxVolume = j;
            }
        }

        System.out.println(maxVolume);
    }
}
