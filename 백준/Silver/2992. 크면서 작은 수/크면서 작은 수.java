import java.io.*;
import java.util.*;

public class Main {
    static int N, num, min = Integer.MAX_VALUE;
    static int[] arr, list;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String X = br.readLine();
        num = Integer.parseInt(X);
        N = X.length(); // 입력받은 문자열의 자릿수
        arr = new int[N];
        list = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = X.charAt(i) - '0';
        }
        backTracking(0);
        System.out.println(min == Integer.MAX_VALUE ? 0 : min); // min이 여전히 Integer.MAX_VALUE 라면 0 출력 아니라면 min 출력
    }

    static void backTracking(int depth) {
        if (depth == N) {
            // int배열 -> 하나씩 꺼내서 하나의 문자열 -> 정수로 변환
            String s = "";
            for (int i : list) {
                s += i;
            }
            int n = Integer.parseInt(s);

            if (num < n) { // 입력값보다 큰 수중에 최솟값
                min = Math.min(min, n);
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) { // 사용하지 않은 숫자라면 사용
                visited[i] = true; // 사용한 숫자는 체크
                list[depth] = arr[i]; // 새로만들어지는 숫자는 list배열에 담아둠
                backTracking(depth + 1);
                visited[i] = false; // 사용 끝났으면 다시 false
            }
        }
    }
}