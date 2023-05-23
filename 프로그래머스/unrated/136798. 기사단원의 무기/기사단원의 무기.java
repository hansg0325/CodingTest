class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
		int result;
		for(int i=1;i<=number;i++) {
			result=1;
			for(int j=1;j<=i/2;j++) {
				if(i%j==0) {
					result++;
				}
				if(result>limit) {
					result=power;
					break;
				}
			}
			answer+=result;
		}
        return answer;
    }
}