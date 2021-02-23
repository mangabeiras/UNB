#include <stdio.h>

int main(){
    int numP, cont=1;
    do{
        int num1, num2;
        char name1[14], name2[14];
        
        scanf("%d", &numP);
        if (numP == 0)
            break;
        
        scanf("%s %s", &name1, &name2);
        printf("Teste %d\n", cont++);
        for (int i = 0; i < numP; i++){
            scanf("%d %d", &num1, &num2);            
            if ((num1 + num2)%2 == 0)
                printf("%s\n", name1);
            else
                printf("%s\n", name2);
        }
        printf("\n");
    } while(numP != 0);

    return 0;
}