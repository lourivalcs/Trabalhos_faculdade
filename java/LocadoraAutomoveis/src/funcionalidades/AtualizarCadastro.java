package funcionalidades;

import java.util.Scanner;
import objetos.Arrays;
import objetos.Automovel;
import objetos.ClientePessoaFisica;
import objetos.ClientePessoaJuridica;
import objetos.Fornecedor;
import objetos.Funcionario;

public class AtualizarCadastro {
   
    /*
    * submenu do Menu principal que serve para atualização dos cadastros
    * de veiculos, clientes, funcionarios e fornecedores
    */
    public void subMenuAtualizarCadastro(Arrays arrays){
        
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        while(opcao != 5){
            System.out.println("Escolha uma das opcoes abaixo");
            System.out.println(" 1 - Atualizar automovel");
            System.out.println(" 2 - Atualizar cliente");
            System.out.println(" 3 - Atualizar funcionario");
            System.out.println(" 4 - Atualizar fornecedor");
            System.out.println(" 5 - Voltar");
            System.out.print("OPCAO: ");
            opcao = scanner.nextInt();
        
            switch(opcao){
                case 1:
                    // Efetua a atualização dos dados da placa
                    scanner.nextLine();
                    System.out.printf("Informe a placa para atualizar: ");
                    String placa = scanner.nextLine();
                    /*procura no array de automoveis se consta a placa
                    *se houver, chama o metodo de atualização dentro do
                    *objeto Automovel
                    */
                    for(Automovel automovel: arrays.getAutomoveis()){
                        if(placa.equalsIgnoreCase(automovel.getPlaca())){
                            automovel.AtualizarCadastro();
                            break;
                        }
                    }
                    break;
                case 2:
                    //atualiza o cliente pf ou pj
                    opcao = 0;
                    System.out.println(" 1 - Atualizar Cliente pessoa fisica");
                    System.out.println(" 2 - Atualizar Cliente pessoa juridica");
                    System.out.printf("OPCAO: ");
                    opcao = scanner.nextInt();
                        switch(opcao){
                            case 1:
                                scanner.nextLine();
                                System.out.printf("Informe o nome do cliente: ");
                                String nome = scanner.nextLine();
                                /*procura no array de clientesPF se consta o nome
                                *se houver, chama o metodo de atualização dentro do
                                *objeto ClientePessoaFisica
                                */
                                for(ClientePessoaFisica cpf: arrays.getClientesPF()){
                                    if(cpf.getNome().equalsIgnoreCase(nome)){
                                        cpf.atualizaPessoaFisica();
                                    }
                                }
                                break;
                            case 2:
                                scanner.nextLine();
                                System.out.printf("Informe a razao social do cliente: ");
                                String razsoc = scanner.nextLine();
                                /*procura no array de clientesPJ se consta a razão social
                                *se houver, chama o metodo de atualização dentro do
                                *objeto ClientePessoaJuridica
                                */
                                for(ClientePessoaJuridica cnpj: arrays.getClientesPJ()){
                                    if(cnpj.getRazaoSocial().equalsIgnoreCase(razsoc)){
                                        cnpj.atualizaPessoaJuridica();
                                    }
                                }
                                break;
                            default:
                                System.out.println("OPCAO INVALIDA");
                        }
                    break;
                case 3:
                    
                    scanner.nextLine();
                    System.out.printf("Informe o nome do funcionario para atualizar: ");
                    String nome = scanner.nextLine();
                    /*procura no array de funcionarios se consta o nome
                    *se houver, chama o metodo de atualização dentro do
                    *objeto Funcionario
                    */
                    for(Funcionario func: arrays.getFuncionarios()){
                        if(nome.equalsIgnoreCase(func.getNome())){
                            func.atualizaFuncionario();
                            break;
                        }
                    }
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.printf("Informe a razao social do fornecedor para atualizar: ");
                    String razscoc = scanner.nextLine();
                    /*procura no array de funcionarios se consta a razão social
                    *se houver, chama o metodo de atualização dentro do
                    *objeto Fornecedor
                    */
                    for(Fornecedor fornec: arrays.getFornecedores()){
                        if(razscoc.equalsIgnoreCase(fornec.getRazaoSocial())){
                            fornec.atualizaFornecedor();
                            break;
                        }
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("OPCAO INVALIDA");
            }
        }
    }
}
