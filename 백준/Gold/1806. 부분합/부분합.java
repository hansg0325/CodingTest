import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;

        while (left <= N && right <= N) {
            if (sum >= S) {
                answer = Math.min(answer, right - left);
                sum -= arr[left++];
            } else if (sum < S) {
                sum += arr[right++];
            }
        }
        System.out.println(answer==Integer.MAX_VALUE ? 0 : answer);
    }
}