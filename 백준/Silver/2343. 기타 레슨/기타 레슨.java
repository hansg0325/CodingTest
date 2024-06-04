import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M, left, right = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right += arr[i];
            left = Math.max(left, arr[i]);
        }
        parametricSearch();
        System.out.println(left);
    }

    static void parametricSearch() {
        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (sum + arr[i] > mid) {
                    sum = 0;
                    count++;
                }
                sum+=arr[i];
            }

            if (sum > 0) {
                count++;
            }

            if (count <= M) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }
}