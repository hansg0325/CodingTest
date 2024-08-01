import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();  // 필요한 기타줄 개수
        int M = sc.nextInt();  // 브랜드의 수
        
        int minPackagePrice = Integer.MAX_VALUE;  // 패키지의 최소 가격
        int minSinglePrice = Integer.MAX_VALUE;   // 낱개의 최소 가격
        
        // 각 브랜드의 패키지 가격과 낱개 가격을 입력받아 최소값 갱신
        for (int i = 0; i < M; i++) {
            int packagePrice = sc.nextInt();
            int singlePrice = sc.nextInt();
            
            if (packagePrice < minPackagePrice) {
                minPackagePrice = packagePrice;
            }
            if (singlePrice < minSinglePrice) {
                minSinglePrice = singlePrice;
            }
        }
        
        // 1. 패키지로만 사는 경우의 비용
        int costByPackageOnly = ((N / 6) + 1) * minPackagePrice;
        
        // 2. 낱개로만 사는 경우의 비용
        int costBySingleOnly = N * minSinglePrice;
        
        // 3. 패키지와 낱개를 조합해서 사는 경우의 비용
        int costByMixed = (N / 6) * minPackagePrice + (N % 6) * minSinglePrice;
        
        // 이 세 가지 방법 중 최소값을 결과로 출력
        int minCost = Math.min(costByPackageOnly, Math.min(costBySingleOnly, costByMixed));
        
        System.out.println(minCost);
    }
}
