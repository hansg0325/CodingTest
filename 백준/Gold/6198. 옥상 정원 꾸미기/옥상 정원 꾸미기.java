import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        long count = 0;  // 총 벤치마킹 가능한 빌딩의 수를 저장할 변수

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && stack.peek() <= heights[i]) {
                stack.pop();  // 현재 빌딩보다 작거나 같은 빌딩은 볼 수 있으므로 pop
            }
            count += stack.size();  // 스택에 남아있는 빌딩은 현재 빌딩이 볼 수 있는 빌딩
            stack.push(heights[i]);  // 현재 빌딩을 스택에 push
        }

        System.out.println(count);
    }
}
