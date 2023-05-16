import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] stu1 = {1, 2, 3, 4, 5};
		int[] stu2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] stu3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		int[] score = {0, 0, 0};
		for(int i=0;i<answers.length;i++) {
			if(answers[i]==stu1[i%5]) {
				score[0]++;
			}
			if(answers[i]==stu2[i%8]) {
				score[1]++;
			}
			if(answers[i]==stu3[i%10]) {
				score[2]++;
			}
		}
		ArrayList<Integer> li = new ArrayList<>();
		int max = Math.max(Math.max(score[0], score[1]), score[2]);
		if(max==score[0]) li.add(1);
		if(max==score[1]) li.add(2);
		if(max==score[2]) li.add(3);
		int[] answer = new int[li.size()];
		for(int i=0;i<answer.length;i++) {
			answer[i]=li.get(i);
		}
        return answer;
    }
}