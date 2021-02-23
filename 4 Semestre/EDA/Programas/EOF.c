#include <stdio.h>

int main(){
  int a, i = 0;
    while(1){
      if (scanf("%d", &a) == EOF){
          break;
      }
      i++;
  }
printf("%d\n", i);

return 0;
}