import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
		HashMap<Integer, Object> map = new HashMap<>();
		for(int i=0;i<numbers.length-1;i++) {
			for(int j=i+1;j<numbers.length;j++) {
				map.put(numbers[i] + numbers[j], j);
			}
		}
		int[] answer = new int[map.size()];
		int i=0;
		for(Integer m : map.keySet()) {
			answer[i] = m;
			i++;
		}
        Arrays.sort(answer);
        
        return answer;
    }
}