package start;

import java.util.Calendar;
import java.util.Date;
import objetos.Aluguel;
import objetos.Arrays;
import objetos.Automovel;
import objetos.ClientePessoaFisica;
import objetos.ClientePessoaJuridica;
import objetos.Fornecedor;
import objetos.Funcionario;

public class InsereDadosSoftware {
    public InsereDadosSoftware(Arrays arrays){
        /*
        *utiliza o recurso de passagem pelo contrutor para inserir cadastros nos arrays
        */
        arrays.getAutomoveis().add(new Automovel(arrays.getID_AUTOMOVEL(), "IIJ5682", "965232S30SDF3", "RANGE ROVER", 2016, "96586925", (float)1500, false));
        arrays.getAutomoveis().add(new Automovel(arrays.getID_AUTOMOVEL(), "ADV9658", "265DE5DE26566", "PORSCHE", 2016, "6589359", (float)2000, false));
        arrays.getAutomoveis().add(new Automovel(arrays.getID_AUTOMOVEL(), "ADE8952", "DE62D6E2D6262", "AUDI R8", 2016, "78565626", (float)1800, false));
        arrays.getAutomoveis().add(new Automovel(arrays.getID_AUTOMOVEL(), "RER5632", "F1E15FEF5E125", "FERRARY", 2016, "985225959", (float)5000, false));
        arrays.getAutomoveis().add(new Automovel(arrays.getID_AUTOMOVEL(), "DWE9862", "JYJ5Y1H51Y5HY", "LAMBORGHINI", 2016, "56568165", (float)4500, false));
        arrays.getAutomoveis().add(new Automovel(arrays.getID_AUTOMOVEL(), "DER6325", "H15H1Y1HY55D1F", "ROLLS-ROYCE", 2016, "8982646", (float)2500, false));
        arrays.getAutomoveis().add(new Automovel(arrays.getID_AUTOMOVEL(), "HTY8569", "DASD6SD565DFE5", "JAGUAR XJ", 2016, "78934523", (float)2600, false));
        
        arrays.getClientesPF().add(new ClientePessoaFisica(arrays.getID_CLIENTE_PF(), "Fabio", 2012331, 90341179, 586545246, 26, "Rua do Fabio", 221, "Sao jorge", "Guaiba", "RS"));
        arrays.getClientesPF().add(new ClientePessoaFisica(arrays.getID_CLIENTE_PF(), "Gabriel", 562660, 656560, 6565650, 25, "Rua do Gabriel", 205, "Bairro  do Gabriel", "Cidade do Gabriel", "RJ"));
        arrays.getClientesPF().add(new ClientePessoaFisica(arrays.getID_CLIENTE_PF(), "Ailton", 1465650, 45656560, 565650, 29, "Rua do Ailton", 180, "Bairro do Ailton", "Cidade do Ailton", "RS"));
        arrays.getClientesPF().add(new ClientePessoaFisica(arrays.getID_CLIENTE_PF(), "Cleyton", 2556550, 2332320, 32320, 28, "Rua do Cleyton", 2129, "Bairro do Cleyton", "Cidade do Cleyton", "SC"));
        arrays.getClientesPF().add(new ClientePessoaFisica(arrays.getID_CLIENTE_PF(), "Lilian", 3232320, 122120,33232, 24, "Rua da Lilian", 10, "Bairro da Lilian", "Cidade da Lilian", "PR"));
        arrays.getClientesPF().add(new ClientePessoaFisica(arrays.getID_CLIENTE_PF(), "Daniela", 432423420, 42342340,5689556, 23, "Rua da Daniela", 560, "Bairro da Daniela", "Cidade da Daniela", "RS"));
        arrays.getClientesPF().add(new ClientePessoaFisica(arrays.getID_CLIENTE_PF(), "Marcelo", 653345340, 543530, 534534530, 36, "Rua do Marcelo", 120, "Bairro do Marcelo", "Cidade do Marcelo", "SP"));
        arrays.getClientesPF().add(new ClientePessoaFisica(arrays.getID_CLIENTE_PF(), "Silvio", 31231230, 32131230, 0312312321, 29, "Rua do Silvio", 1110, "Bairro do Silvio", "Cidade do Silvio", "RJ"));
        arrays.getClientesPF().add(new ClientePessoaFisica(arrays.getID_CLIENTE_PF(), "Eli", 23230, 32320, 32320, 28, "Rua do Eli", 856, "Bairro do Eli", "Cidade do Eli", "SC"));
        
        arrays.getClientesPJ().add(new ClientePessoaJuridica(arrays.getID_CLIENTE_PJ(), "12568965000152","FTEC POA", "RUA FTEC POA", 1000, "CENTRO", "PORTO ALEGRE", "RS"));
        arrays.getClientesPJ().add(new ClientePessoaJuridica(arrays.getID_CLIENTE_PJ(), "65955596000236","FTEC POA ZONA NORTE", "RUA FTEC POA ZONA NORTE", 1500, "ZONA NORTE", "PORTO ALEGRE", "RS"));
        arrays.getClientesPJ().add(new ClientePessoaJuridica(arrays.getID_CLIENTE_PJ(), "25595262000256", "FTEC NOVO HAMBURGO", "RUA FTEC NOVO HAMBURGO", 2000, "NH", "NOVO HAMBURGO", "RS"));
        arrays.getClientesPJ().add(new ClientePessoaJuridica(arrays.getID_CLIENTE_PJ(), "65256265000156", "FTEC CAXIAS DO SUL", "RUA FTEC CAXIAS DO SUL", 2500, "CX", "CAXIAS DO SUL", "RS"));
        arrays.getClientesPJ().add(new ClientePessoaJuridica(arrays.getID_CLIENTE_PJ(), "56565664000288", "FTEC BENTO GONCALVES", "RUA FTEC BENTO GONCALVES", 3000, "BG", "BENGO GONCALVES", "RS"));
        arrays.getClientesPJ().add(new ClientePessoaJuridica(arrays.getID_CLIENTE_PJ(), "56235621000165", "FTEC 01", "RUA FTEC 01", 3500, "F01", "PORTO ALEGRE", "RS"));
        arrays.getClientesPJ().add(new ClientePessoaJuridica(arrays.getID_CLIENTE_PJ(), "96586246000158", "FTEC 02", "RUA FTEC 02", 4000, "F02", "FLORIANOPOLIS", "SC"));
        arrays.getClientesPJ().add(new ClientePessoaJuridica(arrays.getID_CLIENTE_PJ(), "98545624000155", "FTEC 03", "RUA FTEC 03", 4500, "F03", "SAO PAULO", "SP"));
        
        arrays.getFuncionarios().add(new Funcionario(arrays.getID_FUNCIONARIO(), "Lourival", 565656, 8888888, 900009, 35, "Rua do Lourival", 2563, "Bairro do Lourival", "Cidade do Lourival", "Estado do Lourival", "DONO", 100000));
        arrays.getFuncionarios().add(new Funcionario(arrays.getID_FUNCIONARIO(), "Lucas", 11111111, 5555555, 9999999, 35, "Rua do Lucas", 2563, "Bairro do Lucas", "Cidade do Lucas", "Estado do Lucas", "Atendente", 3500));
        arrays.getFuncionarios().add(new Funcionario(arrays.getID_FUNCIONARIO(), "Renato", 222222222, 6666666, 8888888, 80, "Rua do Renato", 1122, "Bairro do Renato", "Cidade do Renato", "Estado do Renato", "Gerente", 9000));
        arrays.getFuncionarios().add(new Funcionario(arrays.getID_FUNCIONARIO(), "Marcos", 333333333, 7777777, 7777777, 40, "Rua do Marcos", 2582, "Bairro do Marcos", "Cidade do Marcos", "Estado do Marcos", "Atendente", 3500));
        arrays.getFuncionarios().add(new Funcionario(arrays.getID_FUNCIONARIO(), "mauricio", 444444444, 8888888, 6666666, 65, "Rua do Mauricio", 9856, "Bairro do Mauricio", "Cidade do Mauricio", "Estado do Mauricio", "Auxiliar", 2000));
        
        arrays.getFornecedores().add(new Fornecedor(arrays.getID_FORNECEDOR(), "85469852000123", "Servicos", "Rua", 200, "Centro", "Porto Alegre", "RS", "Manutenção de automoveis"));
        
        Date dt = new Date();
        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal.setTime(dt);
        cal2.setTime(dt);
        cal2.add(Calendar.DATE, 5);
        
        
        arrays.getAutomoveis().get(0).setStatus(true);
        arrays.getClientesPJ().get(0).getIdVeiculos().add(1);
        arrays.getClientesPJ().get(0).setQtdVeiculosAlugados(1);
        arrays.getAluguel().add(new Aluguel(cal.getTime(), cal2.getTime(), 1, 1, "PJ", 1500*5, true));
        
        /*arrays.getAutomoveis().get(1).setStatus(true);
        arrays.getClientesPJ().get(0).getIdVeiculos().add(2);
        arrays.getClientesPJ().get(0).setQtdVeiculosAlugados(2);*/
        cal.setTime(dt);cal2.setTime(dt);cal.add(Calendar.DATE, -10); cal2.add(Calendar.DATE, -8);
        arrays.getAluguel().add(new Aluguel(cal.getTime(), cal2.getTime(), 2, 1, "PJ", 2000*2, false));
        
        arrays.getAutomoveis().get(2).setStatus(true);
        arrays.getClientesPJ().get(0).getIdVeiculos().add(3);
        arrays.getClientesPJ().get(0).setQtdVeiculosAlugados(3);
        cal.setTime(dt);cal2.setTime(dt);cal.add(Calendar.DATE, -5); cal2.add(Calendar.DATE, -2);
        arrays.getAluguel().add(new Aluguel(cal.getTime(), cal2.getTime(), 3, 1, "PJ", 1800*3, true));
        
        /*arrays.getAutomoveis().get(3).setStatus(true);
        arrays.getClientesPJ().get(0).getIdVeiculos().add(4);
        arrays.getClientesPJ().get(0).setQtdVeiculosAlugados(4);*/
        cal.setTime(dt);cal2.setTime(dt);cal.add(Calendar.DATE, -20); cal2.add(Calendar.DATE, -16);
        arrays.getAluguel().add(new Aluguel(cal.getTime(), cal2.getTime(), 4, 1, "PJ", 5000*4,false));
        
        arrays.getAutomoveis().get(4).setStatus(true);
        arrays.getClientesPF().get(0).setPossuiVeiculoAlugado(true);
        arrays.getClientesPF().get(0).setIdVeiculo(5);
        cal.setTime(dt);cal2.setTime(dt);cal.add(Calendar.DATE, -3); cal2.add(Calendar.DATE, -1);
        arrays.getAluguel().add(new Aluguel(cal.getTime(), cal2.getTime(), 5, 1, "PF", 1500*5, true));
    }
}
