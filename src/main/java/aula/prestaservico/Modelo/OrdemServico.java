package aula.prestaservico.Modelo;

import java.util.Date;
import java.util.List;

public class OrdemServico {
    private int id;
    private String observacao;
    private Date dataEntrada;
    private Date dataSaida;
    private double valorTotal;
    private Cliente cliente;
    private Veiculo veiculo;
    List<Servico> servicos;

    public OrdemServico() {}

    public OrdemServico(int id) {
        this.id = id;
    }

    public OrdemServico(String observacao, Date dataEntrada, Date dataSaida, double valorTotal, Cliente cliente, Veiculo veiculo, List<Servico> servicos) {
        this.observacao = observacao;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.servicos = servicos;
    }

    public OrdemServico(int id, String observacao, Date dataEntrada, Date dataSaida, double valorTotal, Cliente cliente, Veiculo veiculo, List<Servico> servicos) {
        this.id = id;
        this.observacao = observacao;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.servicos = servicos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }
}
