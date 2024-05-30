import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        long[] dp = new long[n + 1];
        if (n == 1) {
            System.out.println(4);
        } else {
            dp[1] = 1;
            dp[2] = 1;

            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 2] + (dp[i - 1]);
            }

            System.out.println(dp[n]*4 + dp[n-1]*2);
        }

        br.close();
    }
}