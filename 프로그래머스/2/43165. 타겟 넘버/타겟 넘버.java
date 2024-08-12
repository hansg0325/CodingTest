class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int index, int currentSum) {
        // 기저 조건: 모든 숫자를 다 사용한 경우
        if (index == numbers.length) {
            return currentSum == target ? 1 : 0;
        }

        // 현재 숫자를 더하는 경우와 빼는 경우를 모두 재귀적으로 호출
        return dfs(numbers, target, index + 1, currentSum + numbers[index]) +
               dfs(numbers, target, index + 1, currentSum - numbers[index]);
    }
}
