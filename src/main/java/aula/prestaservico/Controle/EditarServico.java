package aula.prestaservico.Controle;

import aula.prestaservico.DAO.ServicoDaoClasse;
import aula.prestaservico.DAO.ServicoDaoInterface;
import aula.prestaservico.DAO.ErroDao;
import aula.prestaservico.Modelo.Servico;
import aula.prestaservico.Util.Validador;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/editarServico")
public class EditarServico extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext aplicacao=getServletContext();
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        String servicoId=request.getParameter("id");
        String nome=request.getParameter("nome");
        String descricao=request.getParameter("descricao");
        String servicoValor=request.getParameter("valor");
        int id = Integer.parseInt(servicoId);
        double valor=Double.parseDouble(servicoValor);


        if(Validador.temConteudo(servicoId)&&Validador.temConteudo(nome)
                &&Validador.temConteudo(descricao)&&Validador.temConteudo(servicoValor)) {
            Servico s = new Servico(id,nome,descricao,valor);
            try (ServicoDaoInterface dao = new ServicoDaoClasse()) {
                dao.editar(s);
                response.sendRedirect("listarServico.jsp?mensagem=editadocomsucesso");
            } catch (ErroDao e) {
                //throw new RuntimeException(e);
                response.sendRedirect("listarServico.jsp?mensagem=falhaaotentareditar");
            }
        }
        else//erro falta parâmetros
        {
            response.sendRedirect("listarServico.jsp?mensagem=faltaparametros");
        }
        //System.out.println(aplicacao.getAttribute("usuarios"));
    }
}
