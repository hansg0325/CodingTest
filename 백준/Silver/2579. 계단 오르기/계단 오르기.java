import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         * 1. 문제이해
         * 한번에 한 계단이나 두 계단 오를 수 있다
         * 마지막 계단은 밟아야 한다
         * 연속된 세 개의 계단을 연속으로 밟을 수는 없다
         * n번째 계단을 밟았을 때의 점수 총합
         * 2. dp 배열 정의
         * dp[n] = n번 째 계단까지의 최대 점수
         * 3. 초기값 설정
         * 계단이 하나만있는경우와 두개만 있는경우를 따로 설정해주어야한다
         * dp[0] = scores[0]
         * dp[1] = scores[0] + scores[1]
         * 4. 점화식 작성
         * dp[i]는 두 가지 경우에서 최댓값을 가진다
         * dp[i-2] + scores[i] (두 계단 전에서 오는 경우)
         * dp[i-3] + scores[i-1] + scores[i] 세 계단 전에서 오는 경우
         */


        int n = Integer.parseInt(br.readLine());
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(scores[0]);
            return;
        }

        if (n == 2) {
            System.out.println(scores[0] + scores[1]);
            return;
        }

        int[] dp = new int[n];
        dp[0] = scores[0];
        dp[1] = scores[0] + scores[1];
        dp[2] = Math.max(scores[0] + scores[2], scores[1] + scores[2]);

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i-2] + scores[i], dp[i-3] + scores[i-1] + scores[i]);
        }

        System.out.println(dp[n-1]);
    }
}