import java.util.*;

class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] maps;
    static int n, m;
    static int answer = -1;
    public int solution(int[][] maps) {
        this.maps = maps;
        n = maps.length;
        m = maps[0].length;
        solution2();
        return answer;
    }
    static void solution2(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            int count = tmp[2];
            if(x == n-1 && y == m-1){
                answer = count;
                break;
            }
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<n && ny >=0 && ny<m){
                    if(maps[nx][ny] == 1){
                        maps[nx][ny] = 2;
                        queue.add(new int[]{nx, ny, count+1});
                    }
                }
            }
        }

    }
}