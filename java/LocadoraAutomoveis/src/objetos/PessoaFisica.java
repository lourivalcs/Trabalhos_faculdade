package objetos;

public class PessoaFisica extends Pessoa{
    private String nome;
    private int CPF;
    private int RG;
    private int CNH;
    private int idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public int getRG() {
        return RG;
    }

    public void setRG(int RG) {
        this.RG = RG;
    }

    public int getCNH() {
        return CNH;
    }

    public void setCNH(int CNH) {
        this.CNH = CNH;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
}
