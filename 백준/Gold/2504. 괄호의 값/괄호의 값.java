import java.util.Stack;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        System.out.println(calculateBracketValue(input));
    }
    
    public static int calculateBracketValue(String str) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();
        
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[') {
                stack.push(ch);
                valueStack.push(-1); // Use -1 as a marker for open brackets
            } else {
                int value = 0;
                while (!valueStack.isEmpty() && valueStack.peek() != -1) {
                    value += valueStack.pop();
                }
                
                if (valueStack.isEmpty()) {
                    return 0; // Mismatched brackets
                }
                
                valueStack.pop(); // Pop the -1 marker
                
                if (ch == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return 0; // Mismatched brackets
                    }
                    value = (value == 0) ? 2 : 2 * value;
                } else if (ch == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return 0; // Mismatched brackets
                    }
                    value = (value == 0) ? 3 : 3 * value;
                }
                
                valueStack.push(value);
            }
        }
        
        if (!stack.isEmpty()) {
            return 0; // Mismatched brackets
        }
        
        int result = 0;
        while (!valueStack.isEmpty()) {
            result += valueStack.pop();
        }
        
        return result;
    }
}
