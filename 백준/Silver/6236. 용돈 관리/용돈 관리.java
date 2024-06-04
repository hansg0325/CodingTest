import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M, left, right = 0, result = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right += arr[i];
            left = Math.max(left, arr[i]);
        }

        parametricSearch();
        System.out.println(result);
    }
    static void parametricSearch() {
        while (left <= right) {
            int mid = (left + right) / 2;

            int sum = mid;
            int count = 0;
            if (M >= getMid(mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }

    static int getMid(int tmp) {
        int count = 1;
        int money = tmp;

        for (int num : arr) {
            money -= num;
            if (money < 0) {
                count++;
                money = tmp - num;
            }
        }
        return count;
    }
}