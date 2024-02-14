import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int Z = (int) ((long) Y * 100 / X);
        int answer = -1;
        int left = 0;
        int right = (int) 1e9; // 범위는 문제에서 주어짐
        while (left <= right) { // left가 right를 넘어서면 종료
            int mid = (left + right) / 2;
            int newRate = (int) ((long) (Y + mid) * 100 / (X + mid));
            if (newRate != Z) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
}