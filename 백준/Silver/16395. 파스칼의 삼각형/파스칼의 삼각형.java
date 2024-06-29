import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] pascal = new int[n + 1][n + 1];
        pascal[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j ++) {
                if (j == 1) {
                    pascal[i][j] = 1;
                } else if (j == i) {
                    pascal[i][j] = 1;
                } else {
                    pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
                }
            }
        }
        System.out.println(pascal[n][k]);
    }
}