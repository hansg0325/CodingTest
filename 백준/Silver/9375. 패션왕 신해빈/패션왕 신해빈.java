import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine()); // 각 테스트 케이스의 의상 개수
            HashMap<String, Integer> clothes = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                String type = input[1];
                clothes.put(type, clothes.getOrDefault(type, 0) + 1);
            }
            
            int result = 1;
            for (int count : clothes.values()) {
                result *= (count + 1); // 각 의상 종류별로 안 입는 경우까지 포함
            }
            
            // 알몸인 경우 제외
            System.out.println(result - 1);
        }
    }
}
