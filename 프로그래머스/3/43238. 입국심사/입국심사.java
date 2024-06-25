import java.util.*;

class Solution {
    static long answer = 0;
    public long solution(int n, int[] times) {
        long low = 1;
        long high = Long.MIN_VALUE;
        for (int i = 0; i < times.length; i++) {
            high = Math.max(times[i], high);
        }
        high *= n; // 최대 시간을 구한 후 n을 곱합니다.

        immigration(low, high, n, times);
        return answer;
    }

    static void immigration(long low, long high, int n, int[] times) {
        while (low <= high) { // Corrected the condition
            long mid = (low + high) / 2;
            if (canProcessAll(mid, n, times)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
    }

    static boolean canProcessAll(long mid, int n, int[] times) {
        long person = 0; // Changed to long to avoid overflow
        for (int i = 0; i < times.length; i++) {
            person += mid / times[i]; // Corrected the division
            if (person >= n) {
                return true;
            }
        }
        return false;
    }
}
