#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "LoucuradoPC.h"

int Menu();
void GetRegistradores(Registradores* registrador);
void GetFile(char* pFileName, int* pSize);
void GetMemoria(DOUBLEQUEUEPROCESSOR* pQueueProcessor, Memory* memoria);
void InicializaPilha(StackRegs* pPilha);
void PreenchePilha(StackRegs* pPilha);
int EncontraProcesso(DOUBLEQUEUEPROCESSOR* pQueueProcessor, int* pProcessorId, int* pEscolha);

void InsertDoubleQueue(DOUBLEQUEUEPROCESSOR** pQueueProcessor, int* pProcessorId, Memory* memoria, StackRegs* pPilha, FileQueue* pLista);
void InsertQueue(FILEQUEUE** pFileQueue, char* pFileName, int* pSize);

int RemoveDoubleQueue(DOUBLEQUEUEPROCESSOR** pQueueProcessor, int* pProcessorId);
int RemoveQueue(FileQueue** pLista, char* pFileName);

void ExibeDoubleQueue(DOUBLEQUEUEPROCESSOR* pQueueProcessor);
void ExibeStackRegs(StackRegs* pPilha);
void ExibeFileQueue(FILEQUEUE* pFileQueue);

int RemoveDaPilha(StackRegs* pPilha, int* pIndice);
void push(StackRegs* pPilha, Registradores* registrador);
Registradores pop(StackRegs* pPilha);
Registradores top(StackRegs* pPilha);

void main() {
	DOUBLEQUEUEPROCESSOR* pQueueProcessor = NULL;
	int IdProcesso = 0;
	int opcao = Menu();

	while (opcao != 6) {
		if(opcao == 1){
			ExibeDoubleQueue(pQueueProcessor);

		}else if (opcao == 2) {
			StackRegs pPilha;
			InicializaPilha(&pPilha);
			FileQueue* pLista = NULL;
			Memory Memoria;
			memset(&Memoria, 0, sizeof(Memory));

			while (opcao != 3) {
				printf("\n 1)Inserir Registrador\n");
				printf(" 2)Inserir Novo Arquivo\n");
				printf(" 3)Gravar Processo\n");
				printf(" Opcao: ");
				scanf("%d", &opcao);

				if (opcao == 1) {
					PreenchePilha(&pPilha);

				}else if (opcao == 2) {
					char FileName[255];
					int pSize = 0;
					GetFile(FileName, &pSize);
					InsertQueue(&pLista, FileName, &pSize);

				}else if (opcao == 3) {
					printf("\nInforme o id do processo: ");
					scanf("%d", &IdProcesso);
					Memoria.nTotalMemory = sizeof(int) + sizeof(Memory) + sizeof(StackRegs) + sizeof(FileQueue) + sizeof(DOUBLEQUEUEPROCESSOR);
					GetMemoria(pQueueProcessor, &Memoria);
					Memoria.nTotalUsage += Memoria.nTotalMemory;
					InsertDoubleQueue(&pQueueProcessor, &IdProcesso, &Memoria, &pPilha, pLista);
					IdProcesso++;
				}
			}
			IdProcesso++;

		}else if (opcao == 3) {

			if (pQueueProcessor == NULL) {
				printf("\n\tNAO HA PROCESSOS\n");

			}else {
				printf("\nInforme o id do processo a ser removido: ");
				scanf("%d", &IdProcesso);
				
				if (RemoveDoubleQueue(&pQueueProcessor, &IdProcesso) == 1) {
					printf("\n\tPROCESSO REMOVIDO\n");
				}else {
					printf("\n\tPROCESSO NAO ENCONTRADO\n");
				}
			}

		}else if (opcao == 4) {
			
			if (pQueueProcessor != NULL) {
				
				printf("Informe o IdProcesso: ");
				scanf("%d", &IdProcesso);
				
				opcao = EncontraProcesso(pQueueProcessor, &IdProcesso, &opcao);

				if (opcao == 0) {
					printf("\n\t ITEM REMOVIDO\n");
				}else if (opcao == 1) {
					printf("\n\tITEM NAO ENCONTRADO NESTE PROCESSO\n");
				}else if (opcao == 5) {
					printf("\n\tNAO EXISTEM ARQUIVOS NESTE PROCESSO\n");
				}


			}else {
				printf("\n\tNAO HA PROCESSOS\n");
			}

		}else if (opcao == 5) {
			if (pQueueProcessor != NULL) {
				printf("Informe o IdProcesso: ");
				scanf("%d", &IdProcesso);

				opcao = EncontraProcesso(pQueueProcessor, &IdProcesso, &opcao);

				if (opcao == 0) {
					printf("\n\t ITEM REMOVIDO\n");
				}
				else if (opcao == 1) {
					printf("\n\tITEM NAO ENCONTRADO NESTE PROCESSO\n");
				}
				else if (opcao == 4) {
					printf("\n\tNAO EXISTEM REGISTROS NESTE PROCESSO\n");
				}
			}else {
				printf("\n\tNAO HA PROCESSOS\n");
			}

		}
		opcao = Menu();
	}
}

/******************************************************************************
*			Funções diversas
******************************************************************************/
int Menu() {
	int opcao = 0;
	printf("\n 1)Exibir Lista de processos\n");
	printf(" 2)Inserir Processo\n");
	printf(" 3)Remover Processo\n");
	printf(" 4)Remover File da lista do processo\n");
	printf(" 5)Remover Registrador da pilha do processo\n");
	printf(" 6)Sair");
	printf(" Opcao: ");
	scanf("%d", &opcao);
	return opcao;
}
void GetRegistradores(Registradores* registrador) {
	printf("\nRegistrador Ax: ");
	scanf("%d", &registrador->Ax);

	printf("Registrador Bx: ");
	scanf("%d", &registrador->Bx);

	printf("Registrador Cx: ");
	scanf("%d", &registrador->Cx);

	printf("Registrador Dx: ");
	scanf("%d", &registrador->Dx);

}

void GetFile(char* pFileName, int* pSize) {
	memset(pFileName, 0, sizeof(char));
	printf("Informe o Nome do arquivo sem espaco: ");
	scanf("%s", pFileName);

	printf("Informe o tamanho do arquivo: ");
	scanf("%d", pSize);
}

void PreenchePilha(StackRegs* pPilha) {
	Registradores Registrador;
	memset(&Registrador, 0, sizeof(Registradores));
	GetRegistradores(&Registrador);
	push(pPilha, &Registrador);
}

void GetMemoria(DOUBLEQUEUEPROCESSOR* pQueueProcessor, Memory* memoria) {
	DOUBLEQUEUEPROCESSOR* pAux = pQueueProcessor;
	while (pAux != NULL) {
		memoria->nTotalUsage += memoria->nTotalMemory;
		pAux->stMemory.nTotalUsage += memoria->nTotalMemory;
		pAux = pAux->next;
	}
}

int EncontraProcesso(DOUBLEQUEUEPROCESSOR* pQueueProcessor, int* pProcessorId, int* pEscolha) {

	DOUBLEQUEUEPROCESSOR* pAux = pQueueProcessor;

	if (*pEscolha == 4) {
		char FileName[255];
		memset(FileName, 0, sizeof(char));

		printf("Informe o nome do arquivo a ser removido: ");
		scanf("%s", &FileName);

		while (pAux != NULL && *pEscolha == 4) {
			if (pAux->ProcessorId == *pProcessorId) {
				if (pAux->stFileQueue != NULL) {
					*pEscolha = RemoveQueue(&pAux->stFileQueue, FileName);
				}else {
					*pEscolha = 5;
				}
			}else {
				pAux = pAux->next;
			}
		}
	}else if (*pEscolha == 5) {
		int indice = 0;
		printf("Informe o indice da pilha a ser removida: ");
		scanf("%d", &indice);

		while (pAux != NULL && *pEscolha == 5) {
			if (pAux->ProcessorId == *pProcessorId) {
				if (pAux->stRegisters.nIndex > -1) {
					*pEscolha = RemoveDaPilha(&pAux->stRegisters, &indice);
				}else {
					*pEscolha = 4;
				}
			}
			else {
				pAux = pAux->next;
			}
		}
	}
	return *pEscolha;
}

/******************************************************************************
*			Funções de lista duplamente encadeada
******************************************************************************/

void InsertDoubleQueue(DOUBLEQUEUEPROCESSOR** pQueueProcessor, int* pProcessorId, Memory* memoria, StackRegs* pPilha, FileQueue* pLista) {

	DOUBLEQUEUEPROCESSOR* NovoElemento = (DOUBLEQUEUEPROCESSOR*)calloc(1, sizeof(DOUBLEQUEUEPROCESSOR));

	memcpy(&NovoElemento->ProcessorId, pProcessorId, (sizeof(int)));
	memcpy(&NovoElemento->stMemory, memoria, (sizeof(Memory)));
	memcpy(&NovoElemento->stRegisters, pPilha, (sizeof(StackRegs)));
	NovoElemento->stFileQueue = pLista;

	if (!*pQueueProcessor) {
		*pQueueProcessor = NovoElemento;
	}
	else {
		DOUBLEQUEUEPROCESSOR* pAux = *pQueueProcessor;
		int parar = 0;

		while (pAux != NULL && parar == 0) {
			if (pAux->prior == NULL && *pProcessorId < pAux->ProcessorId) {
				pAux->prior = NovoElemento;
				NovoElemento->next = pAux;
				*pQueueProcessor = NovoElemento;
				parar = 1;

			}else if (pAux->next == NULL) {
				if (pAux->ProcessorId < *pProcessorId) {
					pAux->next = NovoElemento;
					NovoElemento->prior = pAux;
					parar = 1;
				}

			}else {
				if (pAux->ProcessorId < *pProcessorId && *pProcessorId < pAux->next->ProcessorId) {
					NovoElemento->next = pAux->next;
					NovoElemento->prior = pAux;
					pAux->next = NovoElemento;
					pAux->next->prior = NovoElemento;
					parar = 1;
				}
			}

			pAux = pAux->next;
		}
	}
}

int RemoveDoubleQueue(DOUBLEQUEUEPROCESSOR** pQueueProcessor, int* pProcessorId) {

	DOUBLEQUEUEPROCESSOR* pAux = *pQueueProcessor;
	int parar = 0;

	if (pAux->next == NULL && pAux->prior == NULL && *pProcessorId == pAux->ProcessorId) {
		free(pAux);
		*pQueueProcessor = NULL;
		parar = 1;
	}
	else if (*pProcessorId == pAux->ProcessorId && pAux->prior == NULL) {
		*pQueueProcessor = pAux->next;
		free(pAux);
		(*pQueueProcessor)->prior = NULL;
		parar = 1;
	}
	else {

		DOUBLEQUEUEPROCESSOR* pAux2 = pAux;
		while (pAux != NULL && parar == 0) {

			if (*pProcessorId == pAux->ProcessorId && pAux->next == NULL) {
				free(pAux);
				pAux = pAux2;
				pAux->next = NULL;
				parar = 1;
			}
			else if (pAux->ProcessorId == *pProcessorId) {
				pAux2->next = pAux->next;
				pAux2->next->prior = pAux2;
				free(pAux);
				pAux = pAux2;
				parar = 1;
			}
			else {
				pAux2 = pAux;
				pAux = pAux->next;
			}
		}
	}
	return parar;
}

/******************************************************************************
*			Funções de lista simplesmente encadeada
******************************************************************************/

void InsertQueue(FILEQUEUE** pFileQueue, char* pFileName, int* pSize) {
	FILEQUEUE* NovoElemento = NULL;
	FILEQUEUE* pAux = *pFileQueue;

	NovoElemento = (FILEQUEUE*)calloc(1, sizeof(FILEQUEUE));
	strcpy(NovoElemento->Filename, pFileName);
	NovoElemento->nSize = *pSize;

	if (pAux == NULL) {
		*pFileQueue = NovoElemento;
	}else {
		
		while (pAux->prox != NULL) {
			pAux = pAux->prox;
		}
		pAux->prox = NovoElemento;
	}
}

int RemoveQueue(FileQueue** pLista, char* pFileName) {

	FileQueue* pAux = *pLista;
	int parar = 1;

	if (pAux == NULL || pAux->prox == NULL && strcmp(pAux->Filename, pFileName) == 0) {
		free(pAux);
		*pLista = NULL;
		parar = 0;
	}
	else {
		FileQueue* pAux2 = NULL;

		while (pAux != NULL && parar == 1) {
			if (strcmp(pAux->Filename,pFileName) == 0) {
				if (pAux2 == NULL) {
					*pLista = pAux->prox;
					free(pAux);
					parar = 0;

				}else if (pAux->prox == NULL) {
					pAux2->prox = NULL;
					free(pAux);
					parar = 0;

				}else {
					pAux2->prox = pAux->prox;
					free(pAux);
					parar = 0;
				}
			}else {
				pAux2 = pAux;
				pAux = pAux->prox;
			}
		}
		pAux = pAux2;
	}
	
	return parar;
}
/******************************************************************************
*			Funções para exibir na tela
******************************************************************************/

void ExibeDoubleQueue(DOUBLEQUEUEPROCESSOR* pQueueProcessor) {

	DOUBLEQUEUEPROCESSOR* pAux = pQueueProcessor;

	printf("================================LISTA================================\n");

	while (pAux != NULL) {
		printf("ProcessorID: %d\n", pAux->ProcessorId);
		printf("Memoria Total Processo: %d\n", pAux->stMemory.nTotalMemory);
		printf("Memoria Total Usada: %d\n", pAux->stMemory.nTotalUsage);
		printf("\tREGISTRADORES\n");
		
		ExibeStackRegs(&pAux->stRegisters);
		ExibeFileQueue(pAux->stFileQueue);

		pAux = pAux->next;
	}
	printf("=====================================================================\n");
}

void ExibeStackRegs(StackRegs* pPilha) {

	if (pPilha->nIndex > -1) {
		for (int i = pPilha->nIndex; i >= 0; i--) {
			printf("\tPILHA[%d] ->\tAx: %d\t- Bx:%d\t- Cx:%d\t- dx:%d\n", i, pPilha->stRegs[i].Ax, pPilha->stRegs[i].Bx, pPilha->stRegs[i].Cx, pPilha->stRegs[i].Dx);
		}

	}else {
		printf("\tSem Registradores na Pilha\n");
	}
}

void ExibeFileQueue(FILEQUEUE* pFileQueue) {
	
	FILEQUEUE* pAux = pFileQueue;

	printf("\n\tARQUIVOS\n");

	if (pAux == NULL) {
		printf("\tSem Arquivos na lista\n");
	}else {
		while (pAux != NULL) {
			printf("\tFile Name: %s\t\t Size: %d\n", pAux->Filename, pAux->nSize);
			pAux = pAux->prox;
		}
	}
}

/******************************************************************************
*			Funções de pilha
******************************************************************************/

void InicializaPilha(StackRegs* pPilha) {
	memset(pPilha, 0, sizeof(StackRegs));
	pPilha->nIndex = -1;
}

void push(StackRegs* pPilha, Registradores* registrador) {
	memcpy(&pPilha->stRegs[++pPilha->nIndex], registrador, (sizeof(Registradores)));
}

Registradores top(StackRegs* pPilha) {
	return pPilha->stRegs[pPilha->nIndex];
}

Registradores pop(StackRegs* pPilha) {
	return pPilha->stRegs[pPilha->nIndex--];
}

int RemoveDaPilha(StackRegs* pPilha, int* pIndice) {

	StackRegs Pilha;
	InicializaPilha(&Pilha);

	int i = pPilha->nIndex;
	int encontrado = 1;

	for (; i >= 0 && encontrado == 1; i--) {
		if (i == *pIndice) {
			pop(pPilha);
			encontrado = 0;
		}else {
			push(&Pilha, &pop(pPilha));
		}
	}

	i = Pilha.nIndex;
	for (; i >= 0; i--) {
		push(pPilha, &pop(&Pilha));
	}
	return encontrado;
}