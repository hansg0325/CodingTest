import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[51];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= 50 ; i++){
            dp[i] = (dp[i-1] + dp[i-2] + 1) % 1000000007;
        }

        System.out.println(dp[n]%1000000007);
    }
}