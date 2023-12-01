package aula.prestaservico.DAO;

import aula.prestaservico.Modelo.Veiculo;

import java.util.Set;

public interface VeiculoDaoInterface extends AutoCloseable{
    public void inserir(Veiculo v) throws ErroDao;
    public  void deletar(Veiculo v) throws ErroDao;
    public void editar(Veiculo v) throws ErroDao;
    public Veiculo buscar(String login,String senha) throws ErroDao;
    public Set<Veiculo> buscar()throws ErroDao;
    @Override
    void close() throws ErroDao;
}
