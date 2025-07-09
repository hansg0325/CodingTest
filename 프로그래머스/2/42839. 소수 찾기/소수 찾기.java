import java.util.*;

class Solution {
    static String numbers;
    static boolean[] checked;
    static Set<Integer> set = new LinkedHashSet<>();
    static StringBuilder sb = new StringBuilder();
    public int solution(String numbers) {
        this.numbers = numbers;
        checked = new boolean[numbers.length()];
        int answer = 0;
        methodOne(sb);
        List<Integer> list = new ArrayList<>(set);
        for(int i=0;i<list.size();i++){
            int num = list.get(i);
            if(num == 1 || num < 2){
                continue;
            }
            if(methodTwo(num)){
                answer++;
            }
            
        }

        return answer;
    }
    public void methodOne(StringBuilder sb){
        for(int i=0;i<numbers.length();i++){
            if(checked[i]==true){
                continue;
            }
            char c = numbers.charAt(i);
            sb.append(c);
            set.add(Integer.parseInt(sb.toString()));
            checked[i] = true;
            methodOne(sb);
            sb.setLength(sb.length() - 1);
            checked[i] = false;
        }
    }
    
    public boolean methodTwo(int num){
        if(num==2){
            return true;
        }
        for(int i=2;i*i<=num;i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
}