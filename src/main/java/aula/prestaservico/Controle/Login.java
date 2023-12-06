package aula.prestaservico.Controle;

import aula.prestaservico.DAO.*;
import aula.prestaservico.Modelo.Cliente;
import aula.prestaservico.Modelo.Usuario;
import aula.prestaservico.Util.Validador;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext aplicacao=getServletContext();
        request.setCharacterEncoding("utf-8");

        String login=request.getParameter("login");
        String senha=request.getParameter("senha");

        if(Validador.temConteudo(login)&&Validador.temConteudo(senha)){
            try (UsuarioDaoInterface dao=new UsuarioDaoClasse()){
                Usuario u=dao.buscar(login,senha);
                if(u!=null) {
                    HttpSession sessao = request.getSession();
                    Set<Usuario> usuarios= dao.buscar();
                    sessao.setAttribute("usuarios", usuarios);
                    ClienteDaoInterface daoCliente=new ClienteDaoClasse();
                    List<Cliente> clientes = daoCliente.buscar();
                    sessao.setAttribute("clientes", clientes);
                    dao.close();
                    daoCliente.close();
                    response.sendRedirect("listarCliente.jsp?mensagem=logadocomsucesso");
                }else
                    response.sendRedirect("index.jsp?mensagem=loginousenhaincorretos");
            } catch (ErroDao e) {
                //throw new RuntimeException(e);
                response.sendRedirect("index.jsp?mensagem=erroaotentarlogar");

            }
        }
        else//erro falta parâmetros
        {
            response.sendRedirect("index.jsp?mensagem=faltaparametros");
        }
    }
}
