import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.close();

        if (N == 1) {
            // N이 1일 때 나이트는 움직일 수 없다.
            System.out.println(1);
        } else if (N == 2) {
            // N이 2일 때 두 가지 방법만 사용할 수 있다.
            System.out.println(Math.min(4, (M + 1) / 2));
        } else {
            if (M < 7) {
                // N >= 3이고 M이 7보다 작을 때 모든 방법을 사용할 수 없다.
                System.out.println(Math.min(4, M));
            } else {
                // N >= 3이고 M >= 7일 때 모든 방법을 사용하여 최대한 오른쪽으로 이동.
                System.out.println(M - 2);
            }
        }
    }
}
