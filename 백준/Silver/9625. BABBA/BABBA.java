import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        // dp 배열 정의
        int[] dpA = new int[K + 1]; // K + 1인 이유 0번 눌렀을 때 부터 K번 눌렀을 때 까지의 상태를 저장하기 위함
        int[] dpB = new int[K + 1];

        // 초기값 설정
        dpA[0] = 1;
        dpB[0] = 0;

        // dp 배열 채우기
        for (int i = 1; i <= K; i++) {
            dpA[i] = dpB[i-1];
            dpB[i] = dpA[i - 1] + dpB[i - 1];
        }

        System.out.println(dpA[K] + " " + dpB[K]);
    }
}