import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int[] testCases = new int[T];

        int maxN = 0;
        for (int i = 0; i < T; i++) {
            testCases[i] = sc.nextInt();
            maxN = Math.max(maxN, testCases[i]);
        }

        // 최대 n이 64이므로 65로 배열 크기를 설정
        long[][] dp = new long[65][10];

        // 초기화: 1자리 수는 모두 1가지 경우
        for (int j = 0; j <= 9; j++) {
            dp[1][j] = 1;
        }

        // DP 갱신
        for (int i = 2; i <= maxN; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }

        // 각 n에 대한 결과 출력
        for (int n : testCases) {
            long result = 0;
            for (int j = 0; j <= 9; j++) {
                result += dp[n][j];
            }
            System.out.println(result);
        }
    }
}