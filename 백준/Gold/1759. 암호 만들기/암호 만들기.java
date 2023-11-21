import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static char[] code;
    static char[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        L = Integer.parseInt(st.nextToken()); // 암호의 길이
        C = Integer.parseInt(st.nextToken()); // C개의 소문자

        code = new char[L]; // 암호를 저장할 배열
        arr = new char[C]; // 알파벳 입력받을 배열

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0); // 초기화
        }
        Arrays.sort(arr); // 사전순으로 정렬

        dfs(0, 0); //로직 실행
    }

    public static void dfs(int depth, int start) {
        // depth 가 L일 경우 종료
        if (depth == L) {
            if (isValid(code)) { // 자음,모음 체크하는 로직 실행 후 true 일 경우에만 출력
                for (char c : code) {
                    System.out.print(c);
                }
                System.out.println();
            }
            return;
        }
        for (int i = start; i < C; i++) {
            code[depth] = arr[i]; // 코드배열 입력
            dfs(depth+1, i+1); // depth 한칸 깊이, start 위치 한칸 이동
        }
    }

    // 자음이 2개이상 모음이 1개 이상인지 판별하는 로직
    public static boolean isValid(char[] code) {
        int c = 0; // 자음의 수
        int v = 0; // 모음의 수
        for (int i = 0; i < code.length; i++) {
            if (code[i] == 'a' || code[i] == 'e' || code[i] == 'i' || code[i] == 'o' || code[i] == 'u') {
                v++; // 모음일 경우 v++
            } else {
                c++; // 자음일 경우 c++
            }
        }
        if (c >= 2 && v >= 1) {
            return true; // 자음 2개 이상, 모음 1개이상 일 경우 true 반환
        } else {
            return  false; // 아닐경우 false 반환
        }
    }
}
