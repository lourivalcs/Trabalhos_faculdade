package objetos;

import java.util.Scanner;

public class Funcionario extends PessoaFisica{
    private int ID_FUNCIONARIO;
    private String funcao;
    private float salario;

    public Funcionario(){
        
    }
    
    public Funcionario(int idFuncionario){
        this.cadastroFuncionario(idFuncionario);
    }
    
    public Funcionario(int id_funcionario, String nome, int cpf, int rg, int cnh, int idade, String rua, int numero,
                                                                        String bairro, String cidade, String estado, String funcao, float salario){
        this.setID_FUNCIONARIO(id_funcionario);
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
        this.setFuncao(funcao);
        this.setSalario(salario);
        
    }
    
    /*
    * método para cadastro de funcionario
    */
    public void cadastroFuncionario(int idFuncionario){
        Scanner scanner = new Scanner(System.in);
        this.setID_FUNCIONARIO(idFuncionario);
        
        System.out.println("=========== CADASTRO DE FUNCIONARIO ===========");
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
        
        System.out.printf("Funcao: ");
        this.setFuncao(scanner.nextLine());
        
        System.out.print("Salario: ");
        this.setSalario(scanner.nextFloat());
        
        System.out.println("===========================================");
    }
    
    /*
    * método para atualizar funcionario
    */
    public void atualizaFuncionario(){
        Scanner scanner = new Scanner(System.in);
        String temp;
        System.out.println("=========== ATUALIZAR CADASTRO FUNCIONARIO ===========");
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
        
        System.out.printf("Funcao: ");
        temp = scanner.nextLine();
        if(!temp.isEmpty()){
            this.setFuncao(temp);
        }
        
        System.out.printf("Salario: ");
        temp = scanner.nextLine();
        if(!temp.isEmpty()){
            this.setSalario(Float.parseFloat(temp));
        }
        
        System.out.println("=====================================================");
    }
    
    /*
    * método para exibir funcionario
    */
    public void exibeFuncionario(){
        System.out.println("_______________________________________________");
        System.out.println("ID_FUNCIONARIO: " + this.getID_FUNCIONARIO());
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
        System.out.println("Funcao: " + this.getFuncao());
        System.out.println("Salario: " + this.getSalario());
        System.out.println("_______________________________________________");
    }

    
    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getID_FUNCIONARIO() {
        return ID_FUNCIONARIO;
    }

    public void setID_FUNCIONARIO(int ID_FUNCIONARIO) {
        this.ID_FUNCIONARIO = ID_FUNCIONARIO;
    }
}
