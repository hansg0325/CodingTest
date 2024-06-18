import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static boolean found = false;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }
        
        visited = new boolean[N];
        
        for (int i = 0; i < N; i++) {
            if (!found) {
                dfs(i, 0);
            }
        }
        
        if (found) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    
    static void dfs(int node, int depth) {
        if (depth == 4) {
            found = true;
            return;
        }
        
        visited[node] = true;
        
        for (int next : adj[node]) {
            if (!visited[next]) {
                dfs(next, depth + 1);
                if (found) return;
            }
        }
        
        visited[node] = false;
    }
}
