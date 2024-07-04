import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] wires = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            wires[i][0] = Integer.parseInt(st.nextToken());
            wires[i][1] = Integer.parseInt(st.nextToken());
        }
        
        // A 전봇대 기준으로 정렬
        Arrays.sort(wires, (a, b) -> Integer.compare(a[0], b[0]));
        
        // B 전봇대 위치들의 LIS를 구한다.
        int[] lis = new int[N];
        int lisLength = 0;
        
        for (int i = 0; i < N; i++) {
            int b = wires[i][1];
            int pos = Arrays.binarySearch(lis, 0, lisLength, b);
            if (pos < 0) {
                pos = -(pos + 1);
            }
            lis[pos] = b;
            if (pos == lisLength) {
                lisLength++;
            }
        }
        
        // 전체 전깃줄 개수에서 LIS 길이를 뺀다.
        int minRemovals = N - lisLength;
        System.out.println(minRemovals);
    }
}
