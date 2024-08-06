import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        while (t-- > 0) {
            Stack<Character> leftStack = new Stack<>();
            Stack<Character> rightStack = new Stack<>();
            String input = br.readLine();
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '<') {
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                } else if (input.charAt(i) == '>') {
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                } else if (input.charAt(i) == '-') {
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                } else {
                    leftStack.push(input.charAt(i));
                }
            }
            while (!leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            }
            while (!rightStack.isEmpty()) {
                bw.write(rightStack.pop());
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}