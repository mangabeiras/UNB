#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Partida
{
    struct Rodada *rodada;
    char nome1[10], nome2[10];
    int qtdRodadas; 
};

struct Rodada
{
    char vencedor[10];
};


int main(){
    struct Partida *teste;
    int lido, i = 0, num1, num2, contP=0;

    scanf("%d", &lido);

    while (lido != 0){    
        teste = (struct Partida *) realloc(teste, (i+1)*sizeof(struct Partida));
        teste[i].rodada = (struct Rodada *) malloc(lido * sizeof(struct Rodada));

        scanf("%s %s", &teste[i].nome1, &teste[i].nome2);
        for (int aux = 0; aux < lido; aux++){
            scanf("%d %d", &num1, &num2);
            if ((num1 + num2)%2 == 0)
                strcpy(teste[i].rodada[aux].vencedor, teste[i].nome1);
            else
                strcpy(teste[i].rodada[aux].vencedor, teste[i].nome2);

            teste[i].qtdRodadas++;
        }
        i++;
        scanf("%d", &lido);
        contP++;
    }
    
    for (int aux = 0; aux < contP; aux++){
        printf("Teste %d\n", aux+1);
        for (int j = 0; j < teste[aux].qtdRodadas; j++){
           printf("%s\n", teste[aux].rodada[j].vencedor);
        }
    }
    return 0;
}
