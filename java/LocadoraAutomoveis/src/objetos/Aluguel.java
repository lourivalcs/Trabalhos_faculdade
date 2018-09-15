package objetos;

import java.util.Date;

public class Aluguel {
    private Date dataLocado;
    private Date dataEntrega;
    private int idVeiculo;
    private int idCliente;
    private String tipoCliente;
    private float valorTotalAluguel;
    private float valorMultaAtraso;
    private boolean status;//true locado false devolvido

    public Aluguel(){
        
    }
    
    public Aluguel(Date dataLocado, Date dataEntrega, int idVeiculo, int idCliente, String tipoCliente,float valorTotalAluguel, boolean status){
        this.setDataLocado(dataLocado);
        this.setDataEntrega(dataEntrega);
        this.setIdVeiculo(idVeiculo);
        this.setIdCliente(idCliente);
        this.setTipoCliente(tipoCliente);
        this.setValorTotalAluguel(valorTotalAluguel);
        this.setValorMultaAtraso(100);
        this.setStatus(status);
    }
    
    public Date getDataLocado() {
        return dataLocado;
    }

    public void setDataLocado(Date dataLocado) {
        this.dataLocado = dataLocado;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public float getValorTotalAluguel() {
        return valorTotalAluguel;
    }

    public void setValorTotalAluguel(float valorTotalAluguel) {
        this.valorTotalAluguel = valorTotalAluguel;
    }

    public float getValorMultaAtraso() {
        return valorMultaAtraso;
    }

    public void setValorMultaAtraso(float valorMultaAtraso) {
        this.valorMultaAtraso = valorMultaAtraso;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
