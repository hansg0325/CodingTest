import java.util.*;

public class Main {
    static List<String> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for (int t = 0; t < testCase; t++) {
            int N = sc.nextInt();
            result = new ArrayList<>();
            solve(N, 1, "1");

            Collections.sort(result);  // ASCII 순서에 따라 정렬
            for (String expression : result) {
                System.out.println(expression);
            }
            if (t < testCase - 1) {
                System.out.println();  // 각 테스트 케이스 결과 사이에 빈 줄
            }
        }
        sc.close();
    }

    static void solve(int N, int current, String expression) {
        if (current == N) {
            if (evaluate(expression) == 0) {
                result.add(expression);
            }
            return;
        }

        solve(N, current + 1, expression + " " + (current + 1));
        solve(N, current + 1, expression + "+" + (current + 1));
        solve(N, current + 1, expression + "-" + (current + 1));
    }

    static int evaluate(String expression) {
        String expr = expression.replace(" ", "");
        int sum = 0;
        int num = 0;
        int sign = 1;

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else {
                sum += sign * num;
                num = 0;
                if (c == '+') {
                    sign = 1;
                } else if (c == '-') {
                    sign = -1;
                }
            }
        }
        sum += sign * num;  // 마지막 숫자 처리
        return sum;
    }
}
