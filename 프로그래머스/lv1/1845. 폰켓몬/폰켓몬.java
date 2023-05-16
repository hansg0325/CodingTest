import java.util.*;

class Solution {
    public int solution(int[] nums) {
		int answer = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			map.put(nums[i], i);
		}
		if(map.size()<=nums.length/2) {
			answer=map.size();;
		} else {
			answer=nums.length/2;
		}
        return answer;
    }
}