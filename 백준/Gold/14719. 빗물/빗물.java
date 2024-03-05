import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] arr = new int[W];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for (int i = 1; i < W - 1; i++) { // 처음벽과 마지막벽에는 물이 고일수 없다
            int current = arr[i]; // 현재 벽의 높이
            int leftMax = current; // 왼쪽 벽
            int rightMax = current; // 오른쪽 벽
            for (int j = i - 1; j >= 0; j--) { // 왼쪽 벽 최대 높이 탐색
                if (arr[j] > current) {
                    leftMax = Math.max(leftMax, arr[j]);
                }
            }
            for (int j = i + 1; j < W; j++) { // 오른쪽 벽 최대 높이 탐색
                if (arr[j] > current) {
                    rightMax = Math.max(rightMax, arr[j]);
                }
            }
            if (Math.min(leftMax, rightMax) > current) { // 현재 벽보다 높은 벽이 양쪽에 있는 경우
                answer += (Math.min(leftMax, rightMax) - arr[i]);
            }
        }
        System.out.println(answer);
    }
}