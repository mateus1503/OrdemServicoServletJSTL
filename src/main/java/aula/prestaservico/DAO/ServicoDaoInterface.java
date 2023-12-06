package aula.prestaservico.DAO;

import aula.prestaservico.Modelo.Servico;

import java.util.Set;

public interface ServicoDaoInterface extends AutoCloseable{
    public void inserir(Servico s) throws ErroDao;
    public  void deletar(Servico s) throws ErroDao;
    public void editar(Servico s) throws ErroDao;
    public Servico buscar(int id) throws ErroDao;
    public Set<Servico> buscar()throws ErroDao;
    @Override
    void close() throws ErroDao;
}
