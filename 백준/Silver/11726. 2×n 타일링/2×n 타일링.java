import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /**
         * 1. 문제이해
         * 2. dp배열정의
         * 3. 초기값 설정
         * 4. 점화식 작성
         * 5. dp배열 채우기
         * 6. 출력
         */

        /**
         * 2.
         * dpV[n] = 끝부분 블럭이 세로인 것
         * dpH[n] = 끝부분 블룩이 가로인 것
         * dpV[1] = 1, dpH[1] = 0
         * dpV[2] = 1, dpH[2] = 1
         * dpV[3] = 2, dpH[3] = 1
         * dpV[4] = 3, dpH[4] = 2
         * dpV[5] = 5, dpH[5] = 2
         *
         * 3.
         * dpV[1] = 1, dpH[1] = 0
         * dpV[2] = 1, dpH[2] = 1
         *
         * 4. dpV[n] = dpV[n-1] + dpH[n-1], dpH[n] = n/2
         */

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n + 2];
        dp[1] = 1;
        dp[2] = 2;


        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] = dp[i] % 10007;
        }

        System.out.println(dp[n]);
    }
}