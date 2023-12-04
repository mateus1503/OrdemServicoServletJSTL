package aula.prestaservico.DAO;

import aula.prestaservico.Modelo.Cliente;
import aula.prestaservico.Modelo.OrdemServico;
import aula.prestaservico.Modelo.Servico;
import aula.prestaservico.Modelo.Veiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrdemServicoDaoClasse implements OrdemServicoDaoInterface{
    private Connection con;
    public OrdemServicoDaoClasse() throws ErroDao{
        con=FabricaConexao.pegaConexao();
    }
    @Override
    public void inserir(OrdemServico o) throws ErroDao {
    }

    @Override
    public void deletar(OrdemServico o) throws ErroDao {
    }

    @Override
    public void editar(OrdemServico o) throws ErroDao {
    }

    @Override
    public Set<Cliente> buscar() throws ErroDao {
        try {
            Set<Cliente> clientes=new HashSet<>();
            PreparedStatement stm=con.prepareStatement("select * from cliente");
            ResultSet rs=stm.executeQuery();
            while (rs.next()){
                Cliente c=new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));
                clientes.add(c);
            }
            return clientes;
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public Cliente buscarCliente(int id) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement("select * from cliente where id=?");
            stm.setInt(1, id);
            ResultSet rs=stm.executeQuery();
            if (rs.next()){
                Cliente cliente=new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getString("telefone"));
                return cliente;
            }
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
        return null;
    }

    @Override
    public List<Veiculo> buscarVeiculo(int id) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement("select * from veiculo where id_cliente=?");
            stm.setInt(1, id);
            ResultSet rs=stm.executeQuery();
            List<Veiculo> veiculos=new ArrayList<>();
            while (rs.next()){
                Veiculo v=new Veiculo();
                v.setNumeroSerie(rs.getInt("numeroSerie"));
                v.setNome(rs.getString("nome"));
                v.setModelo(rs.getString("modelo"));
                v.setMarca(rs.getString("marca"));
                veiculos.add(v);
            }
            return veiculos;
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public List<Servico> buscarServico() throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement("select * from servico");
            ResultSet rs=stm.executeQuery();
            List<Servico> servicos=new ArrayList<>();
            while (rs.next()){
                Servico s=new Servico();
                s.setId(rs.getInt("id"));
                s.setNome(rs.getString("nome"));
                s.setDescricao(rs.getString("descricao"));
                s.setValor(rs.getDouble("valor"));
                servicos.add(s);
            }
            return servicos;
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void close() throws ErroDao {
        try {
            con.close();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }
}
