import java.util.*;

class Solution {
    public long solution(String expression) {
        List<Long> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        StringBuilder num = new StringBuilder();

        // 숫자와 연산자 분리
        for (char ch : expression.toCharArray()) {
            if (ch == '+' || ch == '-' || ch == '*') {
                nums.add(Long.parseLong(num.toString()));
                ops.add(ch);
                num.setLength(0);
            } else {
                num.append(ch);
            }
        }
        nums.add(Long.parseLong(num.toString()));

        // 연산자 우선순위 조합
        List<char[]> priorities = Arrays.asList(
            new char[]{'+', '-', '*'},
            new char[]{'+', '*', '-'},
            new char[]{'-', '+', '*'},
            new char[]{'-', '*', '+'},
            new char[]{'*', '+', '-'},
            new char[]{'*', '-', '+'}
        );

        long max = 0;

        for (char[] order : priorities) {
            List<Long> numCopy = new ArrayList<>(nums);
            List<Character> opCopy = new ArrayList<>(ops);

            for (char op : order) {
                for (int i = 0; i < opCopy.size(); ) {
                    if (opCopy.get(i) == op) {
                        long res = calc(numCopy.get(i), numCopy.get(i + 1), op);
                        numCopy.remove(i + 1);
                        numCopy.set(i, res);
                        opCopy.remove(i);
                    } else {
                        i++;
                    }
                }
            }

            max = Math.max(max, Math.abs(numCopy.get(0)));
        }

        return max;
    }

    private long calc(long a, long b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
        }
        return 0;
    }
}
