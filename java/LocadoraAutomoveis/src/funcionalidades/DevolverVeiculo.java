package funcionalidades;

import java.util.Date;
import java.util.Scanner;
import objetos.Aluguel;
import objetos.Arrays;
import objetos.Automovel;
import objetos.ClientePessoaFisica;
import objetos.ClientePessoaJuridica;

public class DevolverVeiculo {
    /*
    * metodo que efetua a devolução
    */
    public void devolucao(Arrays arrays) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("PLACA:");
        String placa = scanner.nextLine();
        //variavel criada para exibir msg na tela, caso sucesso ou falha
        boolean verifica = false;
        
        /*
        * após ser informada a placa, é verificado no array de automoveis se o veiculo
        * existe, caso exista e não esteja alugado, verifica no array de aluguel.
        * Quando encontrar o veículo ira verificar a data de entrega se é maior que 
        * a data atual, se for data maior, é cobrado multa. Após verifica se cliente é
        * PF ou PJ, se pj, utiliza o array para encontrar o cliente e decrementar
        * a quantidade de veiculos alugados e a retirada do Id do array de IDs de veiculo
        * que fica dentro do objeto cliente PJ. Se for PF, é setado false para que não
        * tenha veiculos alugados e é setado 0 no ID do veiculo. Após é setado false
        * no status do aluguel para informar que o veiculo foi devolvido
        */
        for (Automovel auto : arrays.getAutomoveis()) {
            if (placa.equalsIgnoreCase(auto.getPlaca()) && auto.isStatus()) {
                for (Aluguel aluguel : arrays.getAluguel()) {
                    if(aluguel.getIdVeiculo() == auto.getID_AUTOMOVEL()){
                        verifica = true;
                        if(!aluguel.getDataEntrega().after(new Date())){
                            aluguel.setValorTotalAluguel(aluguel.getValorMultaAtraso() + aluguel.getValorTotalAluguel());
                        }
                        auto.setStatus(false);
                        
                        if(aluguel.getTipoCliente().equalsIgnoreCase("PF")){
                            for(ClientePessoaFisica cpf: arrays.getClientesPF()){
                                cpf.setPossuiVeiculoAlugado(false);
                                cpf.setIdVeiculo(0);
                                break;
                            }
                        }else{
                            for(ClientePessoaJuridica cnpj: arrays.getClientesPJ()){
                                cnpj.setQtdVeiculosAlugados(cnpj.getQtdVeiculosAlugados()-1);
                                
                                for(Integer idAuto: cnpj.getIdVeiculos()){
                                    if(idAuto == auto.getID_AUTOMOVEL()){
                                        cnpj.getIdVeiculos().remove(idAuto);
                                        break;
                                    }
                                }
                                
                                break;
                            }
                        }
                        aluguel.setStatus(false);
                        break;
                    }
                }
            }
        }
        
        if(verifica){
            System.out.println("VEICULO DEVOLVIDO");
        }else{
            System.out.println("VEICULO NAO ENCONTRADO OU NAO ESTA ALUGADO");
        }

    }
}
