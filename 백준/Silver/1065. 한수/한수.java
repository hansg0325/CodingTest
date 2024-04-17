import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if (N < 100) {
            System.out.println(N);
        } else {
            int answer = 99;
            for (int i = 100; i <= N; i++) {
                int hundreds = i / 100; // 100의 자리
                int tens = (i / 10) % 10; // 10의 자리
                int units = (i % 10); // 1의 자리
                if ((hundreds - tens) == (tens - units)) {
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }
}