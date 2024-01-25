import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        BigInteger[] dist = new BigInteger[N - 1]; // 거리 배열
        BigInteger[] cost = new BigInteger[N]; // 비용 배열

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N - 1; i++) {
            dist[i] = new BigInteger(st.nextToken()); // 거리 배열 입력
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            cost[i] = new BigInteger(st.nextToken()); // 비용 배열 입력
        }

        BigInteger total = BigInteger.ZERO; // 총 주유 비용
        BigInteger min = cost[0]; // 가장 싼 기름 값
        for (int i = 0; i < N-1; i++) {
            if (min.compareTo(cost[i]) > 0) { // 현재 가장 싼 기름 값 보다 더 싼 곳이 있을경우 갱신
                min = cost[i]; //min 이 cost[i] 보다 크면 1, 같으면 0, 작으면 -1
            }
            total = total.add(min.multiply(dist[i])); // 가야할 거리 * 현재 가장 싼 기름값
        }
        System.out.println(total); // 출력
    }
}
