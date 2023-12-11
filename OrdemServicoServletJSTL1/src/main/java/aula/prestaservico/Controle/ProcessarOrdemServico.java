package aula.prestaservico.Controle;

import aula.prestaservico.DAO.*;
import aula.prestaservico.Modelo.Cliente;
import aula.prestaservico.Modelo.Servico;
import aula.prestaservico.Modelo.Usuario;
import aula.prestaservico.Modelo.Veiculo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/processarOrdemServico")
public class ProcessarOrdemServico extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario != null) {
            try(OrdemServicoDaoInterface dao=new OrdemServicoDaoClasse())
            {
                String id=request.getParameter("id");
                int clienteid = Integer.parseInt(id);

                Cliente cliente= dao.buscarCliente(clienteid);
                List<Veiculo> veiculos= dao.buscarVeiculo(clienteid);
                List<Servico> servicos= dao.buscarServico();
                insertOrdemServico(request, cliente, veiculos, servicos);

                request.getRequestDispatcher("cadastrarOrdemServico.jsp").forward(request,response);
            }catch (ErroDao e)
            {
                response.sendRedirect("listarCliente.jsp?mensagem=erroaotentarlistar");
            }
        } else {
            response.sendRedirect("index.jsp?mensagem=acessonegado");
        }
    }

    private static void insertOrdemServico(HttpServletRequest request, Cliente cliente, List<Veiculo> veiculos, List<Servico> servicos) {
        request.setAttribute("cliente", cliente);
        request.setAttribute("veiculos", veiculos);
        request.setAttribute("servicos", servicos);
    }
}
