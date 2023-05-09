import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
		String tmp = Integer.toString(n);
		int[] arr = new int[tmp.length()];
		for(int i=0;i<tmp.length();i++) {
			arr[i] = tmp.charAt(i) - '0';
			answer+=arr[i];
		}
        return answer;
    }
}