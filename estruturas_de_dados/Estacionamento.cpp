#include<stdio.h>
#include<string.h>

#define TAMANHO 10

typedef struct {
	char placa[8];
	int manobras;
}SCarro;

typedef struct STACK {
	SCarro carros[TAMANHO];
	int Indice;
}PILHA;

void push(PILHA* pPilha, SCarro* pCarro);
SCarro top(PILHA* pPilha);
SCarro pop(PILHA* pPilha);

void InicializaPilha(PILHA* pPilha);
int Menu();
void InsereVeiculo(PILHA* pPilha);
void ListaVeiculosEstacionamento(PILHA* pPilha);
void RetiraVeiculo(PILHA* pPilha);

void main() {
	PILHA estacionamento;
	InicializaPilha(&estacionamento);

	int opcao = Menu();

	while (opcao != 4) {
		if (opcao == 1) {
			if(estacionamento.Indice >= 9){
				printf("\nEstacionamento Lotado\n\n");
			}else {
				InsereVeiculo(&estacionamento);
			}

		}else if (opcao == 2) {

			ListaVeiculosEstacionamento(&estacionamento);

		}else if (opcao == 3) {

			RetiraVeiculo(&estacionamento);

		}else {
			printf("Opcao Invalida\n");
		}

		opcao = Menu();
	}

}

void InicializaPilha(PILHA* pPilha) {
	memset(pPilha, 0, sizeof(PILHA));
	pPilha->Indice = -1;
}

int Menu() {
	int opcao;

	printf("------------------------------------------------------------\n");
	printf(" 1) Inserir carro\n");
	printf(" 2) Listar carros\n");
	printf(" 3) Retirar Veiculo\n");
	printf(" 4) Sair\n");
	printf(" Opcao: ");
	scanf("%d", &opcao);

	return opcao;
}

void InsereVeiculo(PILHA* pPilha) {
	SCarro carro;
	printf("------------------------------------------------------------\n");
	printf("Informe a placa do veiculo: ");
	getchar();
	fflush(stdin);
	gets(carro.placa);
	carro.manobras = 0;
	push(pPilha, &carro);
}

void ListaVeiculosEstacionamento(PILHA* pPilha) {
	int i = pPilha->Indice;
	printf("------------------------Estacionamento----------------------\n");
	
	if (i == -1) {
		printf("\n\tNao existem veiculos no estacionamento\n");
		printf("------------------------------------------------------------\n");
	} else{

		for (; i >= 0; i--) {
			printf("\n\tVAGA %d == [%s]  ==  MANOBRAS: %d\n", i, pPilha->carros[i].placa, pPilha->carros[i].manobras);
		}
		printf("------------------------------------------------------------\n");
	}
}

void RetiraVeiculo(PILHA* pPilha) {
	char veiculo[8];
	PILHA retiraVeiculo;
	int i = pPilha->Indice;
	int encontrado = 0;
	SCarro carro;
	InicializaPilha(&retiraVeiculo);

	printf("Informe o veiculo a ser retirado: ");
	getchar();
	fflush(stdin);
	gets(veiculo);

	for (; i >= 0; i--) {
		carro = pop(pPilha);
		if ((strcmp(carro.placa, veiculo) == 0)) {
			printf("\n\t\tVeiculo Retirado, Manobras efetuadas: %d\n", carro.manobras);
			encontrado = 1;
			break;
		}else {
			push(&retiraVeiculo, &carro);
		}
	}

	i = retiraVeiculo.Indice;
	if (encontrado == 0) {
		
		for (; i >= 0; i--) {
			carro = pop(&retiraVeiculo);
			push(pPilha, &carro);
		}

		printf("\nVeiculo nao encontrado\n");

	}
	else {
		for (; i >= 0; i--) {
			carro = pop(&retiraVeiculo);
			carro.manobras++;
			push(pPilha, &carro);
		}
	}
}

//------------------------- FUNÇÕES PILHAS -----------------------------
void push(PILHA* pPilha, SCarro* pCarro) {
	memcpy(&pPilha->carros[++pPilha->Indice], pCarro, (sizeof(SCarro)));
}

SCarro top(PILHA* pPilha) {
	return pPilha->carros[pPilha->Indice];
}

SCarro pop(PILHA* pPilha) {
	return pPilha->carros[pPilha->Indice--];
}