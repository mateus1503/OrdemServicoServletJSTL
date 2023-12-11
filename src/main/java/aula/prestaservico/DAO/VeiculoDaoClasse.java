package aula.prestaservico.DAO;

import aula.prestaservico.Modelo.Veiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
                    ("insert into veiculo (nome,modelo,marca,id_cliente) values(?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            stm.setString(1,v.getNome());
            stm.setString(2,v.getModelo());
            stm.setString(3,v.getMarca());
            stm.setInt(4,v.getIdCliente());
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
    public Veiculo buscarVeiculo(int id) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement("select * from veiculo where numeroSerie=?");
            stm.setInt(1, id);
            ResultSet rs=stm.executeQuery();
            if (rs.next()){
                Veiculo veiculo=new Veiculo();
                veiculo.setNumeroSerie(rs.getInt("numeroSerie"));
                veiculo.setNome(rs.getString("nome"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setMarca(rs.getString("marca"));
                return veiculo;
            }
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
        return null;
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
    public List<Veiculo> buscarVeiculos(int id) throws ErroDao {
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
