class Solution {
    public int solution(int n) {
		int answer = 0;
		String trinary = "";
		while(n>2) {
			trinary+=n%3;
			n=n/3;
		}
		trinary+=n;
		int[] arr = new int[trinary.length()];
		int x = trinary.length();
		for(int i=0;i<x;i++) {
			int tmp = Character.getNumericValue(trinary.charAt(i));
			double mul = Math.pow(3, x-i-1);
			answer+=tmp*(int)mul;
		}
        return answer;
    }
}