import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] classes = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            classes[i][0] = Integer.parseInt(st.nextToken());
            classes[i][1] = Integer.parseInt(st.nextToken());
        }

        // 수업을 시작 시간 기준으로 정렬. 만약 시작 시간이 같다면 종료 시간 기준으로 정렬
        Arrays.sort(classes, Comparator.comparingInt((int[] a) -> a[0])
                .thenComparingInt(a -> a[1]));


        // 최소 힙을 사용하여 종료 시간을 관리
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int[] cls : classes) {
            // 힙의 최상위 종료 시간이 현재 수업 시작 시간보다 작거나 같으면 제거
            if (!minHeap.isEmpty() && minHeap.peek() <= cls[0]) {
                minHeap.poll();
            }
            // 현재 수업의 종료 시간을 힙에 추가
            minHeap.offer(cls[1]);
        }

        // 필요한 최소 강의실의 수는 힙에 남아있는 요소의 개수
        System.out.println(minHeap.size());
    }
}
