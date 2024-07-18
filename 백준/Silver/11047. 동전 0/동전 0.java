import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int i = 0;
        int count = 0;
        while (K > 0) {
            if (K - arr[i] >= 0) {
                K -= arr[i];
                count++;
            } else {
                i++;
            }
        }
        System.out.println(count);
    }
}
