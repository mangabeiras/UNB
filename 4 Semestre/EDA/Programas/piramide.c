#include <stdio.h>

int main(){
    int linha;

    scanf("%d", &linha);

    for (int i = 1; i <= linha; i++){
        for (int aux = 0; aux < i; aux++){
            printf("%02d ", i);
        }
        printf("\n");
    }


    for (int i = 0; i <= linha; i++){
        for (int aux = 1; aux <= i; aux++){
            printf("%02d ", aux);
        }
        printf("\n");
    }


    return 0;
}