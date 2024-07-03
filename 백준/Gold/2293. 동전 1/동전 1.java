import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        
        int[] dp = new int[k + 1];
        dp[0] = 1; // 0원을 만드는 방법은 아무 동전도 사용하지 않는 한 가지 방법뿐
        
        for (int coin : coins) {
            for (int j = coin; j <= k; j++) {
                dp[j] += dp[j - coin];
            }
        }
        
        System.out.println(dp[k]);
    }
}
