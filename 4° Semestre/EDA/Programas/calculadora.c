#include <stdio.h>

int main(){
    int numOp, cont=1;

    do {
        scanf("%d", &numOp);
        int nums, final = 0;

        if (numOp == 0)
            break;
        for (int i = 0; i < numOp; i++){
            scanf("%d", &nums);
            final += nums;
        }
        
        
        printf("Teste %d\n%d\n\n", cont++, final);        

    }   while(numOp != 0);

    return 0;
}