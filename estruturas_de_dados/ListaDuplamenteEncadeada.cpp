#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TAM 30

typedef struct SPROCESSO
{
	long NumeroProcesso;
	char Autor[TAM];
	char Reu[TAM];
	float Valor;
}SProcesso;

typedef struct DEQUE
{
	SProcesso stProcesso;
	struct DEQUE* anterior;
	struct DEQUE* proximo;
}SDeque;

void InsereMeio(SDeque** s, SProcesso* pProcesso);
int RemoveMeio(SDeque** s, SProcesso* pProcesso);

void ImprimeLista(SDeque*s);
void Menu(SDeque* pListaDeProcessos, SProcesso* pProcesso);
void PegaDados(SProcesso* pProcesso);
void ExibeProcesso(SProcesso* pProcesso);

void main()
{
	SDeque* pListaDeProcessos = NULL;
	SProcesso stProcesso;

	memset(&stProcesso, 0, sizeof(SProcesso));

	Menu(pListaDeProcessos, &stProcesso);

}

void Menu(SDeque* pListaDeProcessos, SProcesso* pProcesso) {
	int opcao = 0;
	int num = 0;

	while (opcao != 4) {
		memset(pProcesso, 0, sizeof(SProcesso));

		printf("\n 1) Inserir Processo:\n");
		printf(" 2) Remover Processo:\n");
		printf(" 3) Exibir Processos:\n");
		printf(" 4) Sair:\n");
		printf(" Opcao: ");
		scanf("%d", &opcao);

		if (opcao == 1) {

			PegaDados(pProcesso);
			InsereMeio(&pListaDeProcessos, pProcesso);

		}else if (opcao == 2) {

			if (pListaDeProcessos != NULL) {
				printf("Informe o numero do processo: ");
				scanf("%d", &pProcesso->NumeroProcesso);

				if (RemoveMeio(&pListaDeProcessos, pProcesso) == 1 ) {
					printf("\n  PROCESSO REMOVIDO\n");
					ExibeProcesso(pProcesso);
				}else {
					printf("n\t PROCESSO NAO ENCONTRADO\n");
				}
			}
		}else if (opcao == 3) {
			ImprimeLista(pListaDeProcessos);
		}
	}
}

void PegaDados(SProcesso* pProcesso) {
	printf("Informe o numero do processo: ");
	scanf("%d", &pProcesso->NumeroProcesso);
	
	printf("Informe o autor do processo: ");
	scanf("%s", &pProcesso->Autor);

	printf("Informe o reu do processo: ");
	scanf("%s", &pProcesso->Reu);

	printf("Informe o valor do processo: ");
	scanf("%f", &pProcesso->Valor);

}

void ExibeProcesso(SProcesso* pProcesso) {
	printf("===============PROCESSO===============");
	printf("\nNumero do Processo: %d\n", pProcesso->NumeroProcesso);
	printf("Autor do Processo: %s\n", pProcesso->Autor);
	printf("Reu do Processo: %s\n", pProcesso->Reu);
	printf("Valor do Processo: %.2f\n", pProcesso->Valor);
	printf("======================================\n\n");
}

void InsereMeio(SDeque** s, SProcesso* pProcesso) {

	SDeque* NovoElemento = (SDeque*)calloc(1, sizeof(SDeque));

	memcpy(&NovoElemento->stProcesso, pProcesso, sizeof(SProcesso));

	if (!*s){
		*s = NovoElemento;
	}else{
		SDeque* pAux = *s;
		int parar = 0;

		while (pAux != NULL && parar == 0) {
			if (pAux->anterior == NULL && pProcesso->NumeroProcesso < pAux->stProcesso.NumeroProcesso) {
				pAux->anterior = NovoElemento;
				NovoElemento->proximo = pAux;
				*s = NovoElemento;
				parar = 1;

			}else if (pAux->proximo == NULL) {
				if (pAux->stProcesso.NumeroProcesso < pProcesso->NumeroProcesso) {
					pAux->proximo = NovoElemento;
					NovoElemento->anterior = pAux;
					parar = 1;
				}

			}else {
				if (pAux->stProcesso.NumeroProcesso < pProcesso->NumeroProcesso && pProcesso->NumeroProcesso < pAux->proximo->stProcesso.NumeroProcesso) {
					NovoElemento->proximo = pAux->proximo;
					NovoElemento->anterior = pAux;
					pAux->proximo = NovoElemento;
					pAux->proximo->anterior = NovoElemento;
					parar = 1;
				}
			}

			pAux = pAux->proximo;
		}
	}
}

int RemoveMeio(SDeque** s, SProcesso* pProcesso) {

	SDeque* pAux = *s;
	int parar = 0;

	if (pAux->proximo == NULL && pAux->anterior == NULL && pProcesso->NumeroProcesso == pAux->stProcesso.NumeroProcesso){
		memcpy(pProcesso, &pAux->stProcesso, sizeof(SProcesso));
		free(pAux);
		*s = NULL;
		parar = 1;
	}else if (pProcesso->NumeroProcesso == pAux->stProcesso.NumeroProcesso && pAux->anterior == NULL){
		memcpy(pProcesso, &pAux->stProcesso, sizeof(SProcesso));
		*s = pAux->proximo;
		free(pAux);
		(*s)->anterior = NULL;
		parar = 1;
	}else {
		
		SDeque* pAux2 = pAux;
		while (pAux != NULL && parar == 0) {

			if (pProcesso->NumeroProcesso == pAux->stProcesso.NumeroProcesso && pAux->proximo == NULL) {
				memcpy(pProcesso, &pAux->stProcesso, sizeof(SProcesso));
				free(pAux);
				pAux = pAux2;
				pAux->proximo = NULL;
				parar = 1;
			}else if (pAux->stProcesso.NumeroProcesso == pProcesso->NumeroProcesso) {
				memcpy(pProcesso, &pAux->stProcesso, sizeof(SProcesso));
				pAux2->proximo = pAux->proximo;
				pAux2->proximo->anterior = pAux2;
				free(pAux);
				pAux = pAux2;
				parar = 1;
			}
			else {
				pAux2 = pAux;
				pAux = pAux->proximo;
			}
		}
	}
	return parar;
}

void ImprimeLista(SDeque*s) {

	SDeque* pAux = s;

	printf("================================LISTA================================\n");

	while (pAux != NULL) {
		ExibeProcesso(&pAux->stProcesso);
		pAux = pAux->proximo;
	}
	printf("=====================================================================\n");
}