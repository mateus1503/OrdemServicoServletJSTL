package aula.prestaservico.Controle;

import aula.prestaservico.DAO.ErroDao;
import aula.prestaservico.DAO.ServicoDaoClasse;
import aula.prestaservico.DAO.ServicoDaoInterface;
import aula.prestaservico.Modelo.Servico;
import aula.prestaservico.Util.Validador;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cadastrarServico")
public class CadastrarServico extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext aplicacao=getServletContext();
        request.setCharacterEncoding("utf-8");

        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String valorFormat = request.getParameter("valor");
        double valor = Double.parseDouble(valorFormat);


        if(Validador.temConteudo(nome)&&Validador.temConteudo(descricao)&&Validador.temConteudo(valorFormat)) {
            Servico s = new Servico(nome, descricao, valor);
            try (ServicoDaoInterface dao = new ServicoDaoClasse()) {
                dao.inserir(s);
                response.sendRedirect("cadastrarVeiculo.jsp?mensagem=cadastradocomsucesso");
            } catch (ErroDao e) {
                //throw new RuntimeException(e);
                response.sendRedirect("cadastrarVeiculo.jsp?mensagem=falhaaotentarcadastrar");
            }
        }
        else//erro falta parâmetros
        {
            response.sendRedirect("cadastrarVeiculo.jsp?mensagem=faltaparametros");
        }
    }
}
