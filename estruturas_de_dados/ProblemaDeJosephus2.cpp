#include <stdio.h>
#include <stdlib.h>
/*
* Problema de Josephus
* Lourival Costa da Silva
*/
typedef struct{
	char Nome[20];
	int numero;
}Soldado;

typedef struct QUEUE{
	Soldado soldado;
	struct QUEUE* proximo;
}queue;

void Menu(queue* pPilha);
void PegarDados(Soldado* pSoldado);
void InsereElementoFinal(queue** s, Soldado *pSoldado);
void RemoveElementoFinal(queue** s);
void ImprimeLista(queue* s);
void RemoveElementoInicio(queue** s);
void InsereElementoInicio(queue** s, Soldado* pSoldado);
void RemoveElementoMeio(queue** s, Soldado* pSoldado);
void InsereElementoMeio(queue** s, Soldado* pSoldado);
void ListaCircular(queue** s);
void RemoveSoldado(queue** s);

void main(){
	queue* pPilha = NULL;
	Menu(pPilha);
}


void Menu(queue* pPilha){
	int opcao = 0;
	
	Soldado sol;

	while(opcao != 5){
		printf(" 1- Inserir soldado \n");
		printf(" 2- Remover soldado\n");
		printf(" 3- Imprimir Lista\n");
		printf(" 4- Tornar Lista circular\n");
		printf(" 5- Sair\n");
		printf(" OPCAO: ");
		scanf("%d",&opcao);

		if(opcao == 1){
			PegarDados(&sol);
			InsereElementoFinal(&pPilha, &sol);
		}else if(opcao == 2){
			RemoveSoldado(&pPilha);
		}else if(opcao == 3){
			ImprimeLista(pPilha);
		}else if(opcao == 4){
			ListaCircular(&pPilha);
		}
	}

}
void PegarDados(Soldado* pSoldado){
	printf("Informe o nome da pessoa: ");
	scanf("%s",&pSoldado->Nome);
	printf("Informe o numero da pessoa: ");
	scanf("%d", &pSoldado->numero);
	fflush(stdin);
}

void InsereElementoFinal(queue** s, Soldado* pSoldado){
	queue* NovoElemento = NULL;

	NovoElemento = (queue*) calloc(1, sizeof(queue));
	NovoElemento->soldado = *pSoldado;

	if(*s == NULL)	{
		*s = NovoElemento;
	}else{
		queue* pAux = *s;
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

void RemoveElementoInicio(queue** s){
	queue* pAux = *s;
	if (pAux != NULL){
		*s = pAux->proximo;
		free(pAux);
	}
}

void InsereElementoInicio(queue** s, Soldado* pSoldado){
	queue* pAux = (queue*) calloc(1, sizeof(queue));
	
	pAux->soldado = *pSoldado;

	pAux->proximo=*s;
	
	*s = pAux;
}

void RemoveElementoMeio(queue** s, Soldado* pSoldado){
	queue* pAux = *s;
	
	if(pAux == NULL || pAux->proximo == NULL){
		RemoveElementoFinal(s);

	}else{
		queue* pAux2 = NULL;
	
		while(pAux != NULL){

			if(pAux->soldado.numero == pSoldado->numero){
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

void InsereElementoMeio(queue** s, Soldado* pSoldado){
	queue* pAux = *s;
	if(pAux == NULL || pAux->proximo == NULL){
		InsereElementoFinal((queue**)s, pSoldado);
	}else{
				
		
		queue* pAux2 = NULL;
		queue* NovoElemento = (queue*) calloc(1, sizeof(queue));
	
		while(pAux != NULL){
	
			if(pSoldado->numero < pAux->soldado.numero){
				if(pAux2 == NULL){
					InsereElementoInicio(s, pSoldado);
				}else{
					NovoElemento->soldado = *pSoldado;
					NovoElemento->proximo=pAux2->proximo;
					pAux2->proximo = NovoElemento;
					pAux = pAux2;
				}
				break;
			}else if(pAux->proximo == NULL){
				InsereElementoFinal((queue**)s, pSoldado);
				break;
			}else{
				pAux2 = pAux;
				pAux = pAux->proximo;
			}
		}
	}
}

void ImprimeLista(queue* s){
	queue* pAux = s;

	printf(" ============== LISTA ==============\n");
	
	while(pAux != NULL){
		printf("Nome: %s\tNumero: %d\n",
			pAux->soldado.Nome,
			pAux->soldado.numero);
		pAux = pAux->proximo;
	}
	printf(" ===================================\n");
}

void ListaCircular(queue** s){

	queue* p = *s;

	while(p->proximo != NULL){

		p = p->proximo;
	}

	p->proximo = *s;

}

void RemoveSoldado(queue** s){
	queue* pAux = *s;
	queue* pAux2 = NULL;

	int cont = 0;
	int condicao = 2;

	while(pAux != pAux->proximo){
		cont++;
		
		if(cont == condicao){
			condicao = pAux->soldado.numero;
			printf("\nREMOVIDO\n");
			
			printf("Nome: %s\tNumero: %d",
			pAux->soldado.Nome,
			pAux->soldado.numero);

			cont = -1;
			pAux2->proximo = pAux->proximo;
			free(pAux);
			pAux = pAux2;
		}else{
			pAux2 = pAux;
			pAux = pAux->proximo;
		}

	}

	printf("\n\n\t RESTANTE\n");
	printf("Nome: %sNumero: %d\n",
			pAux->soldado.Nome,
			pAux->soldado.numero);

	*s = pAux;

}