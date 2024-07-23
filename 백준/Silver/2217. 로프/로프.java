import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] ropes = new int[N];
        
        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }
        
        // 로프 배열을 내림차순으로 정렬
        Arrays.sort(ropes);
        
        int maxWeight = 0;
        
        // 각 로프를 사용했을 때의 최대 중량 계산
        for (int i = 0; i < N; i++) {
            int weightWithCurrentRope = ropes[i] * (N - i);
            if (weightWithCurrentRope > maxWeight) {
                maxWeight = weightWithCurrentRope;
            }
        }
        
        // 결과 출력
        System.out.println(maxWeight);
    }
}
