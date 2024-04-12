import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        int N = 0;
        int answer = 0;
        for (int i = 1; i <= S.length() / 2; i++) {
            N = i * 2;
            for (int j = 0; j < S.length() - N + 1; j++) {
                String tmp = S.substring(j, j + N);
                if (StringSum(tmp.substring(0, N / 2)) == StringSum(tmp.substring(N / 2))) {
                    answer = N;
                    break;
                }
            }
        }
        System.out.println(answer);

        br.close();
    }

    static int StringSum(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }
        return sum;
    }
}