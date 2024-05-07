import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] checked;
    static int[] arr, tmp;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        checked = new boolean[N];
        arr = new int[N];
        tmp = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        backTracking(0);
        bw.flush();
    }

    static void backTracking(int depth) throws Exception {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                bw.write(tmp[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!checked[i]) {
                checked[i] = true;
                tmp[depth] = arr[i];
                backTracking(depth + 1);
                checked[i] = false;
            }

        }
    }
}