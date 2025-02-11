import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        int[] vipSeats = new int[M];
        for (int i = 0; i < M; i++) {
            vipSeats[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        if (N==2){
            dp[2] = 2;
        } else if (N > 2) {
            dp[2] = 2;
            for (int i = 3; i <= N; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        int index = 1;
        int answer = 1;
        for (int i = 0; i < M; i++) {
            if (dp[vipSeats[i] - index] != 0) {
                answer *= dp[vipSeats[i] - index];
            }
            index = vipSeats[i] + 1;
        }
        if (index <= N) {
            answer *= dp[N + 1 - index];
        }
        System.out.println(answer);
    }
    /*
    dp[i] = i개의 좌석에서 교체가 일어날 경우의 수
    dp[0] = 0
    dp[1] = 1
    1
    dp[2] = 2
    1 2
    2 1
    dp[3] = 3
    1 2 3
    2 1 3

    1 3 2
    dp[4] = 5
    1 2 3 4
    2 1 3 4
    1 3 2 4 -> dp[3]에 숫자하나 더한것들

    1 2 4 3
    2 1 4 3 -> dp[2]에 숫자 2개 더한것
    dp[5] = 8
    1 2 3 4 5
    2 1 3 4 5
    1 3 2 4 5
    1 2 4 3 5
    2 1 4 3 5

    1 2 3 5 4
    2 1 3 5 4
    1 3 2 5 4
    dp[i] = dp[i-1] + dp[i-2]
     */
}
