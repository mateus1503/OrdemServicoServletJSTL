package aula.prestaservico.Modelo;

import java.util.Objects;

public class Veiculo {
    private int numeroSerie;
    private String nome, modelo, marca;
    private Cliente cliente;

    public Veiculo() {}
    public Veiculo(int numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
    public Veiculo(String nome, String modelo, String marca) {
        this.nome = nome;
        this.modelo = modelo;
        this.marca = marca;
    }
    public Veiculo(int numeroSerie, String nome, String modelo, String marca) {
        this.numeroSerie = numeroSerie;
        this.nome = nome;
        this.modelo = modelo;
        this.marca = marca;
    }

    public int getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(int numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
