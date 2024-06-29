import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] power = new int[N];
        for (int i = 0; i < N; i++) {
            power[i] = sc.nextInt();
        }

        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }

        // 최장 감소 부분 수열 계산
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (power[i] < power[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // dp 배열에서 최대값 찾기
        int maxLDS = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] > maxLDS) {
                maxLDS = dp[i];
            }
        }

        // 최소 제외 병사 수
        int minRemovals = N - maxLDS;
        System.out.println(minRemovals);
    }
}
