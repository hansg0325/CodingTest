import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
		int[] answer = new int[targets.length];
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(String key : keymap) {
			for(int i=0;i<key.length();i++) {
				char c = key.charAt(i);
				if(!map.containsKey(c) || i<map.get(c)) {
					map.put(c, i+1);
				}
			}
		}
		
		for(int i=0;i<targets.length;i++) {
			int cnt = 0;
			for(int j=0;j<targets[i].length();j++) {
				char c = targets[i].charAt(j);
				if(!map.containsKey(c)) {
					cnt = 0;
					break;
				} else {
					cnt += map.get(c);
				}
			}
			answer[i] = cnt==0?-1:cnt;
		


    }
        return answer;
}
}