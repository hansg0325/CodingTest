class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String tmp = Integer.toString(x);
		int num=0;
		for(int i=0;i<tmp.length();i++) {
			num+=(int)tmp.charAt(i)-'0';
		}
		if(x%num!=0) {
			answer=false;
		}
        return answer;
    }
}