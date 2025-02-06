import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 🔹 HashSet 대신 LinkedHashSet 사용 (입력 순서 유지 가능)
        Set<String> keywords = new LinkedHashSet<>();
        for (int i = 0; i < N; i++) {
            keywords.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String[] words = br.readLine().split(",");
            for (String word : words) {
                keywords.remove(word); // ✅ 평균 O(1)로 최적화됨
            }
            bw.write(keywords.size() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
