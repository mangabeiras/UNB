#include <stdio.h>

int main(){
    int num[4];
    int maior = 0;

    scanf("%d %d %d %d", &num[0], &num[1], &num[2], &num[3]);

    for (int i = 0; i < 4; i++){
        if (num[i] > maior){
            maior = num[i];
        }
    }

    printf("%d\n", maior);

    return 0;
}