class Solution {
    public String solution(String s, int n) {
        String answer = "";
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if('A'<=c && c<='Z') {
				c+=n;
				if(c>'Z') {
					c-=26;
				}
			} else if('a'<=c && c<='z') {
				c+=n;
				if(c>'z') {
					c-=26;
				}
			}
			answer+=c;
		}
        return answer;
    }
}