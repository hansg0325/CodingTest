import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String[] str = Long.toString(n).split("");
		Arrays.sort(str, Collections.reverseOrder());
		String tmp = "";
		for(String s : str) {
			tmp+=s;
		}
        answer+=Long.parseLong(tmp);
        return answer;
    }
}