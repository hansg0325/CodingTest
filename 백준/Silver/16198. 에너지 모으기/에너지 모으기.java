import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer> weights;
    static int maxEnergy = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        weights = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights.add(Integer.parseInt(st.nextToken()));
        }

        collectEnergy(0);
        System.out.println(maxEnergy);
    }

    static void collectEnergy(int energy) {
        if (weights.size() == 2) { // 종료 조건: 남은 구슬이 2개일 때
            maxEnergy = Math.max(maxEnergy, energy);
            return;
        }

        for (int i = 1; i < weights.size() - 1; i++) {
            int currentEnergy = weights.get(i - 1) * weights.get(i + 1);
            int removedWeight = weights.remove(i);

            collectEnergy(energy + currentEnergy);

            weights.add(i, removedWeight); // 상태 복구
        }
    }
}