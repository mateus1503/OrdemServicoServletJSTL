package aula.prestaservico.DAO;

import aula.prestaservico.Modelo.Cliente;
import aula.prestaservico.Modelo.OrdemServico;
import aula.prestaservico.Modelo.Servico;
import aula.prestaservico.Modelo.Veiculo;

import java.util.List;
import java.util.Set;

public interface OrdemServicoDaoInterface extends AutoCloseable{
    public void inserir(OrdemServico o) throws ErroDao;
    public  void deletar(OrdemServico o) throws ErroDao;
    public void editar(OrdemServico o) throws ErroDao;
    public Set<Cliente> buscar()throws ErroDao;
    public List<Veiculo> buscarVeiculo(int id)throws ErroDao;
    public List<Servico> buscarServico()throws ErroDao;
    public Cliente buscarCliente(int id)throws ErroDao;
    @Override
    void close() throws ErroDao;
}
