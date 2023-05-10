import java.util.*;

class Solution {
    public String solution(String s) {
        char[] chars = s.toCharArray();
        String answer = "";
		Arrays.sort(chars);
		for(int i=chars.length-1;i>=0;i--) {
			answer+=chars[i];
		}
        return answer;
    }
}