import java.util.Scanner;

public class Main {
    private static int[][] board = new int[9][9];
    private static boolean solved = false; // 스도쿠가 풀렸는지 여부를 체크

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 스도쿠 판 입력받기
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        // 스도쿠 풀기
        solveSudoku(0, 0);

        // 결과 출력
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void solveSudoku(int row, int col) {
        if (solved) return;  // 이미 스도쿠가 풀렸으면 더 이상 진행하지 않음
        if (row == 9) {
            solved = true;  // 모든 행을 다 채운 경우 스도쿠가 풀렸음을 표시
            return;
        }

        // 다음 열로 이동, 마지막 열이면 다음 행으로 이동
        int nextRow = (col == 8) ? row + 1 : row;
        int nextCol = (col == 8) ? 0 : col + 1;

        // 이미 채워져 있는 칸이면 다음 칸으로 넘어간다.
        if (board[row][col] != 0) {
            solveSudoku(nextRow, nextCol);
            return;
        }

        // 1부터 9까지 숫자를 넣어보면서 조건에 맞는지 확인
        for (int num = 1; num <= 9; num++) {
            if (isValid(row, col, num)) {
                board[row][col] = num;
                solveSudoku(nextRow, nextCol);
                if (solved) return;  // 해를 찾으면 즉시 종료
                board[row][col] = 0;  // 백트래킹
            }
        }
    }

    private static boolean isValid(int row, int col, int num) {
        // 가로줄 검사
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // 세로줄 검사
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // 3x3 박스 검사
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
