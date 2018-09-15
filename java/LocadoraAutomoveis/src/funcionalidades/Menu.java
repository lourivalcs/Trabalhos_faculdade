package funcionalidades;

import java.util.Scanner;
import objetos.Arrays;

public class Menu {
    /*
    *Menu principal do programa
    */
    public void menu(Arrays arrays){        
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        
        while(opcao != 9){
            System.out.println("Informe uma das opcoes abaixo");
            System.out.println(" 1 - Inserir cadastro");
            System.out.println(" 2 - Atualizar cadastro");
            System.out.println(" 3 - Excluir cadastro");
            System.out.println(" 4 - Pesquisar cadastro");
            System.out.println(" 5 - Alugar veiculo");
            System.out.println(" 6 - Devolucao");
            System.out.println(" 7 - Relatorios");
            System.out.println(" 9 - Sair");
            System.out.print(" OPCAO: ");
            opcao = scanner.nextInt();
            
            if(opcao == 1){
                //Instancia a classe e chama o metódo de inserir cadastro
                new InserirCadastro().subMenuInserirCadastro(arrays);
            }else if(opcao == 2){
                //Instancia a classe e chama o metódo de atualizar cadastro
                new AtualizarCadastro().subMenuAtualizarCadastro(arrays);
            }else if(opcao == 3){
                //Instancia a classe e chama o metódo de excluir cadastro
                new ExcluirCadastro().subMenuExluirCadastro(arrays);
            }else if(opcao == 4){
                //Instancia a classe e chama o metódo de pesquisa cadastro
                new PesquisarCadastro().subMenuPesquisarCadastro(arrays);
            }else if(opcao == 5){
                //Instancia a classe e chama o metódo alugar
                new AlugarVeiculo().Alugar(arrays);
            }else if(opcao == 6){
                //Instancia a classe e chama o metódo devolver veiculo
                new DevolverVeiculo().devolucao(arrays);
            }else if(opcao == 7){
                //Instancia a classe e chama o metódo de menu de relatórios
                new Relatorios().menuRelatorios(arrays);
            }else if(opcao != 9){
                System.out.println("Opcao Invalida");
            }
        }
    }
}
