import java.lang.Math;
import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int Left = 10;
        int Right = 12;
        for(int n : numbers) {
            if(n==1 || n==4 || n == 7) {
                Left=n;
                answer+="L";
            } else if (n==3 || n==6 || n==9) {
                Right=n;
                answer+="R";
            } else if (n==2 || n==5 || n==8 || n==0) {
                if(n==0) {
                    n=11;
                }
                int leftDiff = (Math.abs(n-Left)/3) + (Math.abs(n-Left)%3);
                int rightDiff = (Math.abs(n-Right)/3) + (Math.abs(n-Right)%3);
                if(leftDiff>rightDiff) {
                    Right=n;
                    answer+="R";
                } else if (leftDiff<rightDiff) {
                    Left=n;
                    answer+="L";
                } else {
                    if(hand.equals("left")) {
                        Left=n;
                        answer+="L";
                    } else {
                        Right=n;
                        answer+="R";
                    }
                }
                
            }
        }
        
        return answer;
    }
}