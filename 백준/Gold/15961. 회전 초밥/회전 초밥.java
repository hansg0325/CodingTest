import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        // N=접시의 수, d=초밥의 가짓수, k=연속해서 먹는 접시의 수, c=쿠폰 번호
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 회전 초밥 배열
        int[] dishes = new int[N];
        for(int i=0;i<N;i++){
            dishes[i] = Integer.parseInt(br.readLine());
        }

        //먹은 초밥 배열 먹으면 1, 안먹으면 0
        int[] eat = new int[d+1];

        // 0번부터 k개 먹었을 경우 상태
        int cnt = 0;
        for(int i=0;i<k;i++){
            if(eat[dishes[i]] == 0) {
                cnt++;
            }
            eat[dishes[i]]++;
        }

        // 먹을 수 있는 초밥의 가짓수의 최댓값, 기본 값은 0번부터 k개 먹었을 경우의 최대값
        int max = cnt;

        //투포인터 초기화
        int start = 1;
        int end = k;

        //로직
        while(true){
            if(eat[dishes[start-1]] == 1) { // start-1 초밥이 이미 먹은 초밥이라면 cnt--
                cnt--;
            }
            // else 아니라면 그대로
            //먹은 초밥 배열 --
            eat[dishes[start-1]]--;

            //새로운 초밥이 먹은 초밥이라면 cnt++
            if(eat[dishes[end]] == 0) {
                cnt++;
            }
            // else 아니라면 그대로
            //새로 먹은 초밥 배열 ++
            eat[dishes[end]]++;

            if(eat[c] == 0) { //쿠폰초밥을 안먹었다면 max, cnt+1 중 큰 수
                max = Math.max(max, cnt+1);
            } else { //쿠폰초밥을 이미 먹었다면 그냥 비교
                max = Math.max(max, cnt);
            }

            start++;
            end++;
            if(end==N) { //end포인터가 배열끝까지 갔을 경우 처음으로
                end = 0;
            }
            if(start==N) { //start 포인터가 배열 끝까지 갔을 경우 종료
                break;
            }
        }
        System.out.println(max);

        bw.flush();
        bw.close();
        br.close();
    }
}