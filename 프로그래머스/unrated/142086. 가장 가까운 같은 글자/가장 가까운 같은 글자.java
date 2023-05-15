import java.util.*;

class Solution {
    public int[] solution(String s) {
		int[] answer = new int[s.length()];		
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(map.containsKey(c)) {
				answer[i]=i - map.get(c);
				map.put(c,i);
			} else {
				map.put(c, i);
				answer[i]=-1;
			}
		}
		for(Integer a : answer) {
			System.out.println(a);
		}
        return answer;
    }
}