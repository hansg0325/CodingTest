import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
		int key = arr[0];
		ArrayList<Integer> li = new ArrayList<>();
		li.add(key);
		
		for(int i=1;i<arr.length;i++) {
			if(key!=arr[i]) {
				key=arr[i];
				li.add(key);
			}
		}
		int[] answer = new int[li.size()];
		for(int i=0;i<li.size();i++) {
			answer[i]=li.get(i);
		}
        return answer;
    }
}