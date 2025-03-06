import java.util.*;

class Solution {
    static String[] park;
    static String[] routes;
    static int[] dx = {-1, 1, 0, 0}; // 북 남 서 동
    static int[] dy = {0, 0, -1, 1};
    static int[] pos;
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        Solution.park = park;
        Solution.routes = routes;
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[i].length();j++){
                if(park[i].charAt(j) == 'S'){
                    pos = new int[]{i, j};
                }
            }
        }
        
        for(String s : routes){
            char dir = s.charAt(0);
            int count = s.charAt(2) - '0';
            canMove(dir, count);
        }
        
        return pos;
    }
    static void canMove(char dir, int count){
        int d = 0;
        if(dir == 'N'){
            d = 0;
        } else if (dir == 'S'){
            d = 1;
        }  else if (dir == 'W'){
            d = 2;
        } else if (dir == 'E'){
            d = 3;
        }
        int x = pos[0];
        int y = pos[1];
        boolean flag = false;
        for(int i=0;i<count;i++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < 0 || nx >= park.length || ny < 0 || ny >= park[0].length()){
                flag = true;
                break;
            }
            if(park[nx].charAt(ny) == 'X'){
                flag = true;
                break;
            }
            x = nx;
            y = ny;
        }
        if(!flag){
            pos = new int[]{x, y};
        }
        
    }
}