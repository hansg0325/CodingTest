import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] numbers;
    static int[] operators = new int[4];
    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, numbers[0]);

        System.out.println(maxResult);
        System.out.println(minResult);
    }

    public static void dfs(int index, int currentResult) {
        if (index == N) {
            maxResult = Math.max(maxResult, currentResult);
            minResult = Math.min(minResult, currentResult);
            return;
        }

        if (operators[0] > 0) {
            operators[0]--;
            dfs(index + 1, currentResult + numbers[index]);
            operators[0]++;
        }
        if (operators[1] > 0) {
            operators[1]--;
            dfs(index + 1, currentResult - numbers[index]);
            operators[1]++;
        }
        if (operators[2] > 0) {
            operators[2]--;
            dfs(index + 1, currentResult * numbers[index]);
            operators[2]++;
        }
        if (operators[3] > 0) {
            operators[3]--;
            dfs(index + 1, currentResult / numbers[index]);
            operators[3]++;
        }
    }
}
