import java.io.*;
import java.util.*;

public class Main {
    static int N, max = Integer.MIN_VALUE;
    static int[][] eggs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        eggs = new int[N][2];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            eggs[i][0] = Integer.parseInt(st.nextToken()); // 계란의 내구도
            eggs[i][1] = Integer.parseInt(st.nextToken()); // 계란의 무게
        }

        breakEggs(0, 0); // 0번째 계란부터 시작, 현재까지 깨진 계란의 수 0

        System.out.println(max);
    }

    /**
     *
     * @param idx idx번째 계란
     * @param cnt 지금까지 깨진 계란의 수
     */
    static void breakEggs(int idx, int cnt) {
        if (idx == N) {
            max = Math.max(max, cnt);
            return;
        }

        // 손으로 든 계란이 이미 깨졌거나(내구도가 0이하가 되었거나), 모든계란이 이미 다 깨져있다면
        if (eggs[idx][0] <= 0 || cnt == N - 1) {
            // 다음 계란을 들어 봄
            breakEggs(idx + 1, cnt);
            return;
        }

        int nCnt = cnt;
        for (int i = 0; i < N; i++) {

            // 손에 든 계란과 부딪히려는 계란이 같은 계란이라면 통과
            if (i == idx) {
                continue;
            }

            // 부딪혀보려는 계란이 이미 깨져있다면 통과
            if (eggs[i][0] <= 0) {
                continue;
            }

            // 계란끼리 부딪혀 봄
            hitEgg(idx, i);

            // 부딪힌 후 손에 든 계란이 깨지면 cnt++
            if (eggs[idx][0] <= 0) {
                cnt++;
            }

            // 부딪혀 봤는데 타겟이 된 계란이 깨지면 cnt++
            if (eggs[i][0] <= 0) {
                cnt++;
            }

            // 다음 계란을 들어봄, 현재까지 깨진 계란의 수를 넘겨줌
            breakEggs(idx + 1, cnt);

            // 완전탐색을 위해 깨진 계란을 복구
            recoveryEgg(idx, i);
            cnt = nCnt;
        }
    }

    // 계란끼리 부딪혀 다른 계란의 무게만큼 내구도를 깎음
    static void hitEgg(int handEgg, int targetEgg) {
        eggs[targetEgg][0] -= eggs[handEgg][1];
        eggs[handEgg][0] -= eggs[targetEgg][1];
    }

    // 원상 복구하는 메서드
    static void recoveryEgg(int handEgg, int targetEgg) {
        eggs[targetEgg][0] += eggs[handEgg][1];
        eggs[handEgg][0] += eggs[targetEgg][1];
    }
}