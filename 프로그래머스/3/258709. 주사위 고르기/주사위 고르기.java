import java.util.*;

class Solution {
    static int[][] dice;
    static int n;
    static List<Integer> select = new ArrayList<>();
    static List<Integer> arrA;
    static List<Integer> arrB;
    static int[] answer;
    static int max = Integer.MIN_VALUE;
    
    public int[] solution(int[][] dice) {
        Solution.dice = dice;
        n = dice.length;
        answer = new int[n/2];
        
        selectDice(0, 0);
        
        return answer;
    }
    static void selectDice(int depth, int index) {
        if(depth == n/2){
            int winning = calculate();
            if(max < winning){
                max = winning;
                for(int i=0;i<select.size();i++){
                    answer[i] = select.get(i) + 1;
                }
            }
            return;
        }
        
        for(int i=index;i<n;i++){
            select.add(i);
            selectDice(depth +1, i + 1);
            select.remove(select.size() - 1);
        }
    }
    static int calculate(){
        int count = 0;
        
        makeArrAB();
        
        Collections.sort(arrB);
        for(int i=0;i<arrA.size();i++){
            int number = arrA.get(i);
            int left = 0, right = arrB.size() - 1;
            int index = Integer.MIN_VALUE;
            while(left<=right){
                int mid = (left+right)/2;
                if(arrB.get(mid)< number){
                    left = mid+1;
                    index = Math.max(index, mid);
                } else {
                    right = mid - 1;
                }
            }
            if(index != Integer.MIN_VALUE){
                count += index + 1;
            }
        }
        
        return count;
    }
    static void makeArrAB(){
        arrA = new ArrayList<>();
        arrB = new ArrayList<>();
        int[][] diceA = new int[n/2][6];
        int[][] diceB = new int[n/2][6];
        int a=0, b=0;
        for(int i=0;i<n;i++){
            if(select.contains(i)){
                diceA[a] = dice[i];
                a++;
            } else {
                diceB[b] = dice[i];
                b++;
            }
        }
        
        makeArr(0, diceA, 0, arrA);
        makeArr(0, diceB, 0, arrB);
    }
    static void makeArr(int depth, int[][] diceX, int sum, List<Integer> arr){
        if(depth == n/2){
            arr.add(sum);
            return;
        }
        for(int i=0;i<6;i++){
            int newSum = sum + diceX[depth][i];
            makeArr(depth+1, diceX, newSum, arr);
        }
    }
}