package aula.prestaservico.Modelo;

import java.util.Date;
import java.util.List;

public class OrdemServico {
    private int id;
    private int idCliente;
    private String nomeCliente,cpfCliente,enderecoCliente,telefoneCliente;
    private int numeroserieVeiculo;
    private String observacao;
    private List<Servico> servicos;
    private String dataEntrada;
    private String dataSaida;
    private double valorTotal;

    public OrdemServico() {}

    public OrdemServico(int idCliente, String nomeCliente, String cpfCliente, String enderecoCliente, String telefoneCliente
            , int numeroserieVeiculo, String observacao, String dataEntrada, String dataSaida) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.enderecoCliente = enderecoCliente;
        this.telefoneCliente = telefoneCliente;
        this.numeroserieVeiculo = numeroserieVeiculo;
        this.observacao = observacao;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.valorTotal = valorTotal;
    }

    public OrdemServico(int id, int idCliente, String nomeCliente, String cpfCliente, String enderecoCliente, String telefoneCliente
            , int numeroserieVeiculo, String observacao, List<Servico> servicos, String dataEntrada, String dataSaida, double valorTotal) {
        this.id = id;
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.enderecoCliente = enderecoCliente;
        this.telefoneCliente = telefoneCliente;
        this.numeroserieVeiculo = numeroserieVeiculo;
        this.observacao = observacao;
        this.servicos = servicos;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.valorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public int getNumeroserieVeiculo() {
        return numeroserieVeiculo;
    }

    public void setNumeroserieVeiculo(int numeroserieVeiculo) {
        this.numeroserieVeiculo = numeroserieVeiculo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<Servico> getservicos() {
        return servicos;
    }

    public void setservicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
