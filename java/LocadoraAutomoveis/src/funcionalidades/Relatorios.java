package funcionalidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import objetos.Aluguel;
import objetos.Arrays;
import objetos.Automovel;
import objetos.ClientePessoaFisica;
import objetos.ClientePessoaJuridica;

public class Relatorios {
    /*
    * Menu de geração de relatórios
    */
    public void menuRelatorios(Arrays arrays){
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        System.out.println(" 1 - Listar Veiculos Disponiveis");
        System.out.println(" 2 - Veiculos com atraso na devolucao");
        System.out.println(" 3 - Listar veiculos Alugados");
        System.out.println(" 4 - Clientes PJ que mais alugam veiculos");
        System.out.println(" 5 - Listar carros alugados por empresa");
        System.out.print("  OPCAO: ");
        opcao = Integer.parseInt(scanner.nextLine());
        
        if(opcao == 1){
            //chama o metodo de listar disponiveis
            this.listarDisponiveis(arrays.getAutomoveis());
        }else if(opcao == 2){
            //chama o metodo para exibir os veiculos com atraso
            this.veiculosComAtraso(arrays);
        }else if(opcao == 3){
            //chama o metodo para exibir apenas veiculos alugados
            this.exibirAlugados(arrays);
        }else if(opcao == 4){
            //chama o metodo para exibir os 5 clientes PJ mais frequentes
            this.clientesFrequentes(arrays);
        }else if(opcao == 5){
            //chama o metodo para exibir veiculos alugados por empresa
            this.veiculosAlugadosPorEmpresa(arrays.getClientesPJ());
        }else{
            System.out.println("OPCAO INVALIDA");
        }
    }
    
    /*
    * percorre o array de automoveis e exibe o veiculo caso status seja false
    */
    public void listarDisponiveis(ArrayList<Automovel> automoveis){
        System.out.println("==================================== VEICULOS DISPONIVEIS ====================================");
        for(Automovel auto: automoveis){
            if(!auto.isStatus()){
                System.out.printf("\tPLACA: " + auto.getPlaca()
                                 +"\tMODELO: " + auto.getModelo()
                                 +"\tANO: " + auto.getAno()
                                 +"\tVALOR ALUGUEL: " + auto.getValorAluguel()
                                 +"\n"
                );
            }
        }
        System.out.println("==============================================================================================");
    }
    
    /*
    * Percorre array de aluguel e caso status seja true, percorrerá o array de 
    * automoveis, se o idVeiculo do aluguel for igual ao idVeiculo do automovel
    * vai exibir a placa do veiculo. Após vai verificar se o tipoCliente for PF
    * ou PJ, se for pf vai percorrer o array de clientePF e exibir o nome,
    * se for PJ irá percorrer o array de clientePJ e exibir a razão Social.
    * Depois irá informar a Data Locação e Data Entrega, o tipo de cliente(PF ou PJ)
    * e após o valor do aluguel.
    */
    public void exibirAlugados(Arrays arrays) {
        System.out.println("================================================================ VEICULOS ALUGADOS ================================================================");
        for (Aluguel aluguel : arrays.getAluguel()) {
            if (aluguel.isStatus()) {
                System.out.print("PLACA: ");
                for (Automovel auto : arrays.getAutomoveis()) {
                    if (aluguel.getIdVeiculo() == auto.getID_AUTOMOVEL()) {
                        System.out.print(auto.getPlaca());
                        break;
                    }
                }
                System.out.printf("\tCLIENTE: ");//fazer if se pf ou pj
                if (aluguel.getTipoCliente().equalsIgnoreCase("PF")) {
                    for (ClientePessoaFisica cpf : arrays.getClientesPF()) {
                        if (aluguel.getIdCliente() == cpf.getID_CLIENTE_PF()) {
                            System.out.print(cpf.getNome());
                            break;
                        }
                    }
                } else {
                    for (ClientePessoaJuridica cnpj : arrays.getClientesPJ()) {
                        if (aluguel.getIdCliente() == cnpj.getID_CLIENTE_PJ()) {
                            System.out.print(cnpj.getRazaoSocial());
                            break;
                        }
                    }
                }
                DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                System.out.printf("\tData Locado: " + (dateformat.format(aluguel.getDataLocado())));
                System.out.printf("\tData Entrega: " + (dateformat.format(aluguel.getDataEntrega())));
                System.out.printf("\tTipo Cliente: " + aluguel.getTipoCliente());
                System.out.println("\tValor: " + aluguel.getValorTotalAluguel() + "\n");
            }
        }
        System.out.println("===================================================================================================================================================");
    }
    
    /*
    * Percorre array de aluguel e caso status seja true e caso a data de
    * entrega seja menor que a data atual, então percorrerá o array de 
    * automoveis, se o idVeiculo do aluguel for igual ao idVeiculo do automovel
    * vai exibir a placa do veiculo. Após vai verificar se o tipoCliente for PF
    * ou PJ, se for pf vai percorrer o array de clientePF e exibir o nome,
    * se for PJ irá percorrer o array de clientePJ e exibir a razão Social.
    * Depois irá informar a Data Locação e Data Entrega, o tipo de cliente(PF ou PJ)
    * e após o valor do aluguel.
    */
    public void veiculosComAtraso(Arrays arrays){
        System.out.println("=============================== VEICULOS COM ATRASO ===============================");
        for (Aluguel aluguel : arrays.getAluguel()) {
            if (aluguel.isStatus() && (aluguel.getDataEntrega().compareTo(new Date()) < 0)) {
                System.out.print("PLACA: ");
                for (Automovel auto : arrays.getAutomoveis()) {
                    if (aluguel.getIdVeiculo() == auto.getID_AUTOMOVEL()) {
                        System.out.print(auto.getPlaca());
                        break;
                    }
                }
                System.out.printf("\tCLIENTE: ");//fazer if se pf ou pj
                if (aluguel.getTipoCliente().equalsIgnoreCase("PF")) {
                    for (ClientePessoaFisica cpf : arrays.getClientesPF()) {
                        if (aluguel.getIdCliente() == cpf.getID_CLIENTE_PF()) {
                            System.out.print(cpf.getNome());
                            break;
                        }
                    }
                } else {
                    for (ClientePessoaJuridica cnpj : arrays.getClientesPJ()) {
                        if (aluguel.getIdCliente() == cnpj.getID_CLIENTE_PJ()) {
                            System.out.print(cnpj.getRazaoSocial());
                            break;
                        }
                    }
                }
                DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                System.out.printf("\tData Locado: " + (dateformat.format(aluguel.getDataLocado())));
                System.out.printf("\tData Entrega: " + (dateformat.format(aluguel.getDataEntrega())));
                System.out.printf("\tTipo Cliente: " + aluguel.getTipoCliente());
                System.out.println("\tValor: " + aluguel.getValorTotalAluguel() + "\n");
            }
        }
        System.out.println("===================================================================================");
    }
    
    /*
    * Criação de array de clientes pj. Percorer o array de clientesPJ,
    * criar objeto ClientePJ, setar IDCLientePJ e a razão social no objeto
    * percorrer o array de aluguel e verificar se o idCliente aluguel é igual 
    * ao idCliente clientePJ. Caso seja igual incrementa em um contador.
    * Pega o contador e insere no atributo QtdVeiculosAlugados. Percorrerá o array
    * criado anteriormente e irá verificar se a qtd de veiculos é menor que a qtd
    * de veiculos atual no objeto, se for, irá adicionar na posição atual o objeto.
    * Caso contrario, irá inserir na ultima posição. Após irá exibir os 5 primeiros
    * que mais alugaram veiculos.
    */
    public void clientesFrequentes(Arrays arrays){
        ArrayList<ClientePessoaJuridica> clientes = new ArrayList<>();
        System.out.println("==================== 5 CLIENTES PJ FREQUENTES ====================");
            for(ClientePessoaJuridica cnpj: arrays.getClientesPJ()){
                ClientePessoaJuridica cpj = new ClientePessoaJuridica();
                cpj.setID_CLIENTE_PJ(cnpj.getID_CLIENTE_PJ());
                cpj.setRazaoSocial(cnpj.getRazaoSocial());
                int cont = 0;
                for(Aluguel alug: arrays.getAluguel()){
                    if(alug.getIdCliente() == cnpj.getID_CLIENTE_PJ() && alug.getTipoCliente().equalsIgnoreCase("PJ")){
                        cont++;
                    }
                }
                
                cpj.setQtdVeiculosAlugados(cont);
                boolean valida = false;
                for(ClientePessoaJuridica cp: clientes){
                    if(cp.getQtdVeiculosAlugados() < cpj.getQtdVeiculosAlugados()){
                        clientes.add(clientes.indexOf(cp),cpj);
                        valida = true;
                        break;
                    }
                }
                
                if(!valida){
                    clientes.add(cpj);
                }
            }
            int cont =0;
            for(ClientePessoaJuridica cp: clientes){
                cont++;
                System.out.printf("RAZAO SOCIAL: " + cp.getRazaoSocial()
                                + "\tALUGUEIS EFETUADOS: " + cp.getQtdVeiculosAlugados()
                                + "\n");
                if(cont == 5){
                    break;
                }
            }
            System.out.println("==================================================================");
    }
    
    /*
    * percorre o array de cliente e exibe a razão social e quantidade de veiculos
    */
    public void veiculosAlugadosPorEmpresa(ArrayList<ClientePessoaJuridica> cnpj){
        System.out.println("==================== VEICULOS ALUGADOS POR CLIENTES PJ ====================");
        for(ClientePessoaJuridica cpj: cnpj){
            System.out.printf("\nRAZAO SOCIAL: " + cpj.getRazaoSocial()
                             +"\tQTD Veiculos Alugados: " + cpj.getQtdVeiculosAlugados()
                             +"\n");
        }
        System.out.println("===========================================================================");
    }
}
