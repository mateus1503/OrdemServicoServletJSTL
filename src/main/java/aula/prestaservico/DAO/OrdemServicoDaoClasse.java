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
        try {
            PreparedStatement stm=con.prepareStatement
                    ("insert into ordemservico (idCliente,numeroserieVeiculo,observacao,dataEntrada,dataSaida) values (?,?,?,?,?);",PreparedStatement.RETURN_GENERATED_KEYS);
            stm.setInt(1,o.getIdCliente());
            stm.setInt(2,o.getNumeroserieVeiculo());
            stm.setString(3,o.getObservacao());
            stm.setString(4,o.getDataEntrada());
            stm.setString(5,o.getDataSaida());
            stm.executeUpdate();

            ResultSet rs=stm.getGeneratedKeys();
            if(rs.next()){
                o.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void deletar(OrdemServico o) throws ErroDao {
    }

    @Override
    public void editar(OrdemServico o) throws ErroDao {
    }

    public void atualizarValor(OrdemServico ordemServico) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement
                ("update ordemServico set valorTotal = ? where id = ?");

            stm.setDouble(1,ordemServico.getValorTotal());
            stm.setInt(2,ordemServico.getId());

            stm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public List<OrdemServico> buscar(int id) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement("select * from ordemservico where idCliente=?");
            stm.setInt(1, id);
            ResultSet rs=stm.executeQuery();
            List<OrdemServico> ordemServicos=new ArrayList<>();
            while (rs.next()){
                OrdemServico o=new OrdemServico();
                o.setId(rs.getInt("id"));
                o.setIdCliente(rs.getInt("idCliente"));
                o.setNumeroserieVeiculo(rs.getInt("numeroserieVeiculo"));
                o.setObservacao(rs.getString("observacao"));
                o.setDataEntrada(rs.getString("dataEntrada"));
                o.setDataSaida(rs.getString("dataSaida"));
                o.setValorTotal(rs.getDouble("valorTotal"));
                ordemServicos.add(o);
            }
            return ordemServicos;
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public List<OrdemServico> buscar() throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement("select * from ordemServico");
            ResultSet rs=stm.executeQuery();
            List<OrdemServico> ordemServicos=new ArrayList<>();
            while (rs.next()){
                OrdemServico s=new OrdemServico();
                s.setId(rs.getInt("id"));
                ordemServicos.add(s);
            }
            return ordemServicos;
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
