import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
		Arrays.sort(score);
		int idx = 0;
		int answer=0;
		for(int i=score.length-1;i>=0;i--) {
			idx++;
			if(idx==m) {
				idx=0;
				answer+=score[i]*m;
			}
		}
        return answer;
    }
}