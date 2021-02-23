#include <stdio.h>

int main(){
    int lido, cont=0;
    int num1=0, num2 = 0;
    char nomePar[10], nomeImpar[10];

    scanf("%d", &lido);

    while (lido != 0){
        char (*resultado[10])[lido];

        scanf("%s %s", &nomePar, &nomeImpar);

        for (int aux = 0; aux < lido; aux++){
            scanf("%d %d", &num1, &num2);
            if ((num1 + num2) % 2 == 0)
                resultado[aux] = &nomePar;
            else
                resultado[aux] = &nomeImpar;
        }

        printf("Teste %d\n", ++cont);
        for (int aux = 0; aux < lido; aux++){
            printf("%s\n", resultado[aux]);
        }

        scanf("%d", &lido);
    }
    return 0;
}