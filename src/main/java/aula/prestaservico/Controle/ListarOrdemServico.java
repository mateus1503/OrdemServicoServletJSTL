package aula.prestaservico.Controle;

import aula.prestaservico.DAO.*;
import aula.prestaservico.Modelo.Cliente;
import aula.prestaservico.Modelo.OrdemServico;
import aula.prestaservico.Modelo.Veiculo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/listarOrdemServico")
public class ListarOrdemServico extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(OrdemServicoDaoInterface ordemServicoDao = new OrdemServicoDaoClasse();
                VeiculoDaoInterface veiculoDao = new VeiculoDaoClasse())
        {
            String clienteId=request.getParameter("id");
            int id = Integer.parseInt(clienteId);

            Cliente cliente = ordemServicoDao.buscarCliente(id);
            List<OrdemServico> ordemServicos= ordemServicoDao.buscar(id);
            Veiculo veiculo = veiculoDao.buscarVeiculo(id);
            loadOrdemServico(request, ordemServicos, cliente, veiculo);
            request.getRequestDispatcher("listarOrdemServico.jsp").forward(request,response);
            System.out.println(veiculo);
        }catch (ErroDao e)
        {
            response.sendRedirect("listarCliente.jsp?mensagem=erroaotentarlistar");

        }
    }

    private static void loadOrdemServico(HttpServletRequest request, List<OrdemServico> ordemServicos, Cliente cliente, Veiculo veiculo) {
        request.setAttribute("ordemServicos", ordemServicos);
        request.setAttribute("cliente", cliente);
        request.setAttribute("veiculo", veiculo);
    }
}
