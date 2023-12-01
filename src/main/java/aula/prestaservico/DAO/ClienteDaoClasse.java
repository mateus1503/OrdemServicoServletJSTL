package aula.prestaservico.DAO;

import aula.prestaservico.Modelo.Cliente;

import java.sql.*;
import java.util.HashSet;
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
                    ("insert into cliente (nome,endereco,telefone) values(?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            stm.setString(1,c.getNome());
            stm.setString(2,c.getEndereco());
            stm.setString(3,c.getTelefone());
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
                    ("update cliente set nome=?, endereco=?, telefone=? where id=?");
            stm.setString(1, c.getNome());
            stm.setString(2, c.getEndereco());
            stm.setString(3, c.getTelefone());
            stm.setInt(4, c.getId());
            stm.executeUpdate();

        } catch (SQLException e) {
            throw new ErroDao(e);
        }
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
    public void close() throws ErroDao {
        try {
            con.close();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }
}
