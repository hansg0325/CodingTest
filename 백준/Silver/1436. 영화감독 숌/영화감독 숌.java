import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int count = 1;
        int number = 666;
        while (count != N) {
            number++;
            if (String.valueOf(number).contains("666")) {
                count++;
            }
        }
        System.out.println(number);
    }
}