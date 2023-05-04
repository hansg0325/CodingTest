class Solution {
    public String solution(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        String answer = "";
        for(int i=0;i<arr1.length;i++){
            answer+=arr1[i];
            answer+=arr2[i];
        }
        return answer;
    }
}