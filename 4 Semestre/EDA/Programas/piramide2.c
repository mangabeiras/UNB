#include <stdio.h>

int main(){
    int linhas, contador = 1;

    scanf("%d", &linhas);

    for (int i = 0; i < linhas; i++){
        for (int aux = 0; aux < contador; aux++){
            printf("*");
        }
        printf("\n");
        contador += 2;
    }


    return 0;
}