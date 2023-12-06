package aula.prestaservico.Modelo;

public class OsHasServico {
    private int id_ordemservico, id_servico;

    public OsHasServico() {
    }

    public OsHasServico(int id_ordemservico, int id_servico) {
        this.id_ordemservico = id_ordemservico;
        this.id_servico = id_servico;
    }

    public int getId_ordemservico() {
        return id_ordemservico;
    }

    public void setId_ordemservico(int id_ordemservico) {
        this.id_ordemservico = id_ordemservico;
    }

    public int getId_servico() {
        return id_servico;
    }

    public void setId_servico(int id_servico) {
        this.id_servico = id_servico;
    }
}
