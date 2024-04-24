import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String before = br.readLine();
        String after = br.readLine();
        int beforeMin = Integer.parseInt(before.substring(3));
        int afterMin = Integer.parseInt(after.substring(3));
        int beforeHour = Integer.parseInt(before.substring(0, 2));
        int afterHour = Integer.parseInt(after.substring(0, 2));

        int answer = 0;
        while (beforeMin != afterMin) {
            beforeMin++;
            answer++;
            if (beforeMin == 60) {
                beforeMin -= 60;
                beforeHour++;
                if (beforeHour == 24) {
                    beforeHour-=24;
                }
            }
        }
        while (beforeHour != afterHour) {
            beforeHour++;
            answer++;
            if (beforeHour == 24) {
                beforeHour-=24;
            }
        }
        System.out.println(answer);

    }
}