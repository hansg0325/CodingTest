class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int[] wall = new int[n];
        for(int i=0;i<n;i++) {
            wall[i]=1;
            for(int j=0;j<section.length;j++) {
                if(i==section[j]-1) {
                    wall[i]=0;
                }
            }
        }

        for(int i=0;i<n;i++) {
            if(wall[i]==0) {
                i+=m-1;
                answer++;
            }
        }
        return answer;
    }
}
