#include <stdio.h>
#include <string.h>

#define MAX 1000

int main(){
	int qtd_partidas, qtd_A, qtd_B, contadorPartidas = 1, contadorJogadas = 0;
	char jogadorUM [10], jogadorDOIS [10], vencedor[MAX][10];

	scanf ("%d", &qtd_partidas);
	
	while(qtd_partidas != 0){
		scanf ("%s", jogadorUM);
		scanf ("%s", jogadorDOIS);
		
		for (int aux = 0; aux < qtd_partidas; aux++){
			scanf ("%d %d", &qtd_A, &qtd_B);
			
			if ((qtd_A + qtd_B) % 2 == 0){ //numero par
				strcpy(vencedor[aux + contadorJogadas], jogadorUM);
			} else{
				strcpy(vencedor[aux + contadorJogadas], jogadorDOIS);
			}
				
		}
		
		printf("Teste %d\n", contadorPartidas);
		for (int aux2 = 0; aux2 < qtd_partidas; aux2++){
			printf ("%s\n", vencedor[aux2+contadorJogadas]);
		}		
		
		contadorJogadas += qtd_partidas;
		contadorPartidas++;
		
		scanf ("%d", &qtd_partidas);
        printf("\n");
	}
	
	return 0;
}