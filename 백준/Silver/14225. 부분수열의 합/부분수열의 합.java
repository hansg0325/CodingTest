import java.io.*;
import java.util.*;

public class Main {
    static int[] arr, answer;
    static int N, max = 0;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max += arr[i];
        }
        answer = new int[max + 2]; // 최대 가능한 합 + 2 로 설정해야 메모리 낭비를 막을 수 있다

        dfs(0, 0);

        for (int i = 1; i < answer.length; i++) {
            if (answer[i] == 0) { // 0일 경우 해당 인덱스는 나온적 없는 숫자이므로 출력
                System.out.println(i);
                break;
            }
        }

    }

    static void dfs(int depth, int sum) {
        if (depth == N) { // depth 가 N일 경우 종료
            answer[sum] = 1; // 현재까지 저장된 sum 값은 이미 나온 숫자이므로 1로 변경
            return;
        }
        dfs(depth + 1, sum + arr[depth]); // 현재까지 저장된 sum + 현재 인덱스의 arr 값
        dfs(depth + 1, sum); // 현재 인덱스의 arr 값을 추가하지않고 다음 인덱스 탐색
    }
}