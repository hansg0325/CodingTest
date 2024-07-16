import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] snowAmounts = new Integer[N];

        for (int i = 0; i < N; i++) {
            snowAmounts[i] = sc.nextInt();
        }
        sc.close();

        // 눈의 양을 내림차순으로 정렬
        Arrays.sort(snowAmounts, Collections.reverseOrder());

        int totalTime = 0;
        while (snowAmounts[0] > 0) {
            // 두 집을 선택해서 눈을 치움
            if (N > 1 && snowAmounts[1] > 0) {
                snowAmounts[0]--;
                snowAmounts[1]--;
                totalTime++;
            } else {
                // 한 집의 눈을 치움
                snowAmounts[0]--;
                totalTime++;
            }

            // 다시 정렬해서 가장 큰 값이 맨 앞에 오도록 함
            Arrays.sort(snowAmounts, Collections.reverseOrder());

            if (totalTime > 1440) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(totalTime);
    }
}
