class Solution {
    public int solution(int a, int b, int n) {
		int answer = 0;
		while(n>=a) {
			int empty=n-(n%a);
			answer+=(b*(n/a));
			n=n-empty+(b*(n/a));
		}
        return answer;
    }
}