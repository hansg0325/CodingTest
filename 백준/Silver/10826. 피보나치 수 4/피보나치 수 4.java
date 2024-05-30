import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        
        
        if (n == 0) {
            bw.write("0");
        } else if (n == 1) {
            bw.write("1");
        } else {
            BigInteger[] dp = new BigInteger[n + 1];

            dp[0] = BigInteger.ZERO;
            dp[1] = BigInteger.ONE;

            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 2].add(dp[i - 1]);
            }

            bw.write(dp[n].toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}