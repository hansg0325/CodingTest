import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int N, M, K;
    static int[][] original;
    static int[][] map;
    static ArrayList<Operation> operations = new ArrayList<>();
    static int minVal = Integer.MAX_VALUE;
    
    static class Operation {
        int r, c, s;
        
        Operation(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        original = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                original[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            operations.add(new Operation(r, c, s));
        }
        
        permute(0, new ArrayList<Operation>());
        
        System.out.println(minVal);
    }
    
    static void permute(int depth, ArrayList<Operation> selected) {
        if (depth == K) {
            rotateAndCalculate(selected);
            return;
        }
        
        for (Operation op : operations) {
            if (!selected.contains(op)) {
                selected.add(op);
                permute(depth + 1, selected);
                selected.remove(selected.size() - 1);
            }
        }
    }
    
    static void rotateAndCalculate(ArrayList<Operation> selected) {
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(original[i], 0, map[i], 0, M);
        }
        
        for (Operation op : selected) {
            rotate(op);
        }
        
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += map[i][j];
            }
            minVal = Math.min(minVal, sum);
        }
    }
    
    static void rotate(Operation op) {
        int r = op.r;
        int c = op.c;
        int s = op.s;
        
        for (int layer = 1; layer <= s; layer++) {
            int top = r - layer;
            int bottom = r + layer;
            int left = c - layer;
            int right = c + layer;
            
            int temp = map[top][left];
            
            for (int i = top; i < bottom; i++) {
                map[i][left] = map[i + 1][left];
            }
            for (int i = left; i < right; i++) {
                map[bottom][i] = map[bottom][i + 1];
            }
            for (int i = bottom; i > top; i--) {
                map[i][right] = map[i - 1][right];
            }
            for (int i = right; i > left + 1; i--) {
                map[top][i] = map[top][i - 1];
            }
            
            map[top][left + 1] = temp;
        }
    }
}
