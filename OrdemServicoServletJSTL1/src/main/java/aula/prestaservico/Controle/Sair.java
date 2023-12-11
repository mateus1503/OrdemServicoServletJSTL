package aula.prestaservico.Controle;

import aula.prestaservico.Modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/sair")
public class Sair extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao=request.getSession();
        Usuario usuarioLogado=(Usuario) sessao.getAttribute("usuario");
        if(usuarioLogado!=null)
        {
            sessao.removeAttribute("usuario");
            response.sendRedirect("index.jsp?mensagem=tchau");
        }
        else
            response.sendRedirect("index.jsp");
    }
}
