import org.w3c.dom.html.HTMLParagraphElement;

import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                char[][] board = new char[8][8];
                int a = startWhite(i, j);
                int b = startBlack(i, j);

                answer = Math.min(answer, Math.min(startWhite(i, j), startBlack(i, j)));
            }
        }
        System.out.println(answer);

    }

    static int startWhite(int x, int y) {
        int sum = 0;
        for (int i = x; i < x+8; i++) {
            for (int j = y; j < y+8; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    if (arr[i][j] != 'W') {
                        sum++;
                    }
                } else if (i % 2 != 0 && j % 2 == 0) {
                    if (arr[i][j] != 'B') {
                        sum++;
                    }
                } else if (i % 2 == 0 && j % 2 != 0) {
                    if (arr[i][j] != 'B') {
                        sum++;
                    }
                } else {
                    if (arr[i][j] != 'W') {
                        sum++;
                    }
                }
            }
        }

        return sum;
    }

    static int startBlack(int x, int y) {
        int sum = 0;
        for (int i = x; i < x+8; i++) {
            for (int j = y; j < y+8; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    if (arr[i][j] != 'B') {
                        sum++;
                    }
                } else if (i % 2 != 0 && j % 2 == 0) {
                    if (arr[i][j] != 'W') {
                        sum++;
                    }
                } else if (i % 2 == 0 && j % 2 != 0) {
                    if (arr[i][j] != 'W') {
                        sum++;
                    }
                } else {
                    if (arr[i][j] != 'B') {
                        sum++;
                    }
                }
            }
        }

        return sum;
    }
}