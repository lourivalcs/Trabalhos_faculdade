package objetos;

import java.util.Scanner;

public class ClientePessoaFisica extends PessoaFisica{
    //true possui veiculo alugado, false não possui veiculo alugado
    private boolean possuiVeiculoAlugado;
    private int idVeiculo;
    private int ID_CLIENTE_PF;

    public ClientePessoaFisica(){
        
    }
    
    public ClientePessoaFisica(int id_cliente_PF){
        this.cadastroPessoaFisica(id_cliente_PF);
    }
    
    public ClientePessoaFisica(int id_cliente_PF, String nome, int cpf, int rg, int cnh, int idade, String rua, int numero,
                                                                                String bairro, String cidade, String estado){
        this.setID_CLIENTE_PF(id_cliente_PF);
        this.setNome(nome);
        this.setCPF(cpf);
        this.setRG(rg);
        this.setCNH(cnh);
        this.setIdade(idade);
        this.setRua(rua);
        this.setNumero(numero);
        this.setBairro(bairro);
        this.setCidade(cidade);
        this.setEstado(estado);        
    }
    
    public boolean isPossuiVeiculoAlugado() {
        return possuiVeiculoAlugado;
    }

    public void setPossuiVeiculoAlugado(boolean possuiVeiculoAlugado) {
        this.possuiVeiculoAlugado = possuiVeiculoAlugado;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }
    
    public int getID_CLIENTE_PF() {
        return ID_CLIENTE_PF;
    }

    public void setID_CLIENTE_PF(int ID_CLIENTE_PF) {
        this.ID_CLIENTE_PF = ID_CLIENTE_PF;
    }
    
    /*
    * método para cadastro de pessoa fisica
    */
    public void cadastroPessoaFisica(int id_cliente_PF){
        Scanner scanner = new Scanner(System.in);
        this.setID_CLIENTE_PF(id_cliente_PF);
        
        System.out.println("=========== CADASTRO CLIENTE PF ===========");
        System.out.printf("Nome: ");
        this.setNome(scanner.nextLine());

        System.out.printf("CPF: ");
        this.setCPF(scanner.nextInt());
        
        System.out.printf("RG: ");
        this.setRG(scanner.nextInt());
        
        System.out.printf("CNH: ");
        this.setCNH(scanner.nextInt());
        
        System.out.printf("Idade: ");
        this.setIdade(scanner.nextInt());

        scanner.nextLine();
        System.out.println(">>> ENDEREÇO <<<");
        System.out.printf("Rua: ");
        this.setRua(scanner.nextLine());
        
        System.out.printf("Nº: ");
        this.setNumero(scanner.nextInt());
        scanner.nextLine();
        System.out.printf("Bairro: ");
        this.setBairro(scanner.nextLine());
        
        System.out.printf("Cidade: ");
        this.setCidade(scanner.nextLine());
        
        System.out.printf("Estado: ");
        this.setEstado(scanner.nextLine());
        
        this.setPossuiVeiculoAlugado(false);
        System.out.println("===========================================");
    }
    
    /*
    * método para atualizar pessoa fisica
    */
    public void atualizaPessoaFisica(){
        Scanner scanner = new Scanner(System.in);
        String temp;
        System.out.println("=========== ATUALIZAR CADASTRO CLIENTE PF ===========");
        System.out.println("para manter o registro anterior, manter campo vazio");
        
        System.out.printf("Nome: ");
        temp = scanner.nextLine();
        if(!temp.isEmpty()){
            this.setNome(temp);
        }

        System.out.printf("CPF: ");
        temp = scanner.nextLine();
        if(!temp.isEmpty()){
            this.setCPF(Integer.parseInt(temp));
        }
        
        System.out.printf("RG: ");
        temp = scanner.nextLine();
        if(!temp.isEmpty()){
            this.setRG(Integer.parseInt(temp));
        }
        
        System.out.printf("CNH: ");
        temp = scanner.nextLine();
        if(!temp.isEmpty()){
            this.setCNH(Integer.parseInt(temp));
        }
        
        System.out.printf("Idade: ");
        temp = scanner.nextLine();
        if(!temp.isEmpty()){
            this.setCNH(Integer.parseInt(temp));
        }
       
        System.out.println(">>> ENDEREÇO <<<");
        System.out.printf("Rua: ");
        temp = scanner.nextLine();
        if(!temp.isEmpty()){
            this.setRua(temp);
        }
        
        System.out.printf("Nº: ");
        temp = scanner.nextLine();
        if(!temp.isEmpty()){
            this.setNumero(Integer.parseInt(temp));
        }
        
        System.out.printf("Bairro: ");
        temp = scanner.nextLine();
        if(!temp.isEmpty()){
            this.setBairro(temp);
        }
        
        System.out.printf("Cidade: ");
        temp = scanner.nextLine();
        if(!temp.isEmpty()){
            this.setCidade(temp);
        }
        
        System.out.printf("Estado: ");
        temp = scanner.nextLine();
        if(!temp.isEmpty()){
            this.setEstado(temp);
        }
        
        System.out.println("=====================================================");
    }
    
    /*
    * método para exibir pessoa fisica
    */
    public void exibePessoaFisica(){
        System.out.println("_______________________________________________");
        System.out.println("ID_PF: " + this.getID_CLIENTE_PF());
        System.out.println("Nome: " + this.getNome());
        System.out.println("CPF: " + this.getCPF());
        System.out.println("RG: " + this.getRG());
        System.out.println("CNH: " + this.getCNH());
        System.out.println("Idade: " + this.getIdade());
        System.out.println("Rua: " + this.getRua());
        System.out.println("Nº: " + this.getNumero());
        System.out.println("Bairro: " + this.getBairro());
        System.out.println("Cidade: " + this.getCidade());
        System.out.println("Estado: " + this.getEstado());
        System.out.println("Possui veiculo alugado? " + (this.isPossuiVeiculoAlugado() ? "SIM": "NÃO"));
        System.out.println("_______________________________________________");
    }
}
