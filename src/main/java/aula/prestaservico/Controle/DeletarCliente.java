package aula.prestaservico.Controle;

import aula.prestaservico.DAO.*;
import aula.prestaservico.Modelo.Cliente;
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
import java.util.List;

@WebServlet("/deletarCliente")
public class DeletarCliente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario != null) {
            String clienteId=request.getParameter("id");
            int id = Integer.parseInt(clienteId);

            if(Validador.temConteudo(clienteId)) {
                Cliente c = new Cliente(id);
                try (ClienteDaoInterface daoCliente = new ClienteDaoClasse();
                     VeiculoDaoInterface daoVeiculo = new VeiculoDaoClasse()) {

                    List<Veiculo> veiculos= daoVeiculo.buscarVeiculos(id);

                    for (Veiculo veiculo : veiculos) {
                        daoVeiculo.deletar(veiculo);
                    }

                    daoCliente.deletar(c);
                    response.sendRedirect("listarCliente.jsp?mensagem=deletadocomsucesso");
                } catch (ErroDao e) {
                    response.sendRedirect("listarCliente.jsp?mensagem=comordemservico");
                }
            } else//erro falta parâmetros
            {
                response.sendRedirect("listarCliente.jsp?mensagem=faltaparametros");
            }
        } else {
            response.sendRedirect("index.jsp?mensagem=acessonegado");
        }
    }
}
