class Solution {
    public int solution(int a, int b) {
        int answer = 0;
                String tmp1;
        tmp1 = Integer.toString(a);
        tmp1 += Integer.toString(b);
        int tmp2 = 2*a*b;
        if(Integer.parseInt(tmp1)>tmp2) {
            answer = Integer.parseInt(tmp1);
        } else if (Integer.parseInt(tmp1)<tmp2) {
            answer = tmp2;
        } else {
            answer = Integer.parseInt(tmp1);
        }
        return answer;
    }
}