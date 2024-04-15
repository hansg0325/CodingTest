import java.io.*;
import java.util.*;

public class Main {
    static char[][] board;
    static char player;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());

        board = new char[3][3];
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < 3; j++) {
                String input = br.readLine();
                for (int k = 0; k < 3; k++) {
                    board[j][k] = input.charAt(k);
                }
            }
            player = br.readLine().charAt(0);
            ticTacToe(player);
            bw.write("Case " + i + ":\n" );
            for (int a = 0; a < 3; a++) {
                for (int b = 0; b < 3; b++) {
                    bw.write(board[a][b]);
                }
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static void ticTacToe(char player) {
        int count;
        for (int i = 0; i < 3; i++) {
            count = 0;
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == player) {
                    count++;
                }
            }
            if (count >= 2) {
                board[i][0] = player;
                board[i][1] = player;
                board[i][2] = player;
                return;
            }
        }

        for (int i = 0; i < 3; i++) {
            count = 0;
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == player) {
                    count++;
                }
            }
            if (count >= 2) {
                board[0][i] = player;
                board[1][i] = player;
                board[2][i] = player;
                return;
            }
        }
        count = 0;
        for (int i = 0; i < 3; i++) {
            int j = i;
            if (board[i][j] == player) {
                count++;
            }
            if (count >= 2) {
                board[0][0] = player;
                board[1][1] = player;
                board[2][2] = player;
                return;
            }
        }

        count = 0;
        int j=2;
        for (int i = 0; i < 3; i++) {
            if (board[i][j] == player) {
                count++;
            }
            if (count >= 2) {
                board[0][2] = player;
                board[1][1] = player;
                board[2][0] = player;
                return;
            }
            j--;
        }
    }
}