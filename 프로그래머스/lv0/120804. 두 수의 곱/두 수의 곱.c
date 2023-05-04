#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int num1, int num2) {
    int answer = num1*num2;
    return answer;
}

int main(void){
    int x,y;
    scanf("%d",x);
    scanf("%d",y);
    solution(x,y);
}