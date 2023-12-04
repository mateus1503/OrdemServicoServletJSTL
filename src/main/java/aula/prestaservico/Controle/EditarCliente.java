package aula.prestaservico.Controle;

import aula.prestaservico.DAO.ErroDao;
import aula.prestaservico.DAO.ClienteDaoInterface;
import aula.prestaservico.DAO.ClienteDaoClasse;
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

@WebServlet("/editarCliente")
public class EditarCliente extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext aplicacao=getServletContext();
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        String clienteId=request.getParameter("id");
        String nome=request.getParameter("nome");
        String endereco=request.getParameter("endereco");
        String telefone=request.getParameter("telefone");
        String cpf=request.getParameter("cpf");
        int id = Integer.parseInt(clienteId);

        if(Validador.temConteudo(clienteId)&&Validador.temConteudo(nome)&&Validador.temConteudo(endereco)
                &&Validador.temConteudo(telefone)&&Validador.temConteudo(cpf)) {
            Cliente c = new Cliente(id,nome,endereco,telefone,cpf);
            try (ClienteDaoInterface dao = new ClienteDaoClasse()) {
                dao.editar(c);
                response.sendRedirect("listarCliente.jsp?mensagem=editadocomsucesso");
            } catch (ErroDao e) {
                //throw new RuntimeException(e);
                response.sendRedirect("listarCliente.jsp?mensagem=falhaaotentareditar");
            }
        }
        else//erro falta parâmetros
        {
            response.sendRedirect("listarCliente.jsp?mensagem=faltaparametros");
        }
        //System.out.println(aplicacao.getAttribute("usuarios"));
    }
}
