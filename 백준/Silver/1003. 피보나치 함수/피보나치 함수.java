import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] count0 = new int[41];
    static int[] count1 = new int[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        // 피보나치의 0과 1에 대한 기본값 설정
        count0[0] = 1; // fibonacci(0) -> "0"이 1번 출력
        count1[0] = 0; // fibonacci(0) -> "1"이 0번 출력
        count0[1] = 0; // fibonacci(1) -> "0"이 0번 출력
        count1[1] = 1; // fibonacci(1) -> "1"이 1번 출력

        // 미리 0과 1의 출현 횟수를 계산해 놓음 (DP 테이블 채우기)
        for (int i = 2; i <= 40; i++) {
            count0[i] = count0[i-1] + count0[i-2];
            count1[i] = count1[i-1] + count1[i-2];
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(count0[N]).append(" ").append(count1[N]).append("\n");
        }

        System.out.print(sb.toString());
    }
}
