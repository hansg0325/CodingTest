class Solution {
    public boolean solution(String s) {
        int count = 0; // 열린 괄호 '('의 개수를 추적
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++; // '('가 나오면 증가
            } else {
                count--; // ')'가 나오면 감소
            }
            
            // 닫는 괄호 ')'가 더 많아지는 순간, 잘못된 괄호 문자열
            if (count < 0) {
                return false;
            }
        }
        
        // 모든 괄호를 처리했을 때 count가 0이면 올바른 괄호
        return count == 0;
    }
}
