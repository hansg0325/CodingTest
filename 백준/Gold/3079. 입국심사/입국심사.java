import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] times = new int[N];
        long maxTime = 0;

        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(br.readLine());
            maxTime = Math.max(maxTime, times[i]);
        }

        long low = 1;
        long high = maxTime * M;
        long result = high;

        while (low <= high) {
            long mid = (low + high) / 2;
            if (canProcessAll(mid, times, M)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static boolean canProcessAll(long time, int[] times, int M) {
        long total = 0;
        for (int t : times) {
            total += time / t;
            if (total >= M) {
                return true;
            }
        }
        return total >= M;
    }
}
