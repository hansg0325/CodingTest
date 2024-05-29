import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            long N = Long.parseLong(br.readLine());
            long left = 0;
            long right = (long) Math.sqrt(2 * N - 1);
            long result = 0;
            while (left <= right) {
                long mid = (left + right) / 2;
                long sum = (mid) * (mid + 1) / 2;
                if (sum <= N) {
                    result = Math.max(mid, result);
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}