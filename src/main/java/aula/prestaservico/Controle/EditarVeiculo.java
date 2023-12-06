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

@WebServlet("/editarVeiculo")
public class EditarVeiculo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario != null) {
            String veiculoNumSerie=request.getParameter("numeroSerie");
            String nome=request.getParameter("nome");
            String modelo=request.getParameter("modelo");
            String marca=request.getParameter("marca");
            int numeroSerie = Integer.parseInt(veiculoNumSerie);


            if(Validador.temConteudo(veiculoNumSerie)&&Validador.temConteudo(nome)
                    &&Validador.temConteudo(modelo)&&Validador.temConteudo(marca)) {
                Veiculo v = new Veiculo(numeroSerie,nome,modelo,marca);
                try (VeiculoDaoInterface dao = new VeiculoDaoClasse()) {
                    dao.editar(v);
                    response.sendRedirect("listarVeiculo.jsp?mensagem=editadocomsucesso");
                } catch (ErroDao e) {
                    response.sendRedirect("listarVeiculo.jsp?mensagem=falhaaotentareditar");
                }
            } else//erro falta parâmetros
            {
                response.sendRedirect("listarVeiculo.jsp?mensagem=faltaparametros");
            }
        } else {
            response.sendRedirect("index.jsp?mensagem=acessonegado");
        }
    }
}
