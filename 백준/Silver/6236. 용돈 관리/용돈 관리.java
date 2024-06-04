import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M, left, right = 0, result = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right += arr[i];
            left = Math.max(left, arr[i]);
        }

        parametricSearch();
        System.out.println(result);
    }
    static void parametricSearch() {
        while (left <= right) {
            int mid = (left + right) / 2;

            int sum = mid;
            int count = 0;
            if (M >= getMid(mid)) { // 인출한 횟수가 작거나 같으면 mid를 줄여야 한다
                result = mid;
                right = mid - 1;
            } else { // 인출한 횟수가 M보다 클 경우 mid를 늘려야 한다
                left = mid + 1;
            }
        }
    }

    static int getMid(int tmp) {
        //tmp = 한번에 인출할 수 있는 돈
        int count = 1; // 돈을 인출한 횟수
        int money = tmp; // 현재 남아있는 돈

        for (int num : arr) { // 하루에 사용할 금액 num
            money -= num; // 현재 남아있는 돈에서 사용할 금액을 뺀다
            if (money < 0) { // 0원보다 적어지면 다시 현금을 인출한다.
                count++; // 현금을 인출했으므로 count++
                money = tmp - num; // 0원보다 적어질 경우 남은 금액을 통장에 넣고 다시 인출하므로
            }
        }
        return count; // 인출한 횟수 리턴
    }
}