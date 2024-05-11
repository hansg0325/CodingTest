import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] board) {
        int answer = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean[][] visited = new boolean[board.length][board[0].length()];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length();j++){
                if(board[i].charAt(j) == 'R')
                { // 시작위치 저장
                    queue.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                }   
            }
        }
        
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            int count = tmp[2];
            if(board[x].charAt(y) == 'G'){
                answer = count;
                return answer;
            }
            for(int i=0;i<4;i++){
                int nx = x;
                int ny = y;
                while(nx>=0&&nx<board.length&&ny>=0&&ny<board[0].length()&&board[nx].charAt(ny) != 'D'){ // 범위내에 있거나, 장애물 'D' 를 만날때 까지 계속 이동
                    nx += dx[i];
                    ny += dy[i];
                }
                // 범위 벗어나거나 장애물 만나기 직전으로 수정
                nx -= dx[i];
                ny -= dy[i];
                
                if(visited[nx][ny] || (x == nx && y == ny)){ // 방문한 적이 없고 같은 위치가 아닐경우
                    continue;
                    
                }
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, count+1});
                }
            }
        answer = -1;
        return answer;
    }
}