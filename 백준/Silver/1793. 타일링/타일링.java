import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger[] dp = new BigInteger[251];
        
        // Base cases
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;
        dp[2] = new BigInteger("3");
        
        // Fill the dp array using the recurrence relation
        for (int i = 3; i <= 250; i++) {
            dp[i] = dp[i-1].add(dp[i-2].multiply(new BigInteger("2")));
        }
        
        // Process each test case
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            System.out.println(dp[n]);
        }
        
        scanner.close();
    }
}
