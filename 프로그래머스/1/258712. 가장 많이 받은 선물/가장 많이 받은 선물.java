import java.util.*;

class Solution {
    private String[] friends;
    private String[] gifts;
    private int answer = 0;
    private int[][] graph;
    private int[] giftScore;
    private Map<String, Integer> friendsMap = new HashMap<>();
    
    public int solution(String[] friends, String[] gifts) {
        this.friends = friends;
        this.gifts = gifts;
        
        for(int i=0;i<friends.length;i++){
            friendsMap.put(friends[i], i);
        }
        giftScore = new int[friends.length];
        graph = new int[friends.length][friends.length];
        makeGraph(gifts.length);
        answer = calculate(friends.length);
        
        return answer;
    }
    public void makeGraph(int n){
        for(String gift : gifts){
            String[] fromTo = gift.split(" ");
            int from = friendsMap.get(fromTo[0]);
            int to = friendsMap.get(fromTo[1]);
            graph[from][to] ++;
            giftScore[from] ++;
            giftScore[to] --;
        }
    }
    
    public int calculate(int n){
        int result = 0;
        int tmp = 0;
        for(int i=0;i<n;i++){
            tmp = 0;
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(graph[i][j]>graph[j][i] || (graph[i][j] == graph[j][i] && giftScore[i] > giftScore[j])){
                    tmp++;
                }
            }

            if(result < tmp){
            result = tmp;
        }    
        }

        return result;
    }
}