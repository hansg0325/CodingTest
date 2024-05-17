import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] sangArr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        sangArr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            sangArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sangArr); // 오름차순 정렬

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (binarySearch(num)) {
                bw.write("1 ");
            } else {
                bw.write("0 ");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean binarySearch(int num) {
        int leftIndex = 0;
        int rightIndex = N - 1;
        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            int mid = sangArr[midIndex];

            if (num < mid) { // 찾으려는 숫자가 더 작을경우 rightIndex를 mid-1 로 설정
                rightIndex = midIndex - 1;
            } else if (num > mid) { // 찾으려는 숫자가 더 클경우 leftIndex mid+1 로 설정
                leftIndex = midIndex + 1;
            } else { // 숫자가 있을 경우
                return true;
            }
        }
        return false; // 숫자가 없을 경우
    }
}