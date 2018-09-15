package funcionalidades;

import java.util.Scanner;
import objetos.Arrays;
import objetos.Automovel;
import objetos.ClientePessoaFisica;
import objetos.ClientePessoaJuridica;
import objetos.Fornecedor;
import objetos.Funcionario;

public class PesquisarCadastro {
    /*
    * Submenu do Menu principal que serve para atualição de cadastro
    */
    public void subMenuPesquisarCadastro(Arrays arrays){
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        while(opcao != 5){
            System.out.println("Escolha uma das opcoes abaixo");
            System.out.println(" 1 - Pesquisar automovel");
            System.out.println(" 2 - Pesquisar cliente");
            System.out.println(" 3 - Pesquisar funcionario");
            System.out.println(" 4 - Pesquisar fornecedor");
            System.out.println(" 5 - Voltar");
            System.out.print("OPCAO: ");
            opcao = scanner.nextInt();
            boolean validacao = false;
            
            switch(opcao){
                case 1:
                    scanner.nextLine();
                    System.out.printf("Informe a placa que deseja Pesquisar: ");
                    String placa = scanner.nextLine();
                    /*
                    * Verifica a placa no arrays de automoveis e caso seja
                    * encontrada exibe o veículo
                    */
                    for(Automovel automovel: arrays.getAutomoveis()){
                        if(placa.equalsIgnoreCase(automovel.getPlaca())){
                            automovel.exibeAutomovel();
                            validacao = true;
                            break;
                        }
                    }
                    break;
                case 2:
                    opcao = 0;
                    System.out.println(" 1 - Pesquisar Cliente pessoa fisica");
                    System.out.println(" 2 - Pesquisar Cliente pessoa juridica");
                    System.out.printf("OPCAO: ");
                    opcao = scanner.nextInt();
                        switch(opcao){
                            case 1:
                                scanner.nextLine();
                                System.out.printf("Informe o nome do cliente que ira pesquisar: ");
                                String nome = scanner.nextLine();
                                /*
                                * Verifica o nome no arrays de clientesPF e caso seja
                                * encontrada exibe o cliente
                                */
                                for(ClientePessoaFisica cpf: arrays.getClientesPF()){
                                    if(nome.equalsIgnoreCase(cpf.getNome())){
                                        cpf.exibePessoaFisica();
                                        validacao = true;
                                        break;
                                    }
                                }
                                break;
                            case 2:
                                scanner.nextLine();
                                System.out.printf("Informe a razao social do cliente: ");
                                String razsoc = scanner.nextLine();
                                /*
                                * Verifica a razão social no arrays de clientesPJ e caso seja
                                * encontrada exibe o cliente
                                */
                                for(ClientePessoaJuridica cnpj: arrays.getClientesPJ()){
                                    if(cnpj.getRazaoSocial().equalsIgnoreCase(razsoc)){
                                        cnpj.exibePessoaJuridica();
                                        validacao = true;
                                        break;
                                    }
                                }
                                break;
                            default:
                                System.out.println("OPCAO INVALIDA");
                        }
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.printf("informe o nome do funcionario para pesquisar: ");
                    String nome = scanner.nextLine();
                    /*
                    * Verifica o nome no arrays de funcionarios e caso seja
                    * encontrada exibe o cliente
                    */
                    for(Funcionario func: arrays.getFuncionarios()){
                        if(nome.equalsIgnoreCase(func.getNome())){
                            func.exibeFuncionario();
                            validacao = true;
                            break;
                        }
                    }
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.printf("Informe a razao social do fornecedor para pesquisar: ");
                    String razscoc = scanner.nextLine();
                    /*
                    * Verifica razão social no arrays de fornecedores e caso seja
                    * encontrada exibe o cliente
                    */
                    for(Fornecedor fornec: arrays.getFornecedores()){
                        if(razscoc.equalsIgnoreCase(fornec.getRazaoSocial())){
                            fornec.exibeFornecedor();
                            validacao = true;
                            break;
                        }
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("OPCAO INVALIDA");
            }
            
            if(!validacao){
                System.out.println("\n\tNAO FOI POSSIVEL LOCALIZAR O CADASTRO\n");
            }
        }
    }
}
