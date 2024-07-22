import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        Integer[] B = new Integer[N];

        String[] aValues = br.readLine().split(" ");
        String[] bValues = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(aValues[i]);
            B[i] = Integer.parseInt(bValues[i]);
        }

        // A는 오름차순으로 정렬
        Arrays.sort(A);

        // B는 내림차순으로 정렬
        Arrays.sort(B, Collections.reverseOrder());

        // S값 계산
        int S = 0;
        for (int i = 0; i < N; i++) {
            S += A[i] * B[i];
        }

        // 결과 출력
        System.out.println(S);
    }
}
