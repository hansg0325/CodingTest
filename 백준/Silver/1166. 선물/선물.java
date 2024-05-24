import java.io.*;
import java.util.*;

public class Main {
    static int N, L, W, H;
    static double left = 0, right, answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        right = Math.min(Math.min(L, W), H);

        binarySearch(N);
        System.out.println(left);
    }
    static void binarySearch(int key) {
        while (left < right) {
            double mid = (left + right) / 2;
            long boxes = (long)(L / mid) * (long)(W / mid) * (long)(H / mid);

            if (key > boxes) {
                if (right == mid) {
                    return;
                }
                right = mid;
            } else if (key <= boxes) {
                if (left == mid) {
                    return;
                }
                left = mid;
            }
        }
    }
}