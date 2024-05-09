import java.io.*;
import java.util.*;

public class Main {
    static int N, answer = Integer.MAX_VALUE;
    static int[][] players;
    static boolean[] selected;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        players = new int[N][N];
        selected = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                players[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0, 0);
        System.out.println(answer);
        br.close();

    }
    static void solve(int depth, int index) {
        if (answer == 0) {
            return;
        }

        if (depth == N/2) {
            int startTeam = 0;
            int linkTeam = 0;

//            for (int i = 0; i < N; i++) {
//                if (selected[i]) {
//                    for (int j = 0; j < N; j++) {
//                        if (selected[j]) {
//                            startTeam += players[i][j];
//                        }
//                    }
//                } else {
//                    for (int k = 0; k < N; k++) {
//                        if (!selected[k]) {
//                            linkTeam += players[i][k];
//                        }
//                    }
//                }
//            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (selected[i] && selected[j]) {
                        startTeam += players[i][j];
                    } else if (!selected[i] && !selected[j]) {
                        linkTeam += players[i][j];
                    }
                }
            }
         int diff = Math.abs(startTeam - linkTeam);
            answer = Math.min(answer, diff);
            return;
        }
        for (int i = index; i < N; i++) {
            if (!selected[i]) {
                selected[i] = true;
                solve(depth + 1, i + 1);
                selected[i] = false;
            }
        }
    }
}