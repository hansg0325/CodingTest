import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] bin = new String[arr1.length];
		String[] answer = new String[bin.length];

		for(int i=0;i<arr1.length;i++) {
			arr1[i] = (arr1[i] | arr2[i]);
			String bin_len = Integer.toBinaryString(arr1[i]);
            answer[i]=""; 
			if(bin_len.length()<n) {
				for(int j=0;j<n-bin_len.length();j++)
				answer[i]+=' ';
			}
			bin[i] = Integer.toBinaryString(arr1[i]);
			
			System.out.println(bin[i]);
			System.out.println(bin[i].length());
		}
		for(String a : answer) {
			System.out.println(a);
		}
		for(int i=0;i<bin.length;i++) {
			for(int j=0;j<bin[i].length();j++) {

				if(bin[i].charAt(j)=='1') {
					answer[i]+='#';
				} else {
					answer[i]+=' ';
				}
			}
		}
        return answer;
    }
}