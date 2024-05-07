import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static int[] arr, list;
    static boolean[] checked;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }
            arr = new int[k];
            list = new int[6];
            checked = new boolean[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            backTracking(0, 0);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void backTracking(int depth, int start) throws Exception{
        if (depth == 6) {
            for (int i : list) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = start; i < k; i++) {
            if (!checked[i]) {
                checked[i] = true;
                list[depth] = arr[i];
                backTracking(depth + 1, i + 1);
                checked[i] = false;
            }
        }
    }
}