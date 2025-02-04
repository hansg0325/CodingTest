import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<List<int[]>> graph = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= D; i++) {
            graph.add(new ArrayList<>());
            if (i < D) {
                graph.get(i).add(new int[]{i + 1, 1});
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if (v <= D) { // D보다 넘어가면 역주행 불가능하기때문에 v가 D보다 작거나 같은경우에만 추가
                graph.get(u).add(new int[]{v, w});
            }

        }
        int[] dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int currentNode = tmp[0];
            int currentCost = tmp[1];

            if (currentCost <= dist[currentNode]) {
                for (int[] edge : graph.get(currentNode)) {
                    int nextNode = edge[0];
                    int nextCost = currentCost + edge[1]; // 현재비용 + 연결된 노드로 가는비용
                    if (nextCost < dist[nextNode]) {
                        dist[nextNode] = nextCost;
                        pq.add(new int[]{nextNode, nextCost});
                    }
                }
            }
        }
        
        System.out.println(dist[D]);
    }
}
