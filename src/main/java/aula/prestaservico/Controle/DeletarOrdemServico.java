package aula.prestaservico.Controle;

import aula.prestaservico.DAO.*;
import aula.prestaservico.Modelo.OrdemServico;
import aula.prestaservico.Modelo.OsHasServico;
import aula.prestaservico.Modelo.Servico;
import aula.prestaservico.Modelo.Usuario;
import aula.prestaservico.Util.Validador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deletarOrdemServico")
public class DeletarOrdemServico extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario != null) {
            String id_ordemServico = request.getParameter("id");
            int id = Integer.parseInt(id_ordemServico);


            if(Validador.temConteudo(id_ordemServico)) {
                try (OrdemServicoDaoInterface ordemServicoDao = new OrdemServicoDaoClasse();
                     OsHasServicoDaoInterface osHasServicoDao = new OsHasServicoDaoClasse()) {

                    OsHasServico osHasServico = new OsHasServico();

                    osHasServico.setId_ordemservico(id);
                    osHasServicoDao.deletar(osHasServico);

                    OrdemServico ordemServico = new OrdemServico(id);
                    ordemServicoDao.deletar(ordemServico);

                    response.sendRedirect("listarServico.jsp?mensagem=editadocomsucesso");
                } catch (ErroDao e) {
                    response.sendRedirect("listarServico.jsp?mensagem=falhaaotentareditar");
                }
            } else//erro falta parâmetros
            {
                response.sendRedirect("listarServico.jsp?mensagem=faltaparametros");
            }
        } else {
            response.sendRedirect("index.jsp?mensagem=acessonegado");
        }
    }
}
