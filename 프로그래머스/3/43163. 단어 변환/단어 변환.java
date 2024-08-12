import java.util.*;

class Pair {
    String str;
    int num;
    
    public Pair(String str, int num){
        this.str = str;
        this.num = num;
    }
}

class Solution {
    static boolean[] visited;
    static PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.num));
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        pq.add(new Pair(begin, 0));
        int answer = solve(words.length, target, words);
        
        return answer;
    }
    static int solve(int n, String target, String[] words){
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            if(pair.str.equals(target)){
                return pair.num;
            }
            for(int i=0;i<n;i++){
                if(checkWordDiff(pair.str, words[i])){ // 1개의 알파벳만 다를경우
                    if(!visited[i]){
                        pq.add(new Pair(words[i], pair.num+1));
                        visited[i] = true;
                    }
                }
            }
        }
        return 0;
    }
    static boolean checkWordDiff(String str1, String str2){
        int diff = 0;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i)){
                diff++;
            }
        }
        if(diff == 1){
            return true;
        } else {
            return false;
        }
    }
}