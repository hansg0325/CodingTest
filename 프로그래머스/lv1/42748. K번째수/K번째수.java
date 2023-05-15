import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for(int x=0;x<commands.length;x++) {
				int i = commands[x][0];
				int j = commands[x][1];
				int k = commands[x][2];
				int[] tmp = new int[j-i+1];
				for(int n=0;n<tmp.length;n++) {
					tmp[n] = array[i-1];
					i++;
				}
				Arrays.sort(tmp);
				answer[x] = tmp[k-1];
		}
        return answer;
    }
}