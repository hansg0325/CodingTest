import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> answerMap = new HashMap<>();
        for(String id : id_list){
            map.put(id, new LinkedHashSet<>()); // 중복방지를 위한 LinkedHashSet
        }
        for(String id : id_list){
            answerMap.put(id, 0);
        }
        for(String r : report){
            String[] parts = r.split(" ");
            String id = parts[0];
            String reportedId = parts[1];
            if(!map.get(id).contains(reportedId)){
                map.get(id).add(reportedId);
                answerMap.put(reportedId, answerMap.get(reportedId)+1);
            }
        }
        
        int i = 0;
        for(String id : id_list){
            for(String reportedId : map.get(id)){
                if(answerMap.get(reportedId) >= k){
                    answer[i]++;
                }
            }
            i++;
        }
        
        return answer;
    }
}
/*
for문을 돌며 신고자와 신고당한자를 꺼낸다.
2중 리스트를만들어 신고할경우 리스트에 이름을 올리고 contains함수로나 해당 신고자 노드를 for문을 돌려 중복신고인지 체크


*/