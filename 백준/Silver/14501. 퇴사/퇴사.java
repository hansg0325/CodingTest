import java.io.*;
import java.util.*;

public class Main {
    static int N, maxPay = Integer.MIN_VALUE;
    static int[][] arr;
    static boolean[] checked;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][2];
        checked = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(maxPay);

    }

    static void dfs(int index, int pay) {
        if (index >= N) {
            maxPay = Math.max(maxPay, pay);
            return;
        }

        if (index + arr[index][0] <= N) { // 날짜를 초과하지 않는다면
            dfs(index + arr[index][0], pay + arr[index][1]); // 상담을 진행 후의 날짜, 금액을 추가해 넘겨준다
        } else { // 날짜를 초과한다면
            dfs(index + arr[index][0], pay); // 금액을 추가하지않고 넘겨준다, 다음 if문에서 걸리기 때문
        }
        dfs(index + 1, pay); // 완전 탐색하기위한 코드, 0일부터시작, 1일부터 시작, ...
    }
}