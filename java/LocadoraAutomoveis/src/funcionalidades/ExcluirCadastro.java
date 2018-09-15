package funcionalidades;

import java.util.Scanner;
import objetos.Arrays;
import objetos.Automovel;
import objetos.ClientePessoaFisica;
import objetos.ClientePessoaJuridica;
import objetos.Fornecedor;
import objetos.Funcionario;

public class ExcluirCadastro {
    
    /*
    * Submenu responsavel por remover o cadastro de automoveis clientes,
    * funcionarios e fornecedores
    */
    public void subMenuExluirCadastro(Arrays arrays){
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        while(opcao != 5){
            System.out.println("Escolha uma das opcoes abaixo");
            System.out.println(" 1 - Excluir automovel");
            System.out.println(" 2 - Excluir cliente");
            System.out.println(" 3 - Excluir funcionario");
            System.out.println(" 4 - Excluir fornecedor");
            System.out.println(" 5 - Voltar");
            System.out.print("OPCAO: ");
            opcao = scanner.nextInt();
            boolean validacao = false;
            String msg = "";
            
            switch(opcao){
                case 1:
                    // Efetua a remoção do veículo
                    scanner.nextLine();
                    System.out.printf("Informe a placa para excluir: ");
                    String placa = scanner.nextLine();
                    /*verifica a placa no array de automoveis, se existir,
                    * utiliza o metodo remove do array e passa como parametro
                    * o objeto encontrado
                    */
                    for(Automovel automovel: arrays.getAutomoveis()){
                        if(placa.equalsIgnoreCase(automovel.getPlaca()) && !automovel.isStatus()){
                            arrays.getAutomoveis().remove(automovel);
                            validacao = true;
                            break;
                        }
                    }
                    if(!validacao){
                        msg = " - VEICULO NAO ENCONTRADO OU ESTA ALUGADO";
                    }
                    break;
                case 2:
                    opcao = 0;
                    System.out.println(" 1 - Excluir Cliente pessoa fisica");
                    System.out.println(" 2 - Excluir Cliente pessoa juridica");
                    System.out.printf("OPCAO: ");
                    opcao = scanner.nextInt();
                        switch(opcao){
                            case 1:
                                scanner.nextLine();
                                System.out.printf("Informe o nome do cliente que ira excluir: ");
                                String nome = scanner.nextLine();
                                /*verifica o nome no array de clientes PF, se existir,
                                * utiliza o metodo remove do array e passa como parametro
                                * o objeto encontrado
                                */
                                for(ClientePessoaFisica cpf: arrays.getClientesPF()){
                                    if(nome.equalsIgnoreCase(cpf.getNome()) && !cpf.isPossuiVeiculoAlugado()){
                                        arrays.getClientesPF().remove(cpf);
                                        validacao = true;
                                        break;
                                    }
                                }
                                break;
                            case 2:
                                scanner.nextLine();
                                System.out.printf("Informe a razao social do cliente: ");
                                String razsoc = scanner.nextLine();
                                /*verifica a razão social no array de clientes PJ, se existir,
                                * utiliza o metodo remove do array e passa como parametro
                                * o objeto encontrado
                                */
                                for(ClientePessoaJuridica cnpj: arrays.getClientesPJ()){
                                    if(cnpj.getRazaoSocial().equalsIgnoreCase(razsoc) && cnpj.getQtdVeiculosAlugados() == 0){
                                        arrays.getClientesPJ().remove(cnpj);
                                        validacao = true;
                                        break;
                                    }
                                }
                                break;
                            default:
                                System.out.println("OPCAO INVALIDA");
                        }
                        if(!validacao){
                            msg = " - CLIENTE NAO ENCONTRADO OU POSSUI VEICULO ALUGADO";
                        }
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.printf("informe o nome do funcionario para excluir: ");
                    String nome = scanner.nextLine();
                    /*verifica o nome no array de clientes PF, se existir,
                    * utiliza o metodo remove do array e passa como parametro
                    * o objeto encontrado
                    */
                    for(Funcionario func: arrays.getFuncionarios()){
                        if(nome.equalsIgnoreCase(func.getNome())){
                            arrays.getFuncionarios().remove(func);
                            validacao = true;
                            break;
                        }
                    }
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.printf("Informe a razao social do fornecedor para excluir: ");
                    String razscoc = scanner.nextLine();
                    /*verifica a razão social no array de clientes PJ, se existir,
                    * utiliza o metodo remove do array e passa como parametro
                    * o objeto encontrado
                    */
                    for(Fornecedor fornec: arrays.getFornecedores()){
                        if(razscoc.equalsIgnoreCase(fornec.getRazaoSocial())){
                            arrays.getFornecedores().remove(fornec);
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
            
            if(validacao){
                System.out.println("\n\tCADASTRO REMOVIDO\n");
            }else{
                System.out.println("\n\tNAO FOI POSSIVEL REMOVER O CADASTRO" + msg + "\n");
            }
            
        }
    }
}
