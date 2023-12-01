package aula.prestaservico.DAO;

import aula.prestaservico.Modelo.Cliente;
import aula.prestaservico.Modelo.Usuario;

import java.util.List;
import java.util.Set;

public interface UsuarioDaoInterface extends AutoCloseable{
    public void inserir(Usuario u) throws ErroDao;
    public  void deletar(Usuario u) throws ErroDao;
    public void editar(Usuario u) throws ErroDao;
    public Usuario buscar(String login,String senha) throws ErroDao;
    public Set<Usuario> buscar()throws ErroDao;
    @Override
    void close() throws ErroDao;
}
