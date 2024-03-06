import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N - 1;
        int min = Integer.MAX_VALUE; // 현재 알고있는 최솟값
        int[] answer = new int[2];
        while (left < right) {
            int sum = Math.abs(arr[left] + arr[right]); // 새로운 최솟값
            if (sum < min) { // 새로운 최솟값이 원래 알고있는 최솟값보다 더 작다면 갱신
                min = sum;
                answer[0] = arr[left];
                answer[1] = arr[right];
            }
            if (sum == 0) {
                break;
            }
            if (arr[left] + arr[right] > 0) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}