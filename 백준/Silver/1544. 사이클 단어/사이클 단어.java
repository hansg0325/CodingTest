import org.w3c.dom.html.HTMLParagraphElement;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        String[] arr = new String[N];

        List<String> list = new ArrayList<>();


        for (int i = 0; i < N; i++) {
//            arr[i] = br.readLine();
            list.add(br.readLine());
        }

        int answer = N;

        for (int i = 0; i < N; i++) {
            String tmp1 = list.get(i);
            for (int j = i + 1; j < N; j++) {
                if (tmp1.length() == list.get(j).length()) {
                    String tmp2 = list.get(j) + list.get(j);
                    if (tmp2.contains(tmp1)) {
                        list.remove(j);
                        answer--;
                        N--;
                        j--;
                    }
                }
            }
        }
        System.out.println(answer);

        bw.flush();
        bw.close();
        br.close();
    }
}