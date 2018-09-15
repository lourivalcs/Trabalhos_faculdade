package objetos;

import java.util.Scanner;

public class Automovel {
    private int ID_AUTOMOVEL;
    private String placa;
    private String chassi;
    private String modelo;
    private int ano;
    private String renavan;
    private float valorAluguel;
    private boolean status; //true alugado false liberado

    public Automovel(){
        
    }
    
    public Automovel(int id_automovel){
        this.cadastroAutomovel(id_automovel);
    }
    
    public Automovel(int id_automovel, String placa, String chassi, String modelo, int ano, String renavan, float valorAluguel, boolean status){
        this.setID_AUTOMOVEL(id_automovel);
        this.setPlaca(placa);
        this.setChassi(chassi);
        this.setModelo(modelo);
        this.setAno(ano);
        this.setRenavan(renavan);
        this.setValorAluguel(valorAluguel);
        this.setStatus(status);
    }
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getRenavan() {
        return renavan;
    }

    public void setRenavan(String renavan) {
        this.renavan = renavan;
    }

    public float getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(float valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public int getID_AUTOMOVEL() {
        return ID_AUTOMOVEL;
    }

    public void setID_AUTOMOVEL(int ID_AUTOMOVEL) {
        this.ID_AUTOMOVEL = ID_AUTOMOVEL;
    }
    
    public void cadastroAutomovel(int id_automovel){
        
        Scanner scanner = new Scanner(System.in);
        this.setID_AUTOMOVEL(id_automovel);
        
        System.out.println("============CADASTRO AUTOMOVEL============");
        System.out.printf("Placa: ");
        this.setPlaca(scanner.nextLine());
        
        System.out.printf("CHASSI: ");
        this.setChassi(scanner.nextLine());
        
        System.out.printf("Modelo: ");
        this.setModelo(scanner.nextLine());
        
        System.out.printf("Ano: ");
        this.setAno(scanner.nextInt());
        scanner.nextLine();
        System.out.printf("Renavan: ");
        this.setRenavan(scanner.nextLine());
        
        System.out.printf("Valor do Aluguel: ");
        this.setValorAluguel(scanner.nextFloat());
        
        this.setStatus(false);
        System.out.println("==========================================");
    }
    
    public void AtualizarCadastro(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("=====ATUALIZAR CADASTRO AUTOMOVEL=====");
        System.out.println("para manter o registro anterior, manter campo vazio");
        
        String temp = null;
        
        System.out.printf("Placa: ");
        temp = scanner.nextLine();
        if(!temp.isEmpty()){
            this.setPlaca(temp);
            temp = null;
        }
        
        System.out.printf("Chassi: ");
        temp = scanner.nextLine();
        if(!temp.isEmpty()){
            this.setChassi(temp);
            temp = null;
        }
        
        System.out.printf("Modelo: ");
        temp = scanner.nextLine();
        if(!temp.isEmpty()){
            this.setModelo(temp);
            temp = null;
        }
        
        System.out.printf("Ano: ");
        temp = scanner.nextLine();
        if(!temp.isEmpty()){
            this.setAno(Integer.parseInt(temp));
        }
        
        System.out.printf("Renavan: ");
        temp = scanner.nextLine();
        if(!temp.isEmpty()){
            this.setRenavan(temp);
            temp = null;
        }
        
        System.out.printf("Valor Aluguel: ");
        temp = scanner.nextLine();
        if(!temp.isEmpty()){
            this.setValorAluguel(Float.parseFloat(temp));
        }
        
        System.out.println("==========================================");
    }
    
    public void exibeAutomovel(){
        System.out.println("_____________________________________________");
        System.out.println("ID_AUTO: " + this.getID_AUTOMOVEL());
        System.out.println("PLACA: "  + this.getPlaca());
        System.out.println("CHASSI: " + this.getChassi());
        System.out.println("MODELO: "  + this.getModelo());
        System.out.println("ANO: "  + this.getAno());
        System.out.println("VALOR ALUGUEL: " + this.getValorAluguel());
        System.out.println("STATUS: "  + (this.isStatus() ? "Alugado":"Liberado" ));
        System.out.println("_____________________________________________");
    }
}
