import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int start, end, cost; // 시작 노드, 도착 노드, 가중치

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    static int v, e;
    static List<Edge> edges;
    static long[] dist;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        v = Integer.parseInt(st.nextToken()); // 노드의 수
        e = Integer.parseInt(st.nextToken()); // 간선의 수

        // 리스트 선언
        edges = new ArrayList<>();

        // 가중치를 담을 배열
        dist = new long[v + 1];
        // dist 배열의 전체내용을 Long.MAX_VALUE 로 초기화
        Arrays.fill(dist, Long.MAX_VALUE);

        // edges 초기화
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(start, end, cost));
        }

        // 출력
        if (BellmanFord()) {
            // i = 2인 이유, 문제에서 0번노드부터가아닌 1번노드부터 존재
            // 1번노드 제외한 나머지 노드를 출력이기 때문에
            for (int i = 2; i <= v; i++) {
                // 도달하지 못하는 장소일 경우 -1
                if (dist[i] == Long.MAX_VALUE) {
                    sb.append(-1).append("\n");
                    continue;
                }
                // 도달가능할 경우 최소거리 출력
                sb.append(dist[i]).append("\n");
            }
        } else { // 음의 사이클이 존재할 경우 -1 출력
            sb.append(-1);
        }


        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean BellmanFord() {
        dist[1] = 0;

        // n-1번의 반복작업과 마지막(n번째 탐색) 확인작업을 한번에 실행
        for (int i = 1; i <= v; i++) {
            for (Edge edge : edges) {
                // 한번도 방문하지 않았다면 패스
                if (dist[edge.start] == Long.MAX_VALUE) {
                    continue;
                }
                // 버스 도착점까지의 최소거리가 (시작점 + 비용) 보다 크면 갱신
                if (dist[edge.end] > dist[edge.start] + edge.cost) {
                    dist[edge.end] = dist[edge.start] + edge.cost;

                    // n번째 작업에서 값이 변경되면 Negative Cycle(음의 사이클)이 존재한다는 뜻
                    if (i == v) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}