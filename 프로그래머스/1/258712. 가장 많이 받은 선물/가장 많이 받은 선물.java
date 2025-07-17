import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n = friends.length;
        Map<String, Integer> NameToIndex = new HashMap<>();
        for(int i=0;i<friends.length;i++){
            NameToIndex.put(friends[i], i);
        }
        
        int[][] giveCount = new int[n][n];
        int[] totalGive = new int[n];
        int[] totalReceive = new int[n];
        
        for(int i=0;i<gifts.length;i++){
            String[] split = gifts[i].split(" ");
            int giver = NameToIndex.get(split[0]);
            int receiver = NameToIndex.get(split[1]);
            
            giveCount[giver][receiver] = giveCount[giver][receiver] + 1;
            totalGive[giver] = totalGive[giver] + 1;
            totalReceive[receiver] = totalReceive[receiver] + 1;
        }
        
        int[] nextMonthReceived = new int[n];
        // 친구 쌍 비교
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (giveCount[i][j] > giveCount[j][i]) {
                    nextMonthReceived[i]++;
                } else if (giveCount[i][j] < giveCount[j][i]) {
                    nextMonthReceived[j]++;
                } else {
                    int scoreI = totalGive[i] - totalReceive[i];
                    int scoreJ = totalGive[j] - totalReceive[j];
                    if (scoreI > scoreJ) {
                        nextMonthReceived[i]++;
                    } else if (scoreI < scoreJ) {
                        nextMonthReceived[j]++;
                    }
                    // 같으면 아무 일도 없음
                }
            }
        }
        
        int max = 0;
        for (int r : nextMonthReceived) {
            max = Math.max(max, r);
        }

        return max;
    }
}