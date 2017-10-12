/*
Lourival Costa da Silva
*/
#include <stdio.h>
#include <stdlib.h>
#include<string.h>

#define TamNomeVariavel 50
#define TamValorVariavel 150
#define TamNomeSecao 50
#define TamLinha 255

typedef struct {
	char NomeVariavel[TamNomeVariavel];
	char ValorVariavel[TamValorVariavel];
}Conteudo;

typedef struct QUEUE2 {
	Conteudo variavel;
	struct QUEUE2* proximo;

}variaveis;

typedef struct QUEUE {
	char Nome[TamNomeSecao];
	variaveis* Variaveis;
	struct QUEUE* proximo;
}queue;

void InsereSecao(queue** s, variaveis* variavel, char* pNome);
void InsereVariavel(variaveis** var, Conteudo* conteudo);
void PegaVariaveleValor(Conteudo* conteudo, char* pLinha, char* ch);
void ImprimeLista(queue* s);

int OpenFile(queue** pPilha, variaveis* pLista, char* pNomeArquivo);
void ReadInteger(queue*s, char* pNomeSecao, char* pNomeVariavel, int* pValorDefault);
void ReadString(queue*s, char* pNomeSecao, char* pNomeVariavel, char* pValorDefault);
void WriteInteger(queue** s, char* pNomeSecao, char* pNomeVariavel, int* pValorDefault);
void WriteString(queue** s, char* pNomeSecao, char* pNomeVariavel, char* pValorDefault);

void WriteFile(queue* s, char* NomeArquivo);

void Menu(queue* pPilha, variaveis* pLista);
void PegaDados(char* NomeSecao, char* NomeVariavel, char* ValorDefault);
void PegaVariavelSelecionada(queue* pPilha, char* pNomeSecao, Conteudo* pConteudo);
void AlteraVariavelSelecionada(queue** pPilha, char* pNomeSecao, Conteudo* pConteudo);


void main() {
	queue* pPilha = NULL;
	variaveis* pLista = NULL;
	
	Menu(pPilha,pLista);
}

void Menu(queue* pPilha, variaveis* pLista) {
	int ok = 0;
	int opcao = 0;
	char NomeArquivo[50];
	char NomeSecao[TamNomeSecao];
	char NomeVariavel[TamNomeVariavel];
	char ValorDefault[TamValorVariavel];

	while (opcao != 7) {

		printf("\n 1- Carregar arquivo\n");
		printf(" 2- Mostrar arquivo\n");
		printf(" 3- ReadInteger\n");
		printf(" 4- ReadString\n");
		printf(" 5- WriteInteger\n");
		printf(" 6- WriteString\n");
		printf(" 7- Sair\n");
		printf(" OPCAO: ");
		scanf("%d", &opcao);

		if (opcao == 1) {

			printf("Informe o nome do arquivo: ");
			fflush(stdin);
			getchar();
			gets(NomeArquivo);
			strcpy(NomeArquivo, "Exemplo.ini");
			ok = OpenFile(&pPilha, pLista, NomeArquivo);

		}else if (opcao == 2) {

			ImprimeLista(pPilha);

		}else if (opcao == 3) {
			if (ok == 1) {
				PegaDados(NomeSecao, NomeVariavel, ValorDefault);
				int ValorDefInt = atoi(ValorDefault);
				ReadInteger(pPilha, NomeSecao, NomeVariavel, &ValorDefInt);
			}

		}else if (opcao == 4) {
			if (ok == 1) {
				PegaDados(NomeSecao, NomeVariavel, ValorDefault);
				ReadString(pPilha, NomeSecao, NomeVariavel, ValorDefault);
			}
		}else if (opcao == 5) {
			if (ok == 1) {
				PegaDados(NomeSecao, NomeVariavel, ValorDefault);
				int ValorInt = atoi(ValorDefault);
				WriteInteger(&pPilha, NomeSecao, NomeVariavel, &ValorInt);
			}
		}else if (opcao == 6) {
			if (ok == 1) {
				PegaDados(NomeSecao, NomeVariavel, ValorDefault);
				WriteString(&pPilha, NomeSecao, NomeVariavel, ValorDefault);
			}
		}else if (opcao == 7) {
			if (ok == 1) {
				WriteFile(pPilha, &NomeArquivo);
			}
		}else {
			printf("\n\tOPCAOINVALIDA\n");
		}
	}
}

void InsereSecao(queue** s, variaveis* variavel, char* pNome) {

	queue* NovoElemento = NULL;

	NovoElemento = (queue*)calloc(1, sizeof(queue));
	strcpy(NovoElemento->Nome, pNome);
	NovoElemento->Variaveis = variavel;

	if (*s == NULL) {
		*s = NovoElemento;
	}
	else {
		queue* pAux = *s;
		while (pAux->proximo != NULL) {
			pAux = pAux->proximo;
		}
		pAux->proximo = NovoElemento;
	}
}

void InsereVariavel(variaveis** var, Conteudo* conteudo) {

	variaveis* pAux = (variaveis*)calloc(1, sizeof(variaveis));

	pAux->variavel = *conteudo;
	pAux->proximo = *var;

	*var = pAux;
}

int OpenFile(queue** pPilha, variaveis* pLista, char* pNomeArquivo) {
	int ok = 0;
	FILE *FilePointer = NULL;

	FilePointer = fopen(pNomeArquivo, "rt");

	if (FilePointer) {
		char Linha[TamLinha];
		char NomeSecao[TamNomeSecao];
		memset(&NomeSecao, 0, sizeof(NomeSecao));


		while (!feof(FilePointer)) {

			memset(&Linha, 0, sizeof(Linha));
			fgets((char*)&Linha, sizeof(Linha), FilePointer);

			char* chInicio = strchr(Linha, '[');
			char* chFim = strrchr(Linha, ']');

			if (chInicio != NULL && chFim != NULL && strcmp(chInicio, "[") && strcmp(chFim, "]")) {
				if (NomeSecao[0] != '\0') {
					InsereSecao(pPilha, pLista, NomeSecao);
					memset(&NomeSecao, 0, sizeof(NomeSecao));
					strcpy(NomeSecao, Linha);
					pLista = NULL;
				}
				else {
					strcpy(NomeSecao, Linha);
				}
			}
			else {
				if (strlen(Linha) > 1) {
					Conteudo variaveis;
					char ch = '=';

					memset(&variaveis, 0, sizeof(Conteudo));
					PegaVariaveleValor(&variaveis, Linha, &ch);

					InsereVariavel(&pLista, &variaveis);
				}
			}
		}

		InsereSecao(pPilha, pLista, NomeSecao);

		fclose(FilePointer);

		printf("\n\tArquivo carregado com sucesso\n");
		ok = 1;
	}
	else {
		printf("Não consegui abrir o arquivo!");
	}
	return ok;
}

void PegaVariaveleValor(Conteudo* conteudo, char* pLinha, char* ch) {
	int i;
	int tr = 0;
	int contValor = 0;

	char variavel[TamNomeVariavel];
	char valor[TamValorVariavel];

	memset(&variavel, 0, sizeof(variavel));
	memset(&valor, 0, sizeof(valor));

	for (i = 0; i < strlen(pLinha); i++) {
		if (pLinha[i] == *ch) {
			tr = 1;
		}
		else if (tr != 0) {
			valor[contValor] = pLinha[i];
			contValor++;
		}
		else {
			variavel[i] = pLinha[i];
		}
	}
	strcpy(conteudo->NomeVariavel, variavel);
	strcpy(conteudo->ValorVariavel, valor);
}

void ImprimeLista(queue* s) {
	queue* pAux = s;
	variaveis* pAux2 = NULL;

	printf(" ============================ LISTA ============================\n");

	while (pAux != NULL) {
		pAux2 = pAux->Variaveis;

		printf("%s\n",pAux->Nome);

		while (pAux2 != NULL) {
			printf("%s = %s\n",pAux2->variavel.NomeVariavel, pAux2->variavel.ValorVariavel);
			pAux2 = pAux2->proximo;
		}
		pAux = pAux->proximo;
	}
	printf(" ==============================================================\n");
}

void PegaDados(char* NomeSecao, char* NomeVariavel, char* ValorDefault) {
	printf("Informe o nome da Secao: ");
	fflush(stdin);
	getchar();
	gets(NomeSecao);

	printf("Informe o nome da Variavel: ");
	gets(NomeVariavel);

	printf("Informe o ValorDefault: ");
	gets(ValorDefault);
}

void PegaVariavelSelecionada(queue* pPilha, char* pNomeSecao, Conteudo* pConteudo) {
	queue* pAux = pPilha;
	variaveis* pAux2 = NULL;
	int parar = 0;
	char NSection[TamNomeSecao];
	memset(NSection, 0, sizeof(NSection));
	
	while (pAux != NULL && parar == 0) {
		
		memset(NSection, 0, sizeof(NSection));
		strncpy(NSection, pAux->Nome + 1, strlen(pAux->Nome)-3);

		if (strcmp(NSection, pNomeSecao) == 0) {

			pAux2 = pAux->Variaveis;

			while (pAux2 != NULL && parar == 0) {
					
				if (strcmp(pAux2->variavel.NomeVariavel, pConteudo->NomeVariavel) == 0) {
					strcpy(pConteudo->ValorVariavel, pAux2->variavel.ValorVariavel);
					parar = 1;
				}else {
					pAux2 = pAux2->proximo;
				}				
			}
			parar = 1;
		}else {
			pAux = pAux->proximo;
		}
	}
}
void ReadInteger(queue*s, char* pNomeSecao, char* pNomeVariavel, int* pValorDefault) {
	Conteudo conteudo;
	memset(&conteudo, 0, sizeof(Conteudo));
	strcpy(conteudo.NomeVariavel, pNomeVariavel);
	strcpy(conteudo.ValorVariavel, pValorDefault);
	PegaVariavelSelecionada(s, pNomeSecao, &conteudo);

	printf(" Valor lido do Arquivo: %d\n", atoi(conteudo.ValorVariavel));
}

void ReadString(queue*s, char* pNomeSecao, char* pNomeVariavel, char* pValorDefault) {
	Conteudo conteudo;
	memset(&conteudo, 0, sizeof(Conteudo));
	strcpy(conteudo.NomeVariavel, pNomeVariavel);
	strcpy(conteudo.ValorVariavel, pValorDefault);
	PegaVariavelSelecionada(s, pNomeSecao, &conteudo);

	printf(" Valor lido do Arquivo: %s\n", conteudo.ValorVariavel);
}

void WriteFile(queue* s, char* NomeArquivo){
	queue* pAux = s;
	variaveis* pAux2 = NULL;
	FILE *FilePointer = NULL;
	char Linha[255];
	FilePointer = fopen(NomeArquivo, "wt");

	if (FilePointer){
		while (pAux != NULL) {
			
			fprintf(FilePointer, "%s", pAux->Nome);
			pAux2 = pAux->Variaveis;

			while (pAux2 != NULL) {
				fprintf(FilePointer,"%s=%s\n",  pAux2->variavel.NomeVariavel, pAux2->variavel.ValorVariavel);
				pAux2 = pAux2->proximo;
			}

			pAux = pAux->proximo;
		}		
		fclose(FilePointer);
	}else{
		printf("Não consegui abrir o arquivo!");
	}
}

void AlteraVariavelSelecionada(queue** pPilha, char* pNomeSecao, Conteudo* pConteudo) {
	queue* pAux = *pPilha;
	variaveis* pAux2 = NULL;
	int parar = 0;
	char NSection[TamNomeSecao];
	memset(NSection, 0, sizeof(NSection));

	while (pAux != NULL && parar == 0) {

		memset(NSection, 0, sizeof(NSection));
		strncpy(NSection, pAux->Nome + 1, strlen(pAux->Nome) - 3);

		if (strcmp(NSection, pNomeSecao) == 0) {

			pAux2 = pAux->Variaveis;

			while (pAux2 != NULL && parar == 0) {

				if (strcmp(pAux2->variavel.NomeVariavel, pConteudo->NomeVariavel) == 0) {
					strcpy(pAux2->variavel.ValorVariavel, pConteudo->ValorVariavel);
					parar = 1;
				}
				else {
					parar = 2;
					pAux2 = pAux2->proximo;
				}
			}
			if (parar == 2) {
				pAux2 = pAux->Variaveis;
				InsereVariavel(&pAux2, pConteudo);
				pAux->Variaveis = pAux2;
			}
		}
		else {
			pAux = pAux->proximo;
		}
	}

	if (parar == 0) {
		variaveis* pLista = NULL;
		memset(NSection, 0, sizeof(NSection));
		sprintf(NSection, "[%s]\n", pNomeSecao);
		InsereVariavel(&pLista, pConteudo);
		InsereSecao(pPilha, pLista, NSection);
	}
}

void WriteInteger(queue** s, char* pNomeSecao, char* pNomeVariavel, int* pValorDefault) {
	Conteudo conteudo;
	memset(&conteudo, 0, sizeof(Conteudo));
	strcpy(conteudo.NomeVariavel, pNomeVariavel);
	sprintf(conteudo.ValorVariavel, "%d\n", *pValorDefault);
	AlteraVariavelSelecionada(s, pNomeSecao, &conteudo);

	printf(" Valor alterado no Arquivo: %s\n", conteudo.ValorVariavel);
}

void WriteString(queue** s, char* pNomeSecao, char* pNomeVariavel, char* pValorDefault) {

	Conteudo conteudo;
	memset(&conteudo, 0, sizeof(Conteudo));
	strcpy(conteudo.NomeVariavel, pNomeVariavel);
	strcpy(conteudo.ValorVariavel, pValorDefault);
	AlteraVariavelSelecionada(s, pNomeSecao, &conteudo);
	printf(" Valor alterado no Arquivo: %s\n", conteudo.ValorVariavel);
}