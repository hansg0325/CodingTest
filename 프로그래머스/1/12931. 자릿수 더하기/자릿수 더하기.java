import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = Integer.toString(n);
        for(int i=0;i<str.length();i++){
            String tmp = str.substring(i,i+1);
            answer += Integer.parseInt(tmp);
        }

        return answer;
    }
}