import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 초기 신기한 소수 시작 자리 설정
        int[] primeStarts = {2, 3, 5, 7};

        // 결과를 저장할 리스트
        List<Integer> results = new ArrayList<>();

        // 신기한 소수 찾기
        for (int start : primeStarts) { // 일의 자리가 2, 3, 5, 7 이여야함
            findAmazingPrimes(N, start, 1, results);
        }

        // 결과 정렬 및 출력
        Collections.sort(results); // 오름차순으로 정렬 후 출력
        for (int num : results) {
            System.out.println(num);
        }
    }

    // 재귀적으로 신기한 소수를 찾는 함수

    /**
     *
     * @param N N자리
     * @param current 현재 숫자
     * @param length 현재 숫자의 길이
     * @param results 현재 숫자의 길이가 N자리가 되면 results 리스트에 추가함
     */
    private static void findAmazingPrimes(int N, int current, int length, List<Integer> results) {
        if (length == N) { // N자리가 될 때까지 반복
            results.add(current);
            return;
        }

        // 다음 자리수로 확장
        for (int i = 1; i <= 9; i++) {
            int next = current * 10 + i;
            if (isPrime(next)) { // 소수면 true
                findAmazingPrimes(N, next, length + 1, results);
            }
        }
    }

    // 소수 판별 함수
    private static boolean isPrime(int num) {
        if (num < 2) return false; // 2보다 작으면 소수가 아님
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false; // num이 i로 나눠떨어지면 소수가 아님
        }
        return true;
    }
}
