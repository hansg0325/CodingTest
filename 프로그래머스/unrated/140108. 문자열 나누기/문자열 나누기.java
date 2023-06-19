class Solution {
    public int solution(String s) {
        int n=0;
        int m=0;
        int answer = 0;
        char x = s.charAt(0);
        for(int i=0;i<s.length();i++) {
            if(x==s.charAt(i)) {
                n++;
            } else {
                m++;
            }
            if(n==m) {
                answer++;
                n=0;
                m=0;
                if(i+1>=s.length()){
                    break;
                } else {
                    x=s.charAt(i+1);
                }
            } else {
                if(i==s.length()-1){
                    answer++;
                }
            }
        }
        return answer;
    }
}