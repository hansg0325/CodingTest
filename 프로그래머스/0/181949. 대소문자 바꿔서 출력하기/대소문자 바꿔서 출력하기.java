import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next(); // 입력 받기

        // 문자열의 대소문자 변환
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (Character.isUpperCase(c)) {
                result.append(Character.toLowerCase(c)); // 대문자를 소문자로 변환
            } else if (Character.isLowerCase(c)) {
                result.append(Character.toUpperCase(c)); // 소문자를 대문자로 변환
            }
        }

        // 결과 출력
        System.out.println(result.toString());
    }
}
