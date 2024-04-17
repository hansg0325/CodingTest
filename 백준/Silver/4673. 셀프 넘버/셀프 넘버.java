import java.io.*;
import java.util.*;

public class Main {
    static boolean[] check = new boolean[10036];// selfNumber(9999) = 9999+9+9+9+9=10035가 최대값

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 1;
        while (n <= 10000) {
            if (!check[n]) {
                bw.write(n + "\n");
                selfNumber(n);
            } else {
                selfNumber(n);
            }
            n++;
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void selfNumber(int n) {
        int sum = 0;
        sum += n;
        String str = String.valueOf(n);
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - '0';
        }
        check[sum] = true;
    }
}