#include <stdio.h>
#include <stdlib.h>

typedef struct QUEUE{
	float Valor;
	int Codigo;
	struct QUEUE* proximo;
}queue;


void Menu(queue* pPilha);
void PegarDados(float* pValor, int* pCodigo);
void InsereElementoFinal(queue** s, float* pValor, int* pCodigo);
void RemoveElementoFinal(queue** s);
void ImprimeLista(queue* s);
void RemoveElementoInicio(queue** s);
void InsereElementoInicio(queue** s, float* pValor, int* pCodigo);
void RemoveElementoMeio(queue** s, int* pCodigo);
void InsereElementoMeio(queue** s, float* pValor, int* pCodigo);


void main(){
	queue* pPilha = NULL;
	Menu(pPilha);
}

void Menu(queue* pPilha){
	int opcao = 0;
	float Valor;
	int Codigo;
	
	while(opcao != 8){
		printf("\t\tSELECIONE UMA OPCAO\n");
		printf(" 1- Inserir elemento no final\n");
		printf(" 2- Remover elemento do final\n");
		printf(" 3- Inserir elemento no inicio\n");
		printf(" 4- Remover elemento do inicio\n");
		printf(" 5- Inserir elemento no meio\n");
		printf(" 6- Remover elemento do meio\n");
		printf(" 7- Imprimir Lista\n");
		printf(" 8- Sair\n");
		printf(" OPCAO: ");
		scanf("%d",&opcao);
		
		if(opcao == 1){
			PegarDados(&Valor, &Codigo);
			InsereElementoFinal((queue**)&pPilha, &Valor, &Codigo);
			
		}else if(opcao == 2){
			RemoveElementoFinal(&pPilha);
			
		}else if(opcao == 3){
			PegarDados(&Valor, &Codigo);
			InsereElementoInicio((queue**)&pPilha, &Valor, &Codigo);
			
		}else if(opcao == 4){
			RemoveElementoInicio(&pPilha);
			
		}else if(opcao == 5){	
			PegarDados(&Valor, &Codigo);
			InsereElementoMeio(&pPilha,&Valor, &Codigo);
			
		}else if(opcao == 6){
			printf("Informe o codigo a ser removido: ");
			scanf("%d", &Codigo);
			RemoveElementoMeio(&pPilha, &Codigo);
			
		}else if(opcao == 7){
			ImprimeLista(pPilha);
		}
	}
}

void PegarDados(float* pValor, int* pCodigo){
	printf("Informe o codigo: ");
	scanf("%d", pCodigo);
	
	printf("Informe o Valor: ");
	scanf("%f", pValor);
}

void InsereElementoFinal(queue** s, float* pValor, int* pCodigo){
	queue* NovoElemento = NULL;

	NovoElemento = (queue*) calloc(1, sizeof(queue));
	NovoElemento->Codigo = *pCodigo;
	NovoElemento->Valor = *pValor;

	if(*s == NULL)	{
		*s = NovoElemento;
	}else{
		queue* pAux = *s;
		
		//for(; pAux->proximo; pAux=pAux->proximo);
		while(pAux->proximo != NULL){
			pAux = pAux->proximo;
		}
		pAux->proximo = NovoElemento;
	}
}
void RemoveElementoFinal(queue** s){

	queue* pAux = *s;
	queue* pAux2 = NULL;

	if((pAux == NULL) || (pAux->proximo == NULL)){
		RemoveElementoInicio(s);
	}else{
		while(pAux->proximo != NULL){
			pAux2 = pAux;
			pAux = pAux->proximo;
		}
		pAux2->proximo = NULL;
		free(pAux);
	}
}

void ImprimeLista(queue* s){
	queue* pAux = s;

	printf(" ============== LISTA ==============\n");
	
	while(pAux != NULL){
		printf("\t%d - %0.2f\n", pAux->Codigo, pAux->Valor);
		pAux = pAux->proximo;
	}
	printf(" ===================================\n");
}

void RemoveElementoInicio(queue** s){
	queue* pAux = *s;
	if (pAux != NULL){
		*s = pAux->proximo;
		free(pAux);
	}
}
void InsereElementoInicio(queue** s, float* pValor, int* pCodigo){

	queue* pAux = (queue*) calloc(1, sizeof(queue));
	
	pAux->Valor = *pValor;
	pAux->Codigo = *pCodigo;

	pAux->proximo=*s;
	
	*s = pAux;
}

void RemoveElementoMeio(queue** s, int* pCodigo){
	queue* pAux = *s;
	
	if(pAux == NULL || pAux->proximo == NULL){
		RemoveElementoFinal(s);

	}else{
		queue* pAux2 = NULL;
	
		while(pAux != NULL){
			if(pAux->Codigo == *pCodigo){
				if(pAux2 == NULL){
					RemoveElementoInicio(s);
					
				}else if(pAux->proximo == NULL){
					RemoveElementoFinal(s);
					
				}else{
					pAux2->proximo = pAux->proximo;
					free(pAux);
				}
				
				break;
			}else{
				pAux2 = pAux;
				pAux = pAux->proximo;
			}
		
		}
		
		pAux = pAux2;
	}
}

void InsereElementoMeio(queue** s, float* pValor, int* pCodigo){
	queue* pAux = *s;
	if(pAux == NULL || pAux->proximo == NULL){
		InsereElementoFinal((queue**)s, pValor, pCodigo);
	}else{
				
		
		queue* pAux2 = NULL;
		queue* NovoElemento = (queue*) calloc(1, sizeof(queue));
	
		while(pAux != NULL){
	
			if(*pCodigo < pAux->Codigo){
				if(pAux2 == NULL){
					InsereElementoInicio(s,pValor,pCodigo);
				}else{
					NovoElemento->Valor = *pValor;
					NovoElemento->Codigo = *pCodigo;
					NovoElemento->proximo=pAux2->proximo;
					pAux2->proximo = NovoElemento;
					pAux = pAux2;
				}
				break;
			}else if(pAux->proximo == NULL){
				InsereElementoFinal((queue**)s, pValor, pCodigo);
				break;
			}else{
				pAux2 = pAux;
				pAux = pAux->proximo;
			}
		}
	}
}