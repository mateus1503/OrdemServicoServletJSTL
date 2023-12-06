package aula.prestaservico.Controle;

import aula.prestaservico.DAO.ErroDao;
import aula.prestaservico.DAO.VeiculoDaoClasse;
import aula.prestaservico.DAO.VeiculoDaoInterface;
import aula.prestaservico.Modelo.Usuario;
import aula.prestaservico.Modelo.Veiculo;
import aula.prestaservico.Util.Validador;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deletarVeiculo")
public class DeletarVeiculo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario != null) {String veiculoNumSerie=request.getParameter("numeroSerie");
            int numeroSerie = Integer.parseInt(veiculoNumSerie);

            if(Validador.temConteudo(veiculoNumSerie)) {
                Veiculo v = new Veiculo(numeroSerie);
                try (VeiculoDaoInterface dao = new VeiculoDaoClasse()) {
                    dao.deletar(v);
                    response.sendRedirect("listarServico.jsp?mensagem=deletadocomsucesso");
                } catch (ErroDao e) {
                    response.sendRedirect("index.jsp?mensagem=falhaaotentareditar");
                }
            } else//erro falta parâmetros
            {
                response.sendRedirect("index.jsp?mensagem=faltaparametros");
            }
        } else {
            response.sendRedirect("index.jsp?mensagem=Acesso Negado!");
        }
    }
}
