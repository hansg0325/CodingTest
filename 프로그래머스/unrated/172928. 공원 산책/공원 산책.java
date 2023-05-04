class Solution {
    public int[] solution(String[] park, String[] routes) {
        		int[] answer = new int[2];

		for(int i=0;i<park.length;i++) {
			for(int j=0;j<park[i].length();j++) {
				if(park[i].charAt(j)=='S') {
					answer[0] = i;
					answer[1] = j;
				}
			}
		}
		
		
		for(int i=0;i<routes.length;i++) {

			if(routes[i].charAt(0)=='E') {
				boolean flag = false;
				int move = Character.getNumericValue(routes[i].charAt(2));
				
				if(answer[1]+move>=park[answer[0]].length()) {
					continue;
				}
				for(int j=1;j<=move;j++) {
					if(park[answer[0]].charAt(answer[1]+j)=='X') {
						flag = true;
						break;
					}
				}
				if(flag == true) {
					continue;
				}
				answer[1]+=move;
			}
			
			if(routes[i].charAt(0)=='W') {
				boolean flag = false;
				int move = Character.getNumericValue(routes[i].charAt(2));
				
				if(answer[1]-move<0) {
					continue;
				}
				for(int j=1;j<=move;j++) {
					if(park[answer[0]].charAt(answer[1]-j)=='X') {
						flag = true;
						break;
					}
				}
				if(flag == true) {
					continue;
				}
				answer[1]-=move;
			}
			
			if(routes[i].charAt(0)=='S') {
				boolean flag = false;
				int move = Character.getNumericValue(routes[i].charAt(2));
				
				if(answer[0]+move>=park.length) {
					continue;
				}
				for(int j=1;j<=move;j++) {
					if(park[answer[0]+j].charAt(answer[1])=='X') {
						flag = true;
						break;
					}
				}
				if(flag == true) {
					continue;
				}
				answer[0]+=move;
			}

			if(routes[i].charAt(0)=='N') {
				boolean flag = false;
				int move = Character.getNumericValue(routes[i].charAt(2));
				
				if(answer[0]-move<0) {
					continue;
				}
				for(int j=1;j<=move;j++) {
					if(park[answer[0]-j].charAt(answer[1])=='X') {
						flag = true;
						break;
					}
				}
				if(flag == true) {
					continue;
				}
				answer[0]-=move;
			}
			
		}
        return answer;
    }
}