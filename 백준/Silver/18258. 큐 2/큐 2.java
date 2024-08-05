import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // Queue 선언
        Queue<Integer> queue = new LinkedList<>();
        
        // 입력의 첫 줄을 읽어 명령어의 수를 얻음
        int N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            
            if (command.startsWith("push")) {
                // "push X" 명령어 처리
                int value = Integer.parseInt(command.split(" ")[1]);
                queue.add(value);
            } else if (command.equals("pop")) {
                // "pop" 명령어 처리
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
            } else if (command.equals("size")) {
                // "size" 명령어 처리
                sb.append(queue.size()).append("\n");
            } else if (command.equals("empty")) {
                // "empty" 명령어 처리
                sb.append(queue.isEmpty() ? "1\n" : "0\n");
            } else if (command.equals("front")) {
                // "front" 명령어 처리
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(queue.peek()).append("\n");
                }
            } else if (command.equals("back")) {
                // "back" 명령어 처리
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    // 큐의 끝에 있는 요소를 얻기 위해 큐를 순회할 필요가 있음
                    sb.append(((LinkedList<Integer>) queue).getLast()).append("\n");
                }
            }
        }
        
        // 결과를 출력
        System.out.print(sb.toString());
    }
}
