#include<stdio.h>
#include<string.h>
#include<stdlib.h>

typedef struct STACK {
	float Vetor[11];
	int Indice;
}PILHA;

void push(PILHA* pPilha, float Valor);
float top(PILHA* pPilha);
float pop(PILHA* pPilha);

void InicializaPilha(PILHA* pPilha);
void SolicitaValor(PILHA* pPilha);
void VerificaOperador(PILHA* pPilha, char* pValor);
void MostraPilha(PILHA* pPilha);

void main() {
	PILHA numeros;
	InicializaPilha(&numeros);
	int i = numeros.Indice;

	while(i < 10) {
		SolicitaValor(&numeros);
		MostraPilha(&numeros);
		i = numeros.Indice;
	}

	getchar();
}

void InicializaPilha(PILHA* pPilha) {
	memset(pPilha, 0, sizeof(PILHA));
	pPilha->Indice = -1;
}

void SolicitaValor(PILHA* pPilha) {
	char valor[3];
	printf("Informe um valor ou operador Matematico (*,/,+,-) : ");
	fflush(stdin);
	scanf("%s", &valor);

	VerificaOperador(pPilha, valor);

}

void VerificaOperador(PILHA* pPilha, char* pValor) {
	float calculo = 0;
	if ((strcmp(pValor, "*") == 0)) {
		push(pPilha, pop(pPilha) * pop(pPilha));
	}
	else if ((strcmp(pValor, "/") == 0)) {
		push(pPilha, pop(pPilha) / pop(pPilha));
	}
	else if ((strcmp(pValor, "+") == 0)) {
		push(pPilha, pop(pPilha) + pop(pPilha));
	}
	else if ((strcmp(pValor, "-") == 0)) {
		push(pPilha, pop(pPilha) - pop(pPilha));
	}
	else {
		push(pPilha, atof(pValor));
	}
}

void MostraPilha(PILHA* pPilha) {
	int i = pPilha->Indice;
	for (; i >= 0; i--) {
		printf("----------PILHA---------\n");
		printf("Posicao %d == [%.2f]\n", i, pPilha->Vetor[i]);
	}
	printf("------------------------\n");
}

//------------------------- FUNÇÕES PILHAS -----------------------------
void push(PILHA* pPilha, float Valor) {
	pPilha->Indice++;
	pPilha->Vetor[pPilha->Indice] = Valor;
}

float top(PILHA* pPilha) {
	float Retorno = pPilha->Vetor[pPilha->Indice];
	return Retorno;
}

float pop(PILHA* pPilha) {
	float Retorno = pPilha->Vetor[pPilha->Indice];
	pPilha->Indice--;
	return Retorno;
}