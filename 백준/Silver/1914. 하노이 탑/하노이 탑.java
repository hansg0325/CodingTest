import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N = 0;

    public static void main(String[] args) throws Exception {

        // 원판의 개수 입력
        N = Integer.parseInt(br.readLine());

        //관계식
        System.out.println(BigInteger.TWO.pow(N).subtract(BigInteger.ONE));

        // N이 20 이하일 경우 과정 출력
        if (N <= 20) {
            hanoi(N, 1, 2, 3);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // [로직] n 옮길 원판, from 시작 기둥, tmp 거쳐갈 기둥, to 도착 기둥
    public static void hanoi(int n, int from, int tmp, int to) throws IOException{

        // n == 1 일경우 바로 이동
        if (n == 1) {
            bw.write(from + " " + to + "\n"); // 이동
            return;
        }

        hanoi(n - 1, from, to, tmp);
        bw.write(from + " " + to + "\n"); // 이동
        
        hanoi(n-1, tmp, from, to);
    }
}