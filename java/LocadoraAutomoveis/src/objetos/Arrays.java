package objetos;

import java.util.ArrayList;

public class Arrays {
    //variaveis contendo os ID de identificação dos objetos
    private int ID_AUTOMOVEL = 0;
    private int ID_FUNCIONARIO = 0;
    private int ID_FORNECEDOR = 0;
    private int ID_CLIENTE_PF = 0;
    private int ID_CLIENTE_PJ = 0;
    
    //criação dos arrays dos objetos
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private ArrayList<Fornecedor> fornecedores = new ArrayList<>();
    private ArrayList<ClientePessoaFisica> clientesPF = new ArrayList<>();
    private ArrayList<ClientePessoaJuridica> clientesPJ = new ArrayList<>();
    private ArrayList<Automovel> automoveis = new ArrayList<>();
    private ArrayList<Aluguel> aluguel = new ArrayList<>();

    public int getID_AUTOMOVEL() {
        this.ID_AUTOMOVEL++;
        return ID_AUTOMOVEL;
    }

    public void setID_AUTOMOVEL(int ID_AUTOMOVEL) {
        this.ID_AUTOMOVEL = ID_AUTOMOVEL;
    }

    public int getID_FUNCIONARIO() {
        this.ID_FUNCIONARIO++;
        return ID_FUNCIONARIO;
    }

    public void setID_FUNCIONARIO(int ID_FUNCIONARIO) {
        this.ID_FUNCIONARIO = ID_FUNCIONARIO;
    }

    public int getID_FORNECEDOR() {
        this.ID_FORNECEDOR++;
        return ID_FORNECEDOR;
    }

    public void setID_FORNECEDOR(int ID_FORNECEDOR) {
        this.ID_FORNECEDOR = ID_FORNECEDOR;
    }

    public int getID_CLIENTE_PF() {
        this.ID_CLIENTE_PF++;
        return ID_CLIENTE_PF;
    }

    public void setID_CLIENTE_PF(int ID_CLIENTE_PF) {
        this.ID_CLIENTE_PF = ID_CLIENTE_PF;
    }

    public int getID_CLIENTE_PJ() {
        this.ID_CLIENTE_PJ++;
        return ID_CLIENTE_PJ;
    }

    public void setID_CLIENTE_PJ(int ID_CLIENTE_PJ) {
        this.ID_CLIENTE_PJ = ID_CLIENTE_PJ;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public ArrayList<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(ArrayList<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    public ArrayList<ClientePessoaFisica> getClientesPF() {
        return clientesPF;
    }

    public void setClientesPF(ArrayList<ClientePessoaFisica> clientesPF) {
        this.clientesPF = clientesPF;
    }

    public ArrayList<ClientePessoaJuridica> getClientesPJ() {
        return clientesPJ;
    }

    public void setClientesPJ(ArrayList<ClientePessoaJuridica> clientesPJ) {
        this.clientesPJ = clientesPJ;
    }

    public ArrayList<Automovel> getAutomoveis() {
        return automoveis;
    }

    public void setAutomoveis(ArrayList<Automovel> automoveis) {
        this.automoveis = automoveis;
    }

    public ArrayList<Aluguel> getAluguel() {
        return aluguel;
    }

    public void setAluguel(ArrayList<Aluguel> aluguel) {
        this.aluguel = aluguel;
    }
}
