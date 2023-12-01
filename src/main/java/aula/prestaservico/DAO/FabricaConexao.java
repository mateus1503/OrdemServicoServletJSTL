package aula.prestaservico.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
    public static Connection pegaConexao() throws ErroDao{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/prestaservico?useSSL=false","root","aluno");
        } catch (ClassNotFoundException | SQLException e) {
            throw new ErroDao(e);
        }
    }

    public static void main(String[] args) {
        try {
            FabricaConexao.pegaConexao();
            System.out.println("Conectado com sucesso");
        } catch (ErroDao e) {
            throw new RuntimeException(e);
        }
    }
}
