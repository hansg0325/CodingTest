import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'P') { // 사람일 경우
                int startIndex = Math.max(i - K, 0); // 0보다 작으면 안됨
                int endIndex = Math.min(i + K, N - 1); // 배열의 끝을 넘어가면 안됨
                for (int j = startIndex; j <= endIndex; j++) {
                    if (arr[j] == 'H') {
                        count++;
                        arr[j] = 'X'; // 햄버거가 있다면 햄버거자리를 임의의 문자로 대체
                        break;
                    }
                }
            }

        }
        System.out.println(count);
    }
}