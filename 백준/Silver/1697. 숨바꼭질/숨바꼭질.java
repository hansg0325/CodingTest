import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println(N - K);
            return;
        }

        int[] visited = new int[100001];
        Arrays.fill(visited, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == K) {
                System.out.println(visited[current]);
                return;
            }

            if (current - 1 >= 0 && visited[current - 1] == -1) {
                visited[current - 1] = visited[current] + 1;
                queue.add(current - 1);
            }

            if (current + 1 <= 100000 && visited[current + 1] == -1) {
                visited[current + 1] = visited[current] + 1;
                queue.add(current + 1);
            }

            if (current * 2 <= 100000 && visited[current * 2] == -1) {
                visited[current * 2] = visited[current] + 1;
                queue.add(current * 2);
            }
        }
    }
}
