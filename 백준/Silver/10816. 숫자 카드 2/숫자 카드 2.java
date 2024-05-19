import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        answer = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            int tmp = upperBound(key) - lowerBound(key);
            bw.write(tmp + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * key 값이 배열 내에 없을 경우 lowerBound, upperBound 둘다 key 바로 앞의 숫자를 찾게된다. 결국 n - n = 0이 된다.
     */

    static int lowerBound(int key) {
        int left = 0;
        int right = N;
        while (left < right) { // left 와 right가 같아질 때 까지 반복
            int mid = (left + right) / 2; // 중간 위치

            /**
             * key 값이 중간 위치의 값보다 작거나 같을 경우
             * 중복 원소일 경우 가장 왼쪽값을 선택
             */
            if (key <= arr[mid]) {
                right = mid;
            } else { // key가 중간 값보다 '클' 경우. key > arr[mid]
                left = mid + 1;
            }
        }
        return left;
    }

    static int upperBound(int key) {
        int left = 0;
        int right = N;
        while (left < right) {// left 와 right가 같아질 때 까지 반복
            int mid = (left + right) / 2; // 중간 위치
            if (key < arr[mid]) { // key가 중간 값보다 작을 경우
                right = mid;
            } else { // key가 중간 보다 '크거나' '같을' 경우 key >= arr[mid]
                left = mid + 1;
            }
            // left가 right를 넘어서는 순간 종료된다 == left가 key의 바로 다음 인덱스가 되는순간 종료된다.
        }
        return left;
    }
}