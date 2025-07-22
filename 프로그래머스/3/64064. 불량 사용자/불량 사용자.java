import java.util.*;

class Solution {
    static String[] user_id;
    static String[] banned_id;
    static boolean[] checked;
    static Set<List<String>> set = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        this.user_id = user_id;
        this.banned_id = banned_id;
        checked = new boolean[user_id.length];

        methodOne(0, new ArrayList<>());

        
        return set.size();
    }
    public void methodOne(int depth, ArrayList<String> list){
        if(depth == banned_id.length){
            List<String> copy = new ArrayList<>(list);
            Collections.sort(copy);
            set.add(copy);
            return;
        }
        for(int i=0;i<user_id.length;i++){
            if(!checked[i]){
                if(user_id[i].length() == banned_id[depth].length()){
                    if(methodTwo(i, depth)){
                        checked[i] = true;
                        list.add(user_id[i]);
                        methodOne(depth + 1, list);  // 재귀 호출 필수!
                        list.remove(list.size() - 1);
                        checked[i] = false;

                    }
                }

            }
        }
    }
    
    public boolean methodTwo(int index, int depth){
        for(int i=0;i<user_id[index].length();i++){
            if(banned_id[depth].charAt(i) == '*'){
                continue;
            } else if (banned_id[depth].charAt(i) != user_id[index].charAt(i)){
                return false;
            }
        }
        return true;
    }
}