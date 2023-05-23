import java.util.*;

class Solution {
    public String solution(String X, String Y) {
		StringBuilder sb = new StringBuilder();
		int[] xArr = new int[10];
		int[] yArr = new int[10];
        String answer = "";
		for(String x : X.split("")) {
			xArr[Integer.parseInt(x)]++;
		}
		for(String y : Y.split("")) {
			yArr[Integer.parseInt(y)]++;
		}
		for(int i=0;i<yArr.length;i++) {
			System.out.println(yArr[i]);
		}
		for(int i=9;i>=0;i--) {
			while(xArr[i] > 0 && yArr[i] > 0) {
				sb.append(i);
				xArr[i]--;
				yArr[i]--;
			}
		}
		if(sb.toString().equals("")) {
			return "-1";
		}
		if(sb.toString().substring(0, 1).equals("0")) {
			return "0";
		}
        
        answer+=sb;
		
		return answer;
    }
}