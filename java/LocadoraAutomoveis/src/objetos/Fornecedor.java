package objetos;

import java.util.Scanner;

public class Fornecedor extends PessoaJuridica{
    private int ID_FORNECEDOR;
    private String descricaoproduto;

    
    public Fornecedor(){
        
    }
    
    public Fornecedor(int id_fornecedor_PJ){
        this.cadastroFornecedor(id_fornecedor_PJ);
    }
    
    public Fornecedor(int id_fornecedor_PJ,String cnpj,String razaosocial,String rua,int numero,String bairro,String cidade,String estado,String descricao){
                                                                                                                                
        this.setID_FORNECEDOR(id_fornecedor_PJ);
        this.setCNPJ(cnpj);
        this.setRazaoSocial(razaosocial);
        this.setRua(rua);
        this.setNumero(numero);
        this.setBairro(bairro);
        this.setCidade(cidade);
        this.setEstado(estado);
        this.setDescricaoproduto(descricao);
    }  
    
    /*
    * método para cadastro de fornecedor
    */
    public void cadastroFornecedor(int id_fornecedor_PJ){
        this.setID_FORNECEDOR(id_fornecedor_PJ);
        
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
        
        System.out.printf("Descricao Produto ou servico: ");
        this.setDescricaoproduto(scanner.nextLine());
        
        System.out.println("========================================");
    }
    
    /*
    * método para exibir fornecedor
    */
    public void exibeFornecedor(){
        System.out.println("_______________________________________________");
        System.out.println("ID_FORNECEDOR: " + this.getID_FORNECEDOR());
        System.out.println("CNPJ: " + this.getCNPJ());
        System.out.println("Razao Social: " + this.getRazaoSocial());
        System.out.println("Rua: " + this.getRua());
        System.out.println("Nº: " + this.getNumero());
        System.out.println("Bairro: " + this.getBairro());
        System.out.println("Cidade: " + this.getCidade());
        System.out.println("Estado: " + this.getEstado());
        System.out.println("Produto ou Servico: " + this.getDescricaoproduto());
        System.out.println("_______________________________________________");
    }
    
    /*
    * método para atualizar fornecedor
    */
    public void atualizaFornecedor(){
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
        
        System.out.printf("Descricao Produto ou servico: ");
        temp = scanner.nextLine();
        if(!temp.isEmpty()){
            this.setDescricaoproduto(temp);
        }
        System.out.println("=====================================================");
    }
    
    public String getDescricaoproduto() {
        return descricaoproduto;
    }

    public void setDescricaoproduto(String descricaoproduto) {
        this.descricaoproduto = descricaoproduto;
    }

    public int getID_FORNECEDOR() {
        return ID_FORNECEDOR;
    }

    public void setID_FORNECEDOR(int ID_FORNECEDOR) {
        this.ID_FORNECEDOR = ID_FORNECEDOR;
    }
}
