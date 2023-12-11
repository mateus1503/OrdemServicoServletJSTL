package aula.prestaservico.DAO;

import aula.prestaservico.Modelo.Cliente;
import aula.prestaservico.Modelo.Veiculo;

import java.util.List;
import java.util.Set;

public interface ClienteDaoInterface extends AutoCloseable{
    public void inserir(Cliente c) throws ErroDao;
    public  void deletar(Cliente c) throws ErroDao;
    public void editar(Cliente c) throws ErroDao;
    public List<Cliente> buscar()throws ErroDao;
    public List<Veiculo> buscarVeiculo(int id)throws ErroDao;
    public Cliente buscarCliente(int id)throws ErroDao;
    @Override
    void close() throws ErroDao;
}
