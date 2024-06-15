import java.io.*;
import java.util.*;

public class Main {
    static int max = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[max + 1];

        // BFS를 위한 큐 초기화
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});

        int answer = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int current = tmp[0]; // 현재 위치
            int time = tmp[1];
            visited[current] = true;

            // 동생의 위치에 도달하면 종료
            if (current == K) {
                answer = Math.min(answer, time);
            }

            // 가능한 이동
            if (current * 2 <= max && !visited[current * 2]) {
                queue.offer(new int[]{current * 2, time});
            }
            if (current + 1 <= max && !visited[current + 1]) {
                queue.offer(new int[]{current + 1, time + 1});
            }
            if (current - 1 >= 0 && !visited[current - 1]) {
                queue.offer(new int[]{current - 1, time + 1});
            }
        }
        System.out.println(answer);
    }
}