import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {
                map.put(word, map.getOrDefault(word, 0) + 1); // 같은 단어가 등록될경우 value를 하나씩 증가
            }
        }
        // map 의 value 기준 내림차순 정렬
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int cmp = o2.getValue().compareTo(o1.getValue()); // value 기준 내림차순 정렬 0일경우 value가 같음
                if (cmp == 0) {
                    int lengthCompare = Integer.compare(o2.getKey().length(), o1.getKey().length()); // value가 같을 경우 value가 같은것 끼리 key의 길이를 내림차순 정렬
                    return lengthCompare == 0 ? o1.getKey().compareTo(o2.getKey()) : lengthCompare; // key의 길이가 같을경우(lengthCompare == 0일경우) 길이가 같은것은 사전순으로 정렬
                }
                return cmp;
            }
        });
        for (Map.Entry<String, Integer> entry : entryList) {
            bw.write(entry.getKey());
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}