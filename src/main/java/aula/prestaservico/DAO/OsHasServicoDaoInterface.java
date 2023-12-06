package aula.prestaservico.DAO;

import aula.prestaservico.Modelo.*;

import java.util.List;

public interface OsHasServicoDaoInterface extends AutoCloseable{
    public void inserir(OsHasServico o) throws ErroDao;
    public  void deletar(OsHasServico o) throws ErroDao;
    public void editar(OsHasServico o) throws ErroDao;
    @Override
    void close() throws ErroDao;
}
