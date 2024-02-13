import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 이분탐색은 반드시 정렬이 되어야만 한다.
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            if (binarySearch(Integer.parseInt(st.nextToken())) >= 0) {
                bw.write("1");
            } else {
                bw.write("0");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int binarySearch(int key) {
        int low = 0; // 탐색 범위의 왼쪽 끝 인덱스
        int high = arr.length - 1; // 탐색 범위의 오른쪽 끝 인덱스

        // low 가 high 보다 커지면 종료
        while (low <= high) {
            int mid = (low + high) / 2; // 찾는 범위의 중간 값

            if (key < arr[mid]) { // key 가 중간값보다 작을 경우
                high = mid - 1;
            } else if (key > arr[mid]) { // key 가 중간값보다 클 경우
                low = mid + 1;
            } else { // key 가 중간값과 같을 경우
                return mid;
            }
        }
        // 끝까지 탐색했지만 값이 존재하지 않을 경우
        return -1;
    }
}