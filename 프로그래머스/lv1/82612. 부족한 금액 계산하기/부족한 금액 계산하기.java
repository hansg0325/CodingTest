class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long sum=0;
		for(int i=1;i<=count;i++) {
			sum+=price*i;
		}
        
		answer=Math.abs(money-sum);
        if(sum<=money){
            answer=0;
        }
        return answer;
    }
}