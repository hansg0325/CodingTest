import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            // M개중 N개를 뽑는 경우이므로 nCr 에서 n = M, r = N 이다.
            int N = Integer.parseInt(st.nextToken()); // N = r
            int M = Integer.parseInt(st.nextToken()); // M = n

            sb.append(combi(M, N)).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    static int combi(int n, int r) {

        // 이미 계산해놓은 값이 있을 경우 바로 반환
        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        // 2번 성질 
        // n과r이 같거나 r==0 이면 1이다
        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }

        // 1번 성질
        // nCr = n-1Cr-1 + n-1Cr 이다.
        return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }
}