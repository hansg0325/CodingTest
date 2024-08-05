import java.util.Scanner;

public class Main {
    static int[] parent;
    static int[] rank;

    // find 연산: x의 루트를 찾음
    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // 경로 압축(Path Compression)
        }
        return parent[x];
    }

    // union 연산: x와 y의 집합을 합침
    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            // 랭크에 따른 union by rank
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        // 초기화
        parent = new int[n + 1];
        rank = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int operation = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (operation == 0) {
                // 합집합 연산
                union(a, b);
            } else if (operation == 1) {
                // 같은 집합에 포함되어 있는지 확인
                if (find(a) == find(b)) {
                    result.append("YES\n");
                } else {
                    result.append("NO\n");
                }
            }
        }

        // 결과 출력
        System.out.print(result.toString());
    }
}
