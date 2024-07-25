import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());

        long count = 0;
        long i = 1;
        while (S >= 0) {
            S = S - i;
            count++;
            i++;
        }
        System.out.println(count - 1);
    }
}
