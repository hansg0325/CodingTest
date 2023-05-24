import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
		String answer = "Yes";
		
		int idx1=0;
		int idx2=0;
		for(int i=0;i<goal.length;i++) {
			for(int j=0;j<cards1.length;j++) {
				if(goal[i].equals(cards1[j])) {
					if(idx1!=j) {
						answer="No";
					}
					idx1++;
				}
			}
			for(int j=0;j<cards2.length;j++) {
				if(goal[i].equals(cards2[j])) {
					if(idx2!=j) {
						answer = "No";
					}
					idx2++;
				}
			}
		}
        return answer;
    }
}