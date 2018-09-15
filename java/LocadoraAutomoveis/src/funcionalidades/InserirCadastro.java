package funcionalidades;

import java.util.Scanner;
import objetos.Arrays;
import objetos.Automovel;
import objetos.ClientePessoaFisica;
import objetos.ClientePessoaJuridica;
import objetos.Fornecedor;
import objetos.Funcionario;

public class InserirCadastro {
    /*
    *Submenu para inserir cadastro dos objetos
    */
    public void subMenuInserirCadastro(Arrays arrays){
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        while(opcao != 5){
            System.out.println("Escolha uma das opcoes abaixo");
            System.out.println(" 1 - Inserir automovel");
            System.out.println(" 2 - Inserir cliente");
            System.out.println(" 3 - Inserir funcionario");
            System.out.println(" 4 - Inserir fornecedor");
            System.out.println(" 5 - Voltar");
            System.out.print("OPCAO: ");
            opcao = scanner.nextInt();
        
            switch(opcao){
                case 1:
                    /*
                    * pega o array de automoveis do objeto arrays e chama o metodo add
                    * e no parametro chama a classe automovel passando no construtor o ID
                    * do automovel que está também no objeto arrays
                    */
                    arrays.getAutomoveis().add(new Automovel(arrays.getID_AUTOMOVEL()));
                    break;
                case 2:
                    opcao = 0;
                    System.out.println(" 1 - Inserir Cliente pessoa fisica");
                    System.out.println(" 2 - Inserir Cliente pessoa juridica");
                    opcao = scanner.nextInt();
                        switch(opcao){
                            case 1:
                                /*
                                * pega o array de clientesPF do objeto arrays e chama o metodo add
                                * e no parametro chama a classe automovel passando no construtor o ID
                                * do clientePF que está também no objeto arrays
                                */
                                arrays.getClientesPF().add(new ClientePessoaFisica(arrays.getID_CLIENTE_PF()));
                                break;
                            case 2:
                                /*
                                * pega o array de clientesPJ do objeto arrays e chama o metodo add
                                * e no parametro chama a classe automovel passando no construtor o ID
                                * do clientePJ que está também no objeto arrays
                                */
                                arrays.getClientesPJ().add(new ClientePessoaJuridica(arrays.getID_CLIENTE_PJ()));
                                break;
                            default:
                                System.out.println("OPCAO INVALIDA");
                        }
                    break;
                case 3:
                    /*
                    * pega o array de funcionarios do objeto arrays e chama o metodo add
                    * e no parametro chama a classe automovel passando no construtor o ID
                    * do funcionario que está também no objeto arrays
                    */
                    arrays.getFuncionarios().add(new Funcionario(arrays.getID_FUNCIONARIO()));
                    break;
                case 4:
                    /*
                    * pega o array de fornecedores do objeto arrays e chama o metodo add
                    * e no parametro chama a classe automovel passando no construtor o ID
                    * do fornecedor que está também no objeto arrays
                    */
                    arrays.getFornecedores().add(new Fornecedor(arrays.getID_FORNECEDOR()));
                    break;
                case 5:
                    break;
                default:
                    System.out.println("OPCAO INVALIDA");
            }
        }
    }
}
