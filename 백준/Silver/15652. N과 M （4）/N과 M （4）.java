import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] checked;
    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        checked = new boolean[N + 1];
        arr = new int[N + 1];
        backTracking(0, 1);
        bw.flush();
    }

    static void backTracking(int depth, int start) throws Exception {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = start; i <= N; i++) {
                arr[depth] = i;
                backTracking(depth + 1, i);
        }
    }
}