class Solution {
    public int solution(String dartResult) {
        int answer = 0;
		String tmp = "";
		int[] score = new int[3];
		for(int s : score) {
			s=0;
		}
		int idx = 0;
		for(int i=0;i<dartResult.length();i++) {
			if(dartResult.charAt(i)=='S') {
				score[idx]+=Integer.parseInt(tmp);
				idx++;
				tmp="";
			} else if(dartResult.charAt(i)=='D') {
				score[idx]+=(Integer.parseInt(tmp)*Integer.parseInt(tmp));
				idx++;
				tmp="";
			} else if(dartResult.charAt(i)=='T') {
				score[idx]+=(Integer.parseInt(tmp)*Integer.parseInt(tmp)*Integer.parseInt(tmp));
				idx++;
				tmp="";
			} else if(dartResult.charAt(i)=='*') {
				if(idx==1) {
					score[idx-1]*=2;
				} else if(idx>=3) {
					score[1]*=2;
					score[2]*=2;
				}
				else {
					score[idx-2]*=2;
					score[idx-1]*=2;
				}
				tmp="";
			} else if(dartResult.charAt(i)=='#') {
				score[idx-1]*=(-1);
				tmp="";
			} else {
				tmp+=dartResult.charAt(i);
			}
		}
		
		for(int s : score) {
			answer+=s;
		}
        return answer;
    }
}