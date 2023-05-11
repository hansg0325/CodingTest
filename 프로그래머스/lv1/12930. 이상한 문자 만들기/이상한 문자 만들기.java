class Solution {
    public String solution(String s) {
        String answer = "";
        String[] words = s.split("");
		int idx=1;
		
		for(String w : words) {
			if(w.equals(" ")) {
				idx=1;
			} else if(idx%2!=0) {
				w=w.toUpperCase();
				idx++;
			} else if(idx%2==0) {
				w=w.toLowerCase();
				idx++;
			}
			answer+=w;
		}
		System.out.println(answer);
        return answer;
    }
}