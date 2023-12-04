package aula.prestaservico.Controle;

import aula.prestaservico.DAO.ErroDao;
import aula.prestaservico.DAO.VeiculoDaoClasse;
import aula.prestaservico.DAO.VeiculoDaoInterface;
import aula.prestaservico.Modelo.Veiculo;
import aula.prestaservico.Util.Validador;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cadastrar")
public class CadastrarOrdemServico extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext aplicacao=getServletContext();
        request.setCharacterEncoding("utf-8");

        String nome = request.getParameter("nome");
        String modelo = request.getParameter("modelo");
        String marca = request.getParameter("marca");

        if(Validador.temConteudo(nome)&&Validador.temConteudo(modelo)&&Validador.temConteudo(marca)) {
            Veiculo v = new Veiculo(nome, modelo, marca);
            try (VeiculoDaoInterface dao = new VeiculoDaoClasse()) {
                dao.inserir(v);
                //response.sendRedirect("cadastrarVeiculo.jsp?mensagem=cadastradocomsucesso");
            } catch (ErroDao e) {
                //throw new RuntimeException(e);
                //response.sendRedirect("cadastrarVeiculo.jsp?mensagem=falhaaotentarcadastrar");
            }
        }
        else//erro falta parâmetros
        {
            //response.sendRedirect("cadastrarVeiculo.jsp?mensagem=faltaparametros");
        }
    }
}
