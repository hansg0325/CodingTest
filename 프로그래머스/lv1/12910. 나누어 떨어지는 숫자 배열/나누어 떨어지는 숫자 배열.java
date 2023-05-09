import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
       	ArrayList<Integer> li = new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			if(arr[i]%divisor==0) {
				li.add(arr[i]);
			}
		}
        if(li.size()==0) {
			li.add(-1);
		}
		li.sort(Comparator.naturalOrder());
		int[] answer = li.stream()
				.mapToInt(Integer::intValue)
				.toArray();
        return answer;
    }
}