import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.security.Key;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new long[N];
        long low = 1;
        long high = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
            high = Math.max(high, arr[i]);

        }
        long answer = high;

        while (low <= high) {
            long mid = (low + high) / 2;
            if (canDistribute(mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(answer);
    }

    static boolean canDistribute(long mid) {
        int portion = 0;
        for (long i : arr) {
            portion += i / mid;
            if (portion >= K) {
                return true;
            }
        }
        return false;
    }
}
