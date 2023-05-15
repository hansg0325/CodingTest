import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
		String[] tmp = new String[strings.length];
		String[] answer = new String[strings.length];
		Map<String, Integer> map = new HashMap<>();
		for(int i=0;i<strings.length;i++) {
			char c = strings[i].charAt(n);
			tmp[i]="";
			tmp[i] += c;
			tmp[i] += strings[i].substring(0,n) + strings[i].substring(n+1);
			map.put(tmp[i], i);
		}
		Arrays.sort(tmp);
		for(int i=0;i<tmp.length;i++) {
			answer[i] = strings[map.get(tmp[i])];
			}
        return answer;
    }
}