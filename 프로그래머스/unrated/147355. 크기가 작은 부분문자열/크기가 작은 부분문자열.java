import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
		for(int i=0;i<t.length();i++) {
			if(i+p.length()>t.length()) {
				break;
			}
			long tmp = Long.parseLong(t.substring(i, i+p.length()));
			if(tmp<=Long.parseLong(p)) {
				answer++;
			}
		}
        return answer;
    }
}