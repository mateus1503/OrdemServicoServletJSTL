package aula.prestaservico.Controle;

import aula.prestaservico.DAO.ErroDao;
import aula.prestaservico.DAO.OrdemServicoDaoClasse;
import aula.prestaservico.DAO.OrdemServicoDaoInterface;
import aula.prestaservico.Modelo.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/processarEditarOS")
public class ProcessarEditarOS extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario != null) {
            try(OrdemServicoDaoInterface dao=new OrdemServicoDaoClasse())
            {
                String id=request.getParameter("id");
                String idCliente=request.getParameter("idCliente");
                int ordemservicoid = Integer.parseInt(id);
                int clienteid = Integer.parseInt(idCliente);

                Cliente cliente= dao.buscarCliente(clienteid);
                List<Veiculo> veiculos= dao.buscarVeiculo(clienteid);
                List<Servico> servicos= dao.buscarServico();
                OrdemServico ordemServico = dao.buscarOrdemServico(ordemservicoid);
                insertOrdemServico(request, cliente, veiculos, servicos, ordemServico);

                request.getRequestDispatcher("editarOrdemServico.jsp").forward(request,response);
            }catch (ErroDao e)
            {
                response.sendRedirect("listarCliente.jsp?mensagem=erroaotentarlistar");
            }
        } else {
            response.sendRedirect("index.jsp?mensagem=acessonegado");
        }
    }

    private static void insertOrdemServico(HttpServletRequest request, Cliente cliente,
                                           List<Veiculo> veiculos, List<Servico> servicos, OrdemServico ordemServico) {
        request.setAttribute("cliente", cliente);
        request.setAttribute("veiculos", veiculos);
        request.setAttribute("servicos", servicos);
        request.setAttribute("ordemServico", ordemServico);
    }
}
