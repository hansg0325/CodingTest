import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /**
         * 1. dp배열 정의
         * 오름차순 dpU[n] : dp[n-1]의 값과 비교해 같거나 오름차순 형태라면 dp[n-1] + 1 아니라면 1
         * 내림차순 dpL[n] : dp[n-1]의 값과 비교해 같거나 내림차순 형태라면 dp[n-1] + 1 아니라면 1
         * 2. 초기값 설정
         * dpU[1] = 1
         * dpL[1] = 1
         * 3. 점화식 작성
         * dpU[n] = if(nowNum>=postNum){
         *              dpU[n] = dpU[n-1] + 1
         *          } else {
         *              dpU[n] = 1
         *          }
         * dpL[n] = if(nowNum<=postNum){
         *              dpU[n] = dpL[n-1] + 1
         *          } else {
         *              dpL[n] = 1
         *          }
         */

        int N = Integer.parseInt(br.readLine());
        int[] dpU = new int[N + 1];
        int[] dpL = new int[N + 1];
        dpU[0] = 1;
        dpL[0] = 1;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int postNum = Integer.parseInt(st.nextToken());
        int max = 1;
        for (int i = 1; i < N; i++) {
            int nowNum = Integer.parseInt(st.nextToken());
            if (nowNum > postNum) {
                dpU[i] = dpU[i - 1] + 1;
                dpL[i] = 1;
            } else if (nowNum == postNum) {
                dpU[i] = dpU[i - 1] + 1;
                dpL[i] = dpL[i - 1] + 1;
            } else {
                dpL[i] = dpL[i - 1] + 1;
                dpU[i] = 1;
            }
            postNum = nowNum;
            max = Math.max(max, Math.max(dpU[i], dpL[i]));
        }
        System.out.println(max);
    }
}