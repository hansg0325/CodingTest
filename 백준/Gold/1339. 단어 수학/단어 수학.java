import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        
        Map<Character, Integer> charValueMap = new HashMap<>();
        
        // 자릿수 기여도를 계산
        for (String word : words) {
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char c = word.charAt(i);
                int power = (int) Math.pow(10, length - 1 - i);
                charValueMap.put(c, charValueMap.getOrDefault(c, 0) + power);
            }
        }
        
        // 기여도를 내림차순으로 정렬
        List<Map.Entry<Character, Integer>> charValueList = new ArrayList<>(charValueMap.entrySet());
        charValueList.sort((a, b) -> b.getValue() - a.getValue());
        
        int maxSum = 0;
        int num = 9;
        
        // 숫자 할당
        for (Map.Entry<Character, Integer> entry : charValueList) {
            maxSum += entry.getValue() * num;
            num--;
        }
        
        System.out.println(maxSum);
    }
}
