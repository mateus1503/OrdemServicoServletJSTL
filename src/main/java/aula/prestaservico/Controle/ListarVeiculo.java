package aula.prestaservico.Controle;

import aula.prestaservico.DAO.*;
import aula.prestaservico.Modelo.Cliente;
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
import java.util.Set;

@WebServlet("/listarVeiculo.jsp")
public class ListarVeiculo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario != null) {
            try(VeiculoDaoInterface dao=new VeiculoDaoClasse();
                OrdemServicoDaoInterface ordemServicoDao = new OrdemServicoDaoClasse())
            {
                String id=request.getParameter("id");
                int clienteid = Integer.parseInt(id);

                Cliente cliente = ordemServicoDao.buscarCliente(clienteid)
                List<Veiculo> veiculos= dao.buscarVeiculos(clienteid);
                request.setAttribute("veiculos",veiculos);
                request.setAttribute("cliente",cliente);
                request.getRequestDispatcher("/WEB-INF/listarVeiculo.jsp").forward(request,response);
            }catch (ErroDao e)
            {
                response.sendRedirect("index.jsp?mensagem=erroaotentarlistar");

            }
        } else {
            response.sendRedirect("index.jsp?mensagem=acessonegado");
        }
    }
}
