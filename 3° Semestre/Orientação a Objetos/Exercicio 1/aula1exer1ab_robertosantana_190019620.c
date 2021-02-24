#include <stdio.h>
const int MAX = 3;
int main()
{
/*Atributos*/
	float altura1, altura2, altura3, mediaAlturas;
	altura1 = 1.58;
	altura2 = 2.07;
	altura3 = 0.55;
/*Metodos*/
mediaAlturas = (altura1 + altura2 + altura3)/MAX;

	printf("%.3f", mediaAlturas);


return 0;

}
