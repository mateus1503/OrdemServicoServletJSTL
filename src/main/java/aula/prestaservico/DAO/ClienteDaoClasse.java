package aula.prestaservico.DAO;

import aula.prestaservico.Modelo.Cliente;
import aula.prestaservico.Modelo.Veiculo;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClienteDaoClasse implements ClienteDaoInterface{
    private Connection con;
    public ClienteDaoClasse() throws ErroDao{
        con=FabricaConexao.pegaConexao();
    }
    @Override
    public void inserir(Cliente c) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement
                    ("insert into cliente (nome,endereco,telefone,cpf) values(?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            stm.setString(1,c.getNome());
            stm.setString(2,c.getEndereco());
            stm.setString(3,c.getTelefone());
            stm.setString(4,c.getCpf());
            stm.executeUpdate();

            ResultSet rs=stm.getGeneratedKeys();
            if(rs.next()){
                c.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void deletar(Cliente c) throws ErroDao {
        try {
            PreparedStatement stm = con.prepareStatement
                    ("delete from cliente where id = ?");
            stm.setInt(1, c.getId());
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void editar(Cliente c) throws ErroDao {
        try {
            PreparedStatement stm = con.prepareStatement
                    ("update cliente set nome=?, endereco=?, telefone=?, cpf=? where id=?");
            stm.setString(1, c.getNome());
            stm.setString(2, c.getEndereco());
            stm.setString(3, c.getTelefone());
            stm.setString(4, c.getCpf());
            stm.setInt(5, c.getId());
            stm.executeUpdate();

        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public List<Cliente> buscar() throws ErroDao {
        try {
            List<Cliente> clientes=new ArrayList<>();
            PreparedStatement stm=con.prepareStatement("select * from cliente");
            ResultSet rs=stm.executeQuery();
            while (rs.next()){
                Cliente c=new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));
                c.setCpf(rs.getString("cpf"));
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
    public void close() throws ErroDao {
        try {
            con.close();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }
}
