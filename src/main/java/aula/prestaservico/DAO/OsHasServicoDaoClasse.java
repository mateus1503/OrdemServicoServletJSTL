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
    }

    @Override
    public void editar(OsHasServico o) throws ErroDao {
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