class Solution {
    public String solution(int[] food) {
        String answer = "";
		for(int i=0;i<food.length;i++) {
			if(food[i]%2==0 && food[i]>1) {
				for(int j=0;j<food[i]/2;j++)
				answer+=i;
			} else if (food[i]%2!=0 && food[i]>1) {
				for(int j=0;j<food[i]/2;j++) {
					answer+=i;
				}
			}
		}
		answer+=0;
		String tmp = "";
		for(int i=answer.length()-2;i>=0;i--) {
			tmp += answer.charAt(i);
		}
        answer+=tmp;
        return answer;
    }
}