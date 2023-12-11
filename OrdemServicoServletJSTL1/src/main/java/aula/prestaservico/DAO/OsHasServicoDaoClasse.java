package aula.prestaservico.DAO;

import aula.prestaservico.Modelo.OrdemServico;
import aula.prestaservico.Modelo.OsHasServico;
import aula.prestaservico.Modelo.Servico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OsHasServicoDaoClasse implements OsHasServicoDaoInterface{
    private Connection con;
    public OsHasServicoDaoClasse() throws ErroDao{
        con=FabricaConexao.pegaConexao();
    }
    @Override
    public void inserir(OsHasServico o) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement
                    ("insert into ordemservico_has_servico (id_ordemservico,id_servico) values(?,?)");
            stm.setInt(1,o.getId_ordemservico());
            stm.setInt(2,o.getId_servico());
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void deletar(OsHasServico o) throws ErroDao {
        try {
            PreparedStatement stm = con.prepareStatement
                    ("delete from ordemservico_has_servico where id_ordemservico = ?");
            stm.setInt(1, o.getId_ordemservico());
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void editar(OsHasServico o) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement
                    ("update ordemservico_has_servico set id_ordemservico=?, id_servico=?");
            stm.setInt(1, o.getId_ordemservico());
            stm.setInt(2, o.getId_servico());
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public List<OsHasServico> buscar(int id) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement("select * from ordemservico_has_servico where id_ordemservico=?");
            stm.setInt(1, id);
            ResultSet rs=stm.executeQuery();
            List<OsHasServico> osHasServicos=new ArrayList<>();
            while (rs.next()){
                OsHasServico o=new OsHasServico();
                o.setId_ordemservico(rs.getInt("id"));
                o.setId_servico(rs.getInt("id"));
                osHasServicos.add(o);
            }
            return osHasServicos;
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
