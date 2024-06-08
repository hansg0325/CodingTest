import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        /**
         * n == 1   (1)
         * 1
         *
         * n == 2   (2)
         * 1+1, 2
         *
         * n == 3   (4)
         * 1+1+1, 2+1, 1+2, 3
         *
         * n == 4   (7)
         * 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2, 1+3, 3+1
         *
         * n == 5   (13)
         * 1+1+1+1+1, 1+1+1+2, 1+1+2+1, 1+2+1+1, 2+1+1+1, 1+2+2, 2+1+2, 2+2+1, 1+1+3, 1+3+1, 3+1+1, 2+3, 3+2
         *
         */

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[11];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for (int j = 4; j <= n; j++) {
                dp[j] = dp[j - 3] + dp[j - 2] + dp[j - 1];
            }
            bw.write(dp[n] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}