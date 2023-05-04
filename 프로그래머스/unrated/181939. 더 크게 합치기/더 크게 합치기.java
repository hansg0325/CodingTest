class Solution {
    public int solution(int a, int b) {
        String tmp1 = Integer.toString(a);
        tmp1 += Integer.toString(b);
        String tmp2 = Integer.toString(b);
        tmp2 += Integer.toString(a);
        int answer = 0;
        if(Integer.parseInt(tmp1) > Integer.parseInt(tmp2) ) {
            answer = Integer.parseInt(tmp1);
        } else if(Integer.parseInt(tmp1) < Integer.parseInt(tmp2) ) {
            answer = Integer.parseInt(tmp2);
        } else {
            answer = Integer.parseInt(tmp1);
        }
        return answer;
    }
}