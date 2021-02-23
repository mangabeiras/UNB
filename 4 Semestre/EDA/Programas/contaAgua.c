#include <stdio.h>

int main(){
    int litros, valor=7;

    scanf("%d", &litros);

    for (int i = 11; i <= litros; i++){
        if (i <= 30){
            valor += 1;
        }
        else if (i <= 100){
            valor += 2;
        }
        else
            valor += 5;
    }

    printf("%d\n", valor);

    return 0;
}