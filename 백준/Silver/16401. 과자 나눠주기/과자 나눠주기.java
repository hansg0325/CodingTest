import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static long left = 1, right, answer = 0;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new long[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        parametricSearch();
        System.out.println(answer);
    }
    static void parametricSearch() {
        while (left <= right) {
            long mid = (left + right) / 2;
            if (M > getMid(mid)) { // M명 보다 적게나눠주면 길이를 과자의 길이를 줄여야 한다
                right = mid - 1;
            } else { // M명보다 많이 나눠줄 수 있거나 정확히 나눠줄 수 있으면 과자 길이를 늘려야 한다.
                left = mid + 1;
                answer = mid;
            }
        }
    }

    static int getMid(long mid) {
        int count = 0;
        for (long snack : arr) {
            count += snack / mid;
        }

        return count;
    }
}