package aula.prestaservico.DAO;

import aula.prestaservico.Modelo.Cliente;
import java.util.Set;

public interface ClienteDaoInterface extends AutoCloseable{
    public void inserir(Cliente c) throws ErroDao;
    public  void deletar(Cliente c) throws ErroDao;
    public void editar(Cliente c) throws ErroDao;
    public Set<Cliente> buscar()throws ErroDao;
    @Override
    void close() throws ErroDao;
}
