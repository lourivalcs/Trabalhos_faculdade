package objetos;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientePessoaJuridica extends PessoaJuridica{
    
    private int ID_CLIENTE_PJ;
    private int qtdVeiculosAlugados = 0;
    private ArrayList<Integer> idVeiculos = new ArrayList<>();

    public ClientePessoaJuridica(){
        
    }
    
    public ClientePessoaJuridica(int idClientePJ){
        this.cadastroPessoaJuridica(idClientePJ);
    }
    
    public ClientePessoaJuridica(int id_cliente_PJ,String cnpj,String razaosocial,String rua,int numero, String bairro, String cidade, String estado){
                                                                                                                                
        this.setID_CLIENTE_PJ(id_cliente_PJ);
        this.setCNPJ(cnpj);
        this.setRazaoSocial(razaosocial);
        this.setRua(rua);
        this.setNumero(numero);
        this.setBairro(bairro);
        this.setCidade(cidade);
        this.setEstado(estado);        
    }  
    
    /*
    * método para cadastro de pessoa juridica
    */
    public void cadastroPessoaJuridica(int idClientePJ){
        this.setID_CLIENTE_PJ(idClientePJ);
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("============ CADASTRO DE PJ ============");
        System.out.print("Informe o CNPJ: ");
        this.setCNPJ(scanner.nextLine());
        
        System.out.print("Informe a Razao Social: ");
        this.setRazaoSocial(scanner.nextLine());
        
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
        
        System.out.println("========================================");
    }
    
    /*
    * método para cadastro de pessoa juridica
    */
    public void exibePessoaJuridica(){
        System.out.println("_______________________________________________");
        System.out.println("ID_PJ: " + this.getID_CLIENTE_PJ());
        System.out.println("CNPJ: " + this.getCNPJ());
        System.out.println("Razao Social: " + this.getRazaoSocial());
        System.out.println("Rua: " + this.getRua());
        System.out.println("Nº: " + this.getNumero());
        System.out.println("Bairro: " + this.getBairro());
        System.out.println("Cidade: " + this.getCidade());
        System.out.println("Estado: " + this.getEstado());
        System.out.println("_______________________________________________");
    }
    
    /*
    * método para atualizar pessoa juridica
    */
    public void atualizaPessoaJuridica(){
        Scanner scanner = new Scanner(System.in);
        String temp;
        System.out.println("=========== ATUALIZAR CADASTRO CLIENTE PJ ===========");
        System.out.println("para manter o registro anterior, manter campo vazio");
        
        System.out.printf("CNPJ: ");
        temp = scanner.nextLine();
        if(!temp.isEmpty()){
            this.setCNPJ(temp);
        }

        System.out.printf("Razao Social: ");
        temp = scanner.nextLine();
        if(!temp.isEmpty()){
            this.setRazaoSocial(temp);
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
    
    public int getQtdVeiculosAlugados() {
        return qtdVeiculosAlugados;
    }

    public void setQtdVeiculosAlugados(int qtdVeiculosAlugados) {
        this.qtdVeiculosAlugados = qtdVeiculosAlugados;
    }

    public ArrayList<Integer> getIdVeiculos() {
        return idVeiculos;
    }

    public void setIdVeiculos(ArrayList<Integer> idVeiculos) {
        this.idVeiculos = idVeiculos;
    }

    public int getID_CLIENTE_PJ() {
        return ID_CLIENTE_PJ;
    }

    public void setID_CLIENTE_PJ(int ID_CLIENTE_PJ) {
        this.ID_CLIENTE_PJ = ID_CLIENTE_PJ;
    }

}
