package aula.prestaservico.DAO;

import aula.prestaservico.Modelo.Veiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class VeiculoDaoClasse implements VeiculoDaoInterface{
    private Connection con;
    public VeiculoDaoClasse() throws ErroDao{
        con=FabricaConexao.pegaConexao();
    }
    @Override
    public void inserir(Veiculo v) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement
                    ("insert into veiculo (nome,modelo,marca) values(?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            stm.setString(1,v.getNome());
            stm.setString(2,v.getModelo());
            stm.setString(3,v.getMarca());
            stm.executeUpdate();

            ResultSet rs=stm.getGeneratedKeys();
            if(rs.next()){
                v.setNumeroSerie(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void deletar(Veiculo v) throws ErroDao {
        try {
            PreparedStatement stm = con.prepareStatement
                    ("delete from veiculo where numeroSerie = ?");
            stm.setInt(1, v.getNumeroSerie());
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void editar(Veiculo v) throws ErroDao {
        try {
            PreparedStatement stm = con.prepareStatement
                    ("update veiculo set nome=?, modelo=?, marca=? where numeroSerie=?");
            stm.setString(1, v.getNome());
            stm.setString(2, v.getModelo());
            stm.setString(3, v.getMarca());
            stm.setInt(4, v.getNumeroSerie());
            stm.executeUpdate();

        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public Veiculo buscar(String modelo, String marca) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement("select * from usuario where modelo=? and marca=?");
            stm.setString(1,modelo);
            stm.setString(2,marca);
            ResultSet rs=stm.executeQuery();
            if (rs.next()){
                Veiculo v=new Veiculo();
                v.setNumeroSerie(rs.getInt("numeroSerie"));
                v.setNome(rs.getString("nome"));
                v.setModelo(rs.getString("modelo"));
                v.setMarca(rs.getString("marca"));
                return v;
            }
            return null;
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public Set<Veiculo> buscar() throws ErroDao {
        try {
            Set<Veiculo> veiculos=new HashSet<>();
            PreparedStatement stm=con.prepareStatement("select * from veiculo");
            ResultSet rs=stm.executeQuery();
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
