import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        // 각 작업이 완료되기까지 남은 일수 계산 후 큐에 추가
        for (int i = 0; i < progresses.length; i++) {
            int remaining = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
            queue.add(remaining);
        }
        
        while (!queue.isEmpty()) {
            int current = queue.poll(); // 현재 배포 기준일
            int count = 1; // 현재 배포되는 기능 수
            
            // 현재 배포 기준일보다 작은 작업일수를 모두 배포
            while (!queue.isEmpty() && queue.peek() <= current) {
                queue.poll();
                count++;
            }
            
            result.add(count); // 배포된 기능 수 저장
        }
        
        // 결과를 배열로 변환하여 반환
        return result.stream().mapToInt(i -> i).toArray();
    }
}
