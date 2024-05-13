import java.util.*;

class Solution {
    static int answer = -1;
    public int solution(int[][] maps) {
        bfs(maps);
        
        return answer;
    }
    static void bfs(int[][] maps){
        int n = maps.length;
        int m = maps[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            int count = tmp[2];
            if(x == n-1 && y == m-1){ // 우측하단에 도착했을 경우
                answer = count;
                return;
            }
            for(int i=0;i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0&&nx<n&&ny>=0&&ny<m){
                    if(!visited[nx][ny] && maps[nx][ny] == 1){
                        queue.offer(new int[]{nx, ny, count+1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return;
    }
}