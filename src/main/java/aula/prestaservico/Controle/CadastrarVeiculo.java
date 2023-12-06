package aula.prestaservico.Controle;

import aula.prestaservico.DAO.*;
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

@WebServlet("/cadastrarVeiculo")
public class CadastrarVeiculo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario != null) {
            String nome = request.getParameter("nome");
            String modelo = request.getParameter("modelo");
            String marca = request.getParameter("marca");

            if(Validador.temConteudo(nome)&&Validador.temConteudo(modelo)&&Validador.temConteudo(marca)) {
                Veiculo v = new Veiculo(nome, modelo, marca);
                try (VeiculoDaoInterface dao = new VeiculoDaoClasse()) {
                    dao.inserir(v);
                    response.sendRedirect("cadastrarVeiculo.jsp?mensagem=cadastradocomsucesso");
                } catch (ErroDao e) {
                    response.sendRedirect("cadastrarVeiculo.jsp?mensagem=falhaaotentarcadastrar");
                }
            } else//erro falta parâmetros
            {
                response.sendRedirect("cadastrarVeiculo.jsp?mensagem=faltaparametros");
            }
        } else {
            response.sendRedirect("index.jsp?mensagem=Acesso Negado!");
        }
    }
}
