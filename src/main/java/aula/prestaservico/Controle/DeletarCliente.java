package aula.prestaservico.Controle;

import aula.prestaservico.DAO.ClienteDaoClasse;
import aula.prestaservico.DAO.ClienteDaoInterface;
import aula.prestaservico.DAO.ErroDao;
import aula.prestaservico.Modelo.Cliente;
import aula.prestaservico.Util.Validador;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deletarCliente")
public class DeletarCliente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext aplicacao=getServletContext();
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        String usuarioId=request.getParameter("id");
        int id = Integer.parseInt(usuarioId);

        if(Validador.temConteudo(usuarioId)) {
            Cliente c = new Cliente(id);
            try (ClienteDaoInterface dao = new ClienteDaoClasse()) {
                dao.deletar(c);
                response.sendRedirect("listarCliente.jsp?mensagem=deletadocomsucesso");
            } catch (ErroDao e) {
                //throw new RuntimeException(e);
                response.sendRedirect("listarCliente.jsp?mensagem=falhaaotentareditar");
            }
        }
        else//erro falta parâmetros
        {
            response.sendRedirect("listarCliente.jsp?mensagem=faltaparametros");
        }
    }
}
