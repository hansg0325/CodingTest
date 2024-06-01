import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][2];

        // 초기값 설정
        dp[1][0] = 0;
        dp[1][1] = 1;

        // DP 배열 채우기
        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        // 최종 결과 출력
        long result = dp[N][0] + dp[N][1];
        System.out.println(result);
    }
}