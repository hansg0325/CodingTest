class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int width=1;
		int height=1;
		for(int i=0;i<sizes.length;i++) {
			int longer = Math.max(sizes[i][0], sizes[i][1]);
			int shorter = Math.min(sizes[i][0], sizes[i][1]);
			
			if(longer > width) {
				width = longer;
			}
			if(shorter > height) {
				height = shorter;
			}
		}
		answer = width * height;
        return answer;
    }
}