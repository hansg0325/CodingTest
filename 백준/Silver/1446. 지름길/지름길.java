import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 지름길의 개수
        int D = scanner.nextInt(); // 고속도로의 길이

        List<int[]> shortcuts = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            if (v <= D) {
                shortcuts.add(new int[]{u, v, w});
            }
        }

        int[] dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{0, 0}); // {현재 위치, 현재 비용}

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentPos = current[0];
            int currentCost = current[1];

            if (currentCost > dist[currentPos]) continue;

            if (currentPos + 1 <= D && currentCost + 1 < dist[currentPos + 1]) {
                dist[currentPos + 1] = currentCost + 1;
                pq.add(new int[]{currentPos + 1, currentCost + 1});
            }

            for (int[] shortcut : shortcuts) {
                if (shortcut[0] == currentPos) {
                    int nextPos = shortcut[1];
                    int nextCost = currentCost + shortcut[2];
                    if (nextCost < dist[nextPos]) {
                        dist[nextPos] = nextCost;
                        pq.add(new int[]{nextPos, nextCost});
                    }
                }
            }
        }

        System.out.println(dist[D]);
    }
}
