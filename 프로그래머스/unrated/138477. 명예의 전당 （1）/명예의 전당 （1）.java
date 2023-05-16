import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
		int[] answer = new int[score.length];
		int[] board = new int[k];
		int min = score[0];
		for(int i=0;i<score.length;i++) {
			if(i<k) {
				min = Math.min(min, score[i]);
				answer[i]=min;
				board[0]=score[i];
				Arrays.sort(board);
			}
			else {
			if(score[i]>board[0]) {
				board[0]=score[i];				
			}
			Arrays.sort(board);
			answer[i]=board[0];
			}
		}
        return answer;
    }
}