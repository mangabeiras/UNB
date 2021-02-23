#include <stdio.h>

struct tipoFiliacao{
    char nome[80], nomeMae[80], nomePai[80];
};

struct tipoFiliacao separaLinhaCSV(char linha[240]){
    struct tipoFiliacao dados;
    int posV[2], cont=0, cont1=0;
    startVector(dados);
    for (int i = 0; i < tamStr(linha); i++){
        if (linha[i] == ','){
            posV[cont++] = i;
        }
    }
    cont = 0;

    for (int i = 0; i < tamStr(linha); i++){
        if (i < posV[0])
            dados.nome[i] = linha[i];
        else if (i < posV[1] && i > posV[0])
            dados.nomeMae[cont++] = linha[i];
        else if (i > posV[1])
            dados.nomePai[cont1++] = linha[i];
    }
    dados.nomeMae[posV[1] - posV[0] - 1] = '\0';
    dados.nome[posV[0]] = '\0';
    dados.nomePai[cont1] = '\0';


    return dados;
}
void startVector(struct tipoFiliacao dados){
    for (int i = 0; i < 80; i++){
        dados.nome[i] = 0;
        dados.nomeMae[i] = 0;
        dados.nomePai[i] = 0;
    }
}

int tamStr(char linha[240]){
    int cont = 0;
    while (linha[cont++] != '\0');
    return cont-1;
}