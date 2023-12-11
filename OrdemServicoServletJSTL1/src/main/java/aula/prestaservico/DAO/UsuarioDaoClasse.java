package aula.prestaservico.DAO;

import aula.prestaservico.Modelo.Cliente;
import aula.prestaservico.Modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UsuarioDaoClasse implements UsuarioDaoInterface{
    private Connection con;
    public UsuarioDaoClasse() throws ErroDao{
        con=FabricaConexao.pegaConexao();
    }
    @Override
    public void inserir(Usuario u) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement
                    ("insert into usuario (nome,login,senha) values(?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            stm.setString(1,u.getNome());
            stm.setString(2,u.getLogin());
            stm.setString(3,u.getSenha());
            stm.executeUpdate();

            ResultSet rs=stm.getGeneratedKeys();
            if(rs.next()){
                u.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void deletar(Usuario u) throws ErroDao {
        try {
            PreparedStatement stm = con.prepareStatement
                    ("delete from usuario where id = ?");
            stm.setInt(1, u.getId());
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void editar(Usuario u) throws ErroDao {
        try {
            PreparedStatement stm = con.prepareStatement
                    ("update usuario set nome=?, login=?, senha=? where id=?");
            stm.setString(1, u.getNome());
            stm.setString(2, u.getLogin());
            stm.setString(3, u.getSenha());
            stm.setInt(4, u.getId());
            stm.executeUpdate();

        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public Usuario buscar(String login, String senha) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement("select * from usuario where login=? and senha=?");
            stm.setString(1,login);
            stm.setString(2,senha);
            ResultSet rs=stm.executeQuery();
            if (rs.next()){
                Usuario u=new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                return u;
            }
            return null;
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public Set<Usuario> buscar() throws ErroDao {
        try {
            Set<Usuario> usuarios=new HashSet<>();
            PreparedStatement stm=con.prepareStatement("select * from usuario");
            ResultSet rs=stm.executeQuery();
            while (rs.next()){
                Usuario u=new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                usuarios.add(u);
            }
            return usuarios;
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
