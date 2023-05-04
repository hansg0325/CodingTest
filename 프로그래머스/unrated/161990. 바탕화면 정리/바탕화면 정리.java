class Solution {
    public int[] solution(String[] wallpaper) {
		int[] answer = new int[4];
		
		answer[0]=Integer.MAX_VALUE;
		answer[1]=Integer.MAX_VALUE;
		
		for(int i=0;i<wallpaper.length;i++) {
			for(int j=0;j<wallpaper[i].length();j++) {
				if(wallpaper[i].charAt(j)=='#') {
					answer[0]=Math.min(i, answer[0]);
					answer[1]=Math.min(j, answer[1]);
					answer[2]=Math.max(i, answer[2]);
					answer[3]=Math.max(j, answer[3]);
					}
				}
			}
		answer[2]++;
        answer[3]++;
        return answer;
    }
}