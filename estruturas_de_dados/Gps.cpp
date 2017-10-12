#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "Estruturas.h"

void Insere(queue** s, TPdi Ponto);
void Remove(queue** s, TPdi* pPonto);
void Lista(queue* s, EVisitado Visitado_ou_Nao);
void MarcaDesmarcaVisitado(queue** s, char* pNome, EVisitado Visitado_ou_Nao);

void PegaDados(TPdi* Ponto);
void ImprimeListaCompleta(queue* s);


void main(){
	queue* pstPontos = NULL;
	TPdi Ponto;
	int opcao = 0;
	
	while(opcao != 8){

		printf("\t\tSELECIONE UMA OPCAO\n");
		printf(" 1- Inserir Ponto\n");
		printf(" 2- Remover Ponto\n");
		printf(" 3- Marcar Ponto\n");
		printf(" 4- Desmarcar Ponto\n");
		printf(" 5- Mostrar Lista Completa\n");
		printf(" 6- Mostrar Lista Visitados\n");
		printf(" 7- Mostrar Lista Nao Visitados\n");
		printf(" 8- Sair\n");
		printf(" OPCAO: ");
		scanf("%d", &opcao);

		if(opcao == 1){
			PegaDados(&Ponto);
			Insere(&pstPontos, Ponto);
		}else if(opcao == 2){
			Remove(&pstPontos, &Ponto);
			
			printf("PONTO QUE FOI REMOVIDO\n");
			printf("  Latitude; %.5f\t",Ponto.Latitude);
			printf("Longitude; %.5f\t",Ponto.Longitude);
			printf("Nome; %s\t",Ponto.Nome);
			printf("Visitado; %d\n",Ponto.Visitado);

		}else if(opcao == 3){
			char Nome[50];
			printf("Informe o nome do Ponto visitado: ");
			fflush(stdin);
			scanf("%s", Nome);
			fflush(stdin);
			MarcaDesmarcaVisitado(&pstPontos, Nome, Visitado);

		}else if(opcao == 4){
			char Nome[50];
			printf("Informe o nome do Ponto a ser desmarcado: ");
			fflush(stdin);
			scanf("%s", Nome);
			fflush(stdin);
			MarcaDesmarcaVisitado(&pstPontos, Nome, NaoVisitado);
		}else if(opcao == 5){
			ImprimeListaCompleta(pstPontos);
		}else if(opcao == 6){
			Lista(pstPontos, Visitado);
		}else if(opcao == 7){
			Lista(pstPontos, NaoVisitado);
		}
	}
}


void PegaDados(TPdi* Ponto){
	

	printf("Latitude: ");
	scanf("%f", &Ponto->Latitude);
	
	printf("Longitude: ");
	scanf("%f", &Ponto->Longitude);

	printf("Nome: ");
	fflush(stdin);
	scanf("%s",&Ponto->Nome);
	fflush(stdin);
	Ponto->Visitado = NaoVisitado;

}

void Insere(queue** s, TPdi Ponto){

	queue* pAux = (queue*) calloc(1, sizeof(queue));
	
	pAux->Ponto_de_Interesse = Ponto;
	pAux->prox = *s;
	
	*s = pAux;
}

void ImprimeListaCompleta(queue* s){
	queue* pAux = s;

	printf(" ============== LISTA ==============\n");
	
	while(pAux != NULL){
		printf("Latitude; %.5f\t",pAux->Ponto_de_Interesse.Latitude);
		printf("Longitude; %.5f\t",pAux->Ponto_de_Interesse.Longitude);
		printf("Nome; %s\t",pAux->Ponto_de_Interesse.Nome);
		if(pAux->Ponto_de_Interesse.Visitado == Visitado){
				printf("Visitado: SIM \n");
			}else{
				printf("Visitado: NAO \n");
			}
		pAux = pAux->prox;
	}
	printf(" ===================================\n");
}

void Remove(queue** s, TPdi* pPonto){
	queue* pAux = *s;
	if (pAux != NULL){
		*pPonto = pAux->Ponto_de_Interesse;
		*s = pAux->prox;
		free(pAux);
	}
}

void MarcaDesmarcaVisitado(queue** s, char* pNome, EVisitado Visitado_ou_Nao){
	queue* pAux = *s;
	
	if(pAux == NULL ){
		printf("Nao ha pontos para remover");

	}else{
		bool bSai = false;
		while((pAux != NULL) && (!bSai)){
			if(strcmp(pAux->Ponto_de_Interesse.Nome,pNome) == 0){
				pAux->Ponto_de_Interesse.Visitado = Visitado_ou_Nao;
				bSai = true;
			}
			pAux = pAux->prox;
		}
	}

}

void Lista(queue* s, EVisitado Visitado_ou_Nao){
	queue* pAux = s;

	printf(" ============== LISTA ==============\n");
	
	while(pAux != NULL){
		if(pAux->Ponto_de_Interesse.Visitado == Visitado_ou_Nao){
			printf("Latitude: %.5f\t",pAux->Ponto_de_Interesse.Latitude);
			printf("Longitude: %.5f\t",pAux->Ponto_de_Interesse.Longitude);
			printf("Nome: %s\t",pAux->Ponto_de_Interesse.Nome);
			if(pAux->Ponto_de_Interesse.Visitado == Visitado){
				printf("Visitado: SIM \n");
			}else{
				printf("Visitado: NAO \n");
			}
		}
		pAux = pAux->prox;
	}
	printf(" ===================================\n");
}
