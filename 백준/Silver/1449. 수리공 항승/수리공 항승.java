import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] leaks = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            leaks[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(leaks);

        int count = 0;
        int i = 0;

        while (i < N) {
            count++;
            int tapeStart = leaks[i];
            // 테이프가 덮을 수 있는 범위 계산
            while (i < N && leaks[i] <= tapeStart + L - 1) {
                i++;
            }
        }

        System.out.println(count);
    }
}
