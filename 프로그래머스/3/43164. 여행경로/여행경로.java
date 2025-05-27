import java.util.*;

class Solution {
    static Map<String, LinkedList<String>> map = new HashMap<>();
    static String[] answer;
    static boolean finished = false; // 경로 완성 시 종료 플래그
    static int ticketCount;

    public String[] solution(String[][] tickets) {
        map.clear();
        finished = false;
        ticketCount = tickets.length;
        answer = new String[ticketCount + 1];

        // 그래프 초기화 및 정렬
        for (String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], k -> new LinkedList<>()).add(ticket[1]);
        }
        for (LinkedList<String> destList : map.values()) {
            Collections.sort(destList);
        }

        answer[0] = "ICN";
        dfs("ICN", 1);

        return answer;
    }

    static void dfs(String current, int idx) {
        if (finished) return; // 이미 정답 경로 찾음

        if (idx == ticketCount + 1) { // 모든 티켓 사용 완료
            finished = true;
            return;
        }

        if (!map.containsKey(current)) return; // 더 이상 갈 곳 없음

        LinkedList<String> destinations = map.get(current);
        for (int i = 0; i < destinations.size(); i++) {
            String next = destinations.remove(i); // 티켓 사용
            answer[idx] = next;

            dfs(next, idx + 1);

            destinations.add(i, next); // 백트래킹 - 티켓 복구

            if (finished) return; // 경로 찾았으면 바로 종료
        }
    }
}
