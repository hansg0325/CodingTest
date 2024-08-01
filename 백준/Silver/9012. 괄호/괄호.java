import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  // 테스트 케이스의 수
        sc.nextLine();  // 줄바꿈 문자 처리
        
        for (int i = 0; i < T; i++) {
            String ps = sc.nextLine();  // 괄호 문자열 입력 받기
            System.out.println(isValidParenthesisString(ps) ? "YES" : "NO");
        }
        
        sc.close();
    }
    
    public static boolean isValidParenthesisString(String ps) {
        Stack<Character> stack = new Stack<>();  // 스택 생성
        
        for (int i = 0; i < ps.length(); i++) {
            char ch = ps.charAt(i);
            if (ch == '(') {
                stack.push(ch);  // 열리는 괄호는 스택에 추가
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false;  // 스택이 비어있으면 올바르지 않음
                }
                stack.pop();  // 닫히는 괄호는 스택에서 제거
            }
        }
        
        return stack.isEmpty();  // 모든 괄호가 짝을 이뤘으면 스택이 비어 있어야 함
    }
}
