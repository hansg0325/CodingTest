class Solution {
    public int solution(int[][] dots) {
        // 세 가지 조합에 대해 기울기 비교
        if (isParallel(dots[0], dots[1], dots[2], dots[3])) return 1;
        if (isParallel(dots[0], dots[2], dots[1], dots[3])) return 1;
        if (isParallel(dots[0], dots[3], dots[1], dots[2])) return 1;

        return 0;
    }

    // 두 선분 (a,b) 와 (c,d)가 평행한지 확인
    private boolean isParallel(int[] a, int[] b, int[] c, int[] d) {
        int dx1 = b[0] - a[0];
        int dy1 = b[1] - a[1];
        int dx2 = d[0] - c[0];
        int dy2 = d[1] - c[1];

        // 기울기 비교: dy1/dx1 == dy2/dx2 → cross-multiply to avoid division
        return dy1 * dx2 == dy2 * dx1;
    }
}