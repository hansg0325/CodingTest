import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int node, cost;
        
        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            
            List<List<Edge>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                graph.get(a).add(new Edge(b, d));
                graph.get(b).add(new Edge(a, d));
            }
            
            int[] candidates = new int[t];
            for (int i = 0; i < t; i++) {
                candidates[i] = Integer.parseInt(br.readLine());
            }
            
            int[] distFromS = dijkstra(s, n, graph);
            int[] distFromG = dijkstra(g, n, graph);
            int[] distFromH = dijkstra(h, n, graph);
            
            List<Integer> result = new ArrayList<>();
            for (int candidate : candidates) {
                int distanceViaGH = distFromS[g] + distFromG[h] + distFromH[candidate];
                int distanceViaHG = distFromS[h] + distFromH[g] + distFromG[candidate];
                if (distFromS[candidate] == Math.min(distanceViaGH, distanceViaHG)) {
                    result.add(candidate);
                }
            }
            
            Collections.sort(result);
            for (int res : result) {
                System.out.print(res + " ");
            }
            System.out.println();
        }
    }
    
    private static int[] dijkstra(int start, int n, List<List<Edge>> graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentNode = current.node;
            int currentCost = current.cost;
            
            if (currentCost > dist[currentNode]) continue;
            
            for (Edge edge : graph.get(currentNode)) {
                int nextNode = edge.node;
                int nextCost = currentCost + edge.cost;
                
                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.add(new Edge(nextNode, nextCost));
                }
            }
        }
        
        return dist;
    }
}
