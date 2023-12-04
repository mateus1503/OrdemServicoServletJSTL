package aula.prestaservico.Controle;

import aula.prestaservico.DAO.ClienteDaoClasse;
import aula.prestaservico.DAO.ErroDao;
import aula.prestaservico.DAO.ClienteDaoInterface;
import aula.prestaservico.Modelo.Cliente;
import aula.prestaservico.Util.Validador;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cadastrarCliente")
public class CadastrarCliente extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext aplicacao=getServletContext();
        request.setCharacterEncoding("utf-8");

        String nome=request.getParameter("nome");
        String endereco=request.getParameter("endereco");
        String telefone=request.getParameter("telefone");
        String cpf=request.getParameter("cpf");

        if(Validador.temConteudo(nome)&&Validador.temConteudo(endereco)
                &&Validador.temConteudo(telefone)&&Validador.temConteudo(cpf)) {
            Cliente c = new Cliente(nome,endereco,telefone,cpf);
            try (ClienteDaoInterface dao = new ClienteDaoClasse()) {
                dao.inserir(c);
                response.sendRedirect("listarCliente.jsp?mensagem=cadastradocomsucesso");
            } catch (ErroDao e) {
                //throw new RuntimeException(e);
                response.sendRedirect("cadastrarCliente.jsp?mensagem=falhaaotentarcadastrar");
            }
        }
        else//erro falta parâmetros
        {
            response.sendRedirect("cadastrarCliente.jsp?mensagem=faltaparametros");
        }
        //System.out.println(aplicacao.getAttribute("usuarios"));
    }
}
