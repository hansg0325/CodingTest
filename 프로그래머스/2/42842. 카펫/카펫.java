class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int area = brown + yellow;
        
        for(int i=3;i<area;i++){
            if(area%i == 0){
                int width = i;
                int height = area/i;
                if(height<3){
                    continue;
                }
                if(((width*2) + (height-2)*2) == brown){
                    answer = new int[]{width, height};
                }
            }
        } 
        return answer;
    }
}