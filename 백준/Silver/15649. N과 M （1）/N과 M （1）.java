import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] checked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        checked = new boolean[N + 1];

        backTracking(0);
    }

    static void backTracking(int depth) {
        if (depth == M) { // depth 가  M이 되면 출력
            for (int i = 0; i < M; i++) { // 길이가 M인 수열 출력
                System.out.print(arr[i] + " "); // 출력
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!checked[i]) { // 사용하지 않은 숫자일 경우
                checked[i] = true; // 사용한 숫자는 true 로
                arr[depth] = i; // 배열에 담아둠
                backTracking(depth + 1);
                checked[i] = false; // 사용이 끝났으면 다시 false 로
            }
        }
    }
}