import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String input = br.readLine();
        char[] charArray = input.toCharArray();
        boolean[] boolArray = new boolean[N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            if (charArray[i] == 'P') {
                for (int j = 0; j < 2 * K + 1; j++) {
                    int idx = (K * -1) + j;
                    if (i + idx >= 0 && i + idx < N && charArray[i + idx] == 'H') {
                        if (!boolArray[i + idx]) {
                            boolArray[i + idx] = true;
                            answer++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(answer);

    }
}
