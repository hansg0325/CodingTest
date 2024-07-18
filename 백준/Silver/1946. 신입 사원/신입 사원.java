import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 수

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());  // 지원자 수
            int[][] applicants = new int[N][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                applicants[i][0] = Integer.parseInt(st.nextToken());
                applicants[i][1] = Integer.parseInt(st.nextToken());
            }

            // 서류심사 성적 기준으로 정렬
            Arrays.sort(applicants, (a, b) -> Integer.compare(a[0], b[0]));

            int count = 1;  // 첫 번째 지원자는 무조건 선발
            int minInterviewRank = applicants[0][1];  // 현재까지의 최저 면접 성적

            for (int i = 1; i < N; i++) {
                if (applicants[i][1] < minInterviewRank) {
                    count++;
                    minInterviewRank = applicants[i][1];  // 최저 면접 성적 갱신
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}
