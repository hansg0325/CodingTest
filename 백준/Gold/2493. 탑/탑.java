import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        Stack<int[]> stack = new Stack<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) { // 탑은 0번부터가 아닌 1번부터 시작
            int top = Integer.parseInt(st.nextToken()); // 현재 확인중인 탑
            while (!stack.isEmpty()) {
                if (stack.peek()[1] >= top) {
                    bw.write(stack.peek()[0] + " ");
                    break;
                }
                stack.pop();
            }
            if (stack.isEmpty()) {
                bw.write("0 ");
            }
            stack.push(new int[]{i, top});
        }
        bw.flush();
        bw.close();
        br.close();
    }
}