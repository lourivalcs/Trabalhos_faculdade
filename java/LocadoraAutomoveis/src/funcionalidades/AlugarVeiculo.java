package funcionalidades;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import objetos.Aluguel;
import objetos.Arrays;
import objetos.Automovel;
import objetos.ClientePessoaFisica;
import objetos.ClientePessoaJuridica;

public class AlugarVeiculo {
    /*
    *método que efetua o cadastro do aluguel no array
    */
    public void Alugar(Arrays arrays){
        Scanner scanner = new Scanner(System.in);
        System.out.print(" 1 - Cliente PF\t2 - Cliente PJ: ");
        
        int opcao = Integer.parseInt(scanner.nextLine());
        //variaveis para exibir msg de erro ou de sucesso
        boolean validaCliente = false;
        boolean validaVeiculo = false;
        
        if(opcao == 1){
            System.out.print("NOME: ");
            String nome = scanner.nextLine();
            
            /*for para checar se o nome informado existe no array,verifica se o cliente possui 
            *veiculo alugado ou não, se tudo ok, pula para o for de veículos
            */
            for(ClientePessoaFisica cpf: arrays.getClientesPF()){
                if(nome.equalsIgnoreCase(cpf.getNome()) && (!cpf.isPossuiVeiculoAlugado())){
                    validaCliente = true;
                    System.out.print("PLACA: ");
                    String placa = scanner.nextLine();
                    
                    /*for criado para checar a placa informada e se o veiculo esta alugado ou não
                    *caso situação ok, pega a data, insere no datalocado e adiciona a quantidade
                    *de dias informada pelo usuario e coloca na data de entrega, apos a inserções
                    *o objeto é inserido no array de aluguel, é setado o status como true no veiculo e cliente
                    */
                    for(Automovel auto: arrays.getAutomoveis()){
                        if(placa.equalsIgnoreCase(auto.getPlaca()) && (!auto.isStatus())){
                            validaVeiculo = true;
                            System.out.println("Quantidade de dias alugado: ");
                            int dias = scanner.nextInt();
                            Aluguel aluguel = new Aluguel();
                            aluguel.setDataLocado(new Date());
                            Calendar cal = Calendar.getInstance();
                            cal.setTime(aluguel.getDataLocado());
                            cal.add(Calendar.DATE, dias);
                            aluguel.setDataEntrega(cal.getTime());
                            aluguel.setIdCliente(cpf.getID_CLIENTE_PF());
                            aluguel.setIdVeiculo(auto.getID_AUTOMOVEL());
                            aluguel.setTipoCliente("PF");
                            aluguel.setValorTotalAluguel((auto.getValorAluguel()*dias));
                            aluguel.setValorMultaAtraso(1000);
                            aluguel.setStatus(true);
                            arrays.getAluguel().add(aluguel);
                            auto.setStatus(true);
                            cpf.setPossuiVeiculoAlugado(true);
                            break;
                        }
                    }
                    break;
                }
            }
            
        }else if(opcao == 2){
            
            System.out.print("RAZAO SOCIAL: ");
            String razaosocial = scanner.nextLine();
            
            /*for para checar se o nome informado existe no array,verifica se o cliente possui 
            *veiculo alugado ou não, se tudo ok, pula para o for de veículos
            */
            for(ClientePessoaJuridica cnpj: arrays.getClientesPJ()){
                if(razaosocial.equalsIgnoreCase(cnpj.getRazaoSocial())){
                    validaCliente = true;
                    System.out.print("PLACA: ");
                    String placa = scanner.nextLine();
                    
                    /*for criado para checar a placa informada e se o veiculo esta alugado ou não
                    *caso situação ok, pega a data, insere no datalocado e adiciona a quantidade
                    *de dias informada pelo usuario e coloca na data de entrega, apos a inserções
                    *o objeto é inserido no array de aluguel, é setado o status como true no veiculo e cliente
                    */
                    for(Automovel auto: arrays.getAutomoveis()){
                        if(placa.equalsIgnoreCase(auto.getPlaca()) && (!auto.isStatus())){
                            validaVeiculo = true;
                            System.out.println("Quantidade de dias alugado: ");
                            int dias = scanner.nextInt();
                            Aluguel aluguel = new Aluguel();
                            aluguel.setDataLocado(new Date());
                            Calendar cal = Calendar.getInstance();
                            cal.setTime(aluguel.getDataLocado());
                            cal.add(Calendar.DATE, dias);
                            aluguel.setDataEntrega(cal.getTime());
                            aluguel.setIdCliente(cnpj.getID_CLIENTE_PJ());
                            aluguel.setIdVeiculo(auto.getID_AUTOMOVEL());
                            aluguel.setTipoCliente("PJ");
                            aluguel.setValorTotalAluguel((auto.getValorAluguel()*dias));
                            aluguel.setValorMultaAtraso(1000);
                            aluguel.setStatus(true);
                            arrays.getAluguel().add(aluguel);
                            auto.setStatus(true);
                            cnpj.setQtdVeiculosAlugados(cnpj.getQtdVeiculosAlugados()+1);
                            cnpj.getIdVeiculos().add(auto.getID_AUTOMOVEL());
                            break;
                        }
                    }
                    break;
                }
            }
            
        }else{
            System.out.println("\n\tOPCAO INVALIDA\n");
        }
        
        if(opcao == 1 || opcao == 2){
            if(!validaCliente){
                System.out.println("\n\tCLIENTE NAO ENCONTRADO OU JA POSSUI VEICULO ALUGADO\n");
            }else if(!validaVeiculo){
                System.out.println("\n\tVEICULO NAO ENCONTRADO OU JA ESTA ALUGADO\n");
            }else{
                System.out.println("\n\tALUGUEL CADASTRADO\n");
            }
        }
        
    }
            
}
