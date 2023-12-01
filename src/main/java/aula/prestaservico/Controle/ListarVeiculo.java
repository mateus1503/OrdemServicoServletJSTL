package aula.prestaservico.Controle;

import aula.prestaservico.DAO.ErroDao;
import aula.prestaservico.DAO.VeiculoDaoClasse;
import aula.prestaservico.DAO.VeiculoDaoInterface;
import aula.prestaservico.Modelo.Veiculo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

@WebServlet("/listarVeiculo.jsp")
public class ListarVeiculo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(VeiculoDaoInterface dao=new VeiculoDaoClasse())
        {
            Set<Veiculo> veiculos= dao.buscar();
            request.setAttribute("veiculos",veiculos);
            request.getRequestDispatcher("/WEB-INF/listarVeiculo.jsp").forward(request,response);
        }catch (ErroDao e)
        {
            response.sendRedirect("index.jsp?mensagem=erroaotentarlistar");

        }
    }
}
