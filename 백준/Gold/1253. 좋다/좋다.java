import org.w3c.dom.html.HTMLParagraphElement;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int answer = 0;

        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N - 1;
            int target = arr[i];
            while (left < right) {
                int sum = arr[left] + arr[right];
                if (sum == target) { // sum이 target과 같을 경우
                    if (left != i && right != i) { // left와 right가 같은 수가 아닐경우
                        answer++;
                        break;
                    } else if (left == i) { 
                        left++;
                    } else {
                        right--;
                    }
                } else if (sum < target) { //sum이 target보다 작을 경우
                    left++;
                } else { // sum이 target보다 클 경우
                    right--;
                }
            }
        }
        System.out.println(answer);
    }
}