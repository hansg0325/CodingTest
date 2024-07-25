import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }

        long totalComparisons = 0;

        while (pq.size() > 1) {
            long first = pq.poll();
            long second = pq.poll();
            long combined = first + second;
            totalComparisons += combined;
            pq.add(combined);
        }

        System.out.println(totalComparisons);
    }
}
