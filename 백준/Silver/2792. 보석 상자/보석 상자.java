import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] jewels;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        jewels = new int[M];

        for (int i = 0; i < M; i++) {
            jewels[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(minimizeJealousy());
    }

    private static int minimizeJealousy() {
        int low = 1, high = 0;

        for (int jewel : jewels) {
            if (jewel > high) { // 가장 수가 많은 보석이 high
                high = jewel;
            }
        }

        int result = high;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canDistribute(mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    private static boolean canDistribute(int maxJewels) {
        long requiredStudents = 0;

        for (int jewel : jewels) {
            requiredStudents += (jewel + maxJewels - 1) / maxJewels;
            if (requiredStudents > N) {
                return false;
            }
        }

        return true;
    }
}
