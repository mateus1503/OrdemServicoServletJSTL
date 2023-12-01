package aula.prestaservico.DAO;

import aula.prestaservico.Modelo.Servico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ServicoDaoClasse implements ServicoDaoInterface{
    private Connection con;
    public ServicoDaoClasse() throws ErroDao{
        con=FabricaConexao.pegaConexao();
    }
    @Override
    public void inserir(Servico s) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement
                    ("insert into servico (nome,descricao,valor) values(?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            stm.setString(1,s.getNome());
            stm.setString(2,s.getDescricao());
            stm.setDouble(3,s.getValor());
            stm.executeUpdate();

            ResultSet rs=stm.getGeneratedKeys();
            if(rs.next()){
                s.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void deletar(Servico s) throws ErroDao {
        try {
            PreparedStatement stm = con.prepareStatement
                    ("delete from servico where id = ?");
            stm.setInt(1, s.getId());
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void editar(Servico s) throws ErroDao {
        try {
            PreparedStatement stm = con.prepareStatement
                    ("update servico set nome=?, descricao=?, valor=? where id=?");
            stm.setString(1, s.getNome());
            stm.setString(2, s.getDescricao());
            stm.setDouble(3, s.getValor());
            stm.setInt(4, s.getId());
            stm.executeUpdate();

        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public Servico buscar(String nome, String descricao) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement
                    ("select * from usuario where nome=? and descricao=?");
            stm.setString(1,nome);
            stm.setString(2,descricao);
            ResultSet rs=stm.executeQuery();
            if (rs.next()){
                Servico v=new Servico();
                v.setId(rs.getInt("id"));
                v.setNome(rs.getString("nome"));
                v.setDescricao(rs.getString("descricao"));
                v.setValor(rs.getDouble("valor"));
                return v;
            }
            return null;
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public Set<Servico> buscar() throws ErroDao {
        try {
            Set<Servico> servicos=new HashSet<>();
            PreparedStatement stm=con.prepareStatement("select * from servico");
            ResultSet rs=stm.executeQuery();
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
