import java.util.*;

class Solution {
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[][] visited;
    static int answer = 0;
    static PriorityQueue<Integer> pq;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n][n];
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
            for(int j=0;j<n;j++){
                if(i!=j && computers[i][j] == 1){
                    list.get(i).add(computers[i][j]);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && computers[i][j] == 1){
                    pq = new PriorityQueue<>();
                    pq.add(i);
                    answer++;
                    solve(n, computers);
                }
            }
        }
        return answer;
    }

    
        static void solve(int n, int[][] computers){
        while(!pq.isEmpty()){
            int tmp = pq.poll();
            for (int i = 0; i < n; i++) {
                if (!visited[tmp][i] && computers[tmp][i] == 1) {
                    visited[tmp][i] = true;
                    pq.add(i);
                }
            }
        }
    }
}