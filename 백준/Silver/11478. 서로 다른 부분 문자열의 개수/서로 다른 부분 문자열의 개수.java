import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 문자열 S 입력받기
        String s = br.readLine();
        
        // 고유한 부분 문자열을 저장할 Set
        Set<String> uniqueSubstrings = new HashSet<>();
        
        // 모든 부분 문자열을 생성하여 Set에 넣기
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                uniqueSubstrings.add(substring);
            }
        }
        
        // 고유한 부분 문자열의 개수 출력
        System.out.println(uniqueSubstrings.size());
    }
}
