import java.util.*;

class Solution {
    public int solution(String before, String after) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : before.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (char c : after.toCharArray()) {
            if (!map.containsKey(c)) return 0;
            map.put(c, map.get(c) - 1);
            if (map.get(c) < 0) return 0;
        }
        
        return 1;
    }
}
