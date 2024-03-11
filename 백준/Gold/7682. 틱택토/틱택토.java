import java.io.*;
import java.util.*;

public class Main {
    static char[][] board;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String input = "";
        board = new char[3][3];
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            input = st.nextToken();
            if (Objects.equals(input, "end")) {
                break;
            }
            int index = 0;
            int xCount = 0;
            int oCount = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = input.charAt(index);
                    if (board[i][j] == 'O') {
                        oCount++;
                    } else if (board[i][j] == 'X') {
                        xCount++;
                    }
                    index++;
                }
            }
            //게임판이 꽉 채워졌을 때
            //X가 먼저 말을 놓았음으로 O보다 1개 무조건 많아야 한다.
            if (xCount + oCount == 9 && xCount - oCount == 1) {
                //한 명이 빙고를 완성하면 게임이 끝나기 때문에
                //둘 다 빙고가 성립될 수 없다.
                if (isValid('X') && isValid('O')) {
                    bw.write("invalid\n");
                } else if (isValid('O')) {//말이 꽉 채워진 경우에는 O가 이길 수 없다
                    bw.write("invalid\n");
                } else { // X 가 이긴경우
                    bw.write("valid\n");
                }
            } else { // 게임판이 꽉 채워지지 않았을 경우
                //한 명이 빙고를 완성하면 게임이 끝나기 때문에
                //둘 다 빙고가 성립될 수 없다.
                if (isValid('X') && isValid('O')) {
                    bw.write("invalid\n");
                } else if (isValid('X') && xCount - oCount == 1) { //X가 이겼을 땐, X가 선공이어서 무조건 O보다 하나 많아야 한다
                    bw.write("valid\n");
                } else if (isValid('O') && xCount == oCount) { //O가 이겼을 땐, O가 후공이여서 X와 O의 개수가 같아야 한다
                    bw.write("valid\n");
                } else { // 아직 게임판이 덜채워졌는데 게임이 끝날 수는 없다
                    bw.write("invalid\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isValid(char c) {
        //가로가 성립할 때
        for (int i = 0; i < 3; i++) {
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == c) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            }
        }

        //세로가 성립할 때
        for (int i = 0; i < 3; i++) {
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == c) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            }
        }

        // 대각선이 성립할 때
        if (board[0][0] == c && board[1][1] == c && board[2][2] == c) {
            return true;
        }
        if (board[0][2] == c && board[1][1] == c && board[2][0] == c) {
            return true;
        }

        return false;
    }
}