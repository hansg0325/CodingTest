import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String words = br.readLine();
        int countZero = 0;
        int countOne = 0;

        for (int i = 0; i < words.length(); i++) {
            if (words.charAt(i) == '0') { // 0의 개수 카운팅
                countZero++;
            } else { // 1의 개수 카운팅
                countOne++;
            }
        }
        countZero/=2; // 0의 개수 카운팅 한것의 절반을 날림
        countOne/=2; // 1의 개수 카운팅 한것의 절반을 날림
        
        // 1 제거 로직
        int i = 0;
        while (countOne != 0) {
            if (words.charAt(i) == '1') { // 해당 인덱스의 가 1일 경우
                words = words.substring(0, i) + words.substring(i + 1); // i번 인덱스를 제거한다
                countOne--;
                i = -1; // i번 인덱스를 제거할 경우 i를 다시 초기화 해주어야 인덱스가 꼬이지 않는다
            }
            i++;
        }

        // 0 제거 로직
        int j = words.length() - 1;
        while (countZero != 0) {
            if (words.charAt(j) == '0') { // 해당 인덱스의 가 0일 경우
                words = words.substring(0, j) + words.substring(j + 1); // j번 인덱스를 제거한다
                countZero--;
                j = words.length(); // j번 인덱스를 제거할 경우 j를 다시 초기화 해주어야 인덱스가 꼬이지 않는다
            }
            j--;
        }
        System.out.println(words);

        bw.flush();
        bw.close();
        br.close();
    }
}