import java.io.*;
import java.util.*;

public class Main {
    static int T, N, M;
    static int[] noteOne;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            noteOne = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                noteOne[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(noteOne);
            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            for (int k = 0; k < M; k++) {
                int num = Integer.parseInt(st.nextToken());
                if (binarySearch(num)) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean binarySearch(int num) {
        int left = 0;
        int right = N - 1;
        while (left <= right) { // left인덱스가 right인덱스를 넘어가기 전 까지 반복
            int mid = (left + right) / 2;
            if (num > noteOne[mid]) {
                left = mid + 1;
            } else if (num < noteOne[mid]) {
                right = mid - 1;
            } else { // num == noteOne[mid]
                return true;
            }
        }
        return false;
    }
}