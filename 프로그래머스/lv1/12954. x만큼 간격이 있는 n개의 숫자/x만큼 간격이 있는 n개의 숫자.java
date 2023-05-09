class Solution {
    public long[] solution(int x, int n) {
        Long xLong = new Long(x);
  
        long[] answer = new long[n];
		for(int i=0;i<n;i++) {
			answer[i]=xLong*(i+1);
		}
        return answer;
    }
}