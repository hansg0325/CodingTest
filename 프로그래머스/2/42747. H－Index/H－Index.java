import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);  // 오름차순 정렬
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int h = n - i;  // 현재 인덱스 기준 h 값
            if (citations[i] >= h) {
                return h;  // h번 이상 인용된 논문이 h편 이상이면 반환
            }
        }

        return 0;  // 조건을 만족하는 h가 없는 경우
    }
}
