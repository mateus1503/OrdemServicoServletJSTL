package aula.prestaservico.Controle;

import aula.prestaservico.DAO.*;
import aula.prestaservico.Modelo.OrdemServico;
import aula.prestaservico.Util.Validador;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/cadastrar")
public class CadastrarOrdemServico extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext aplicacao=getServletContext();
        request.setCharacterEncoding("utf-8");

        String idCliente = request.getParameter("idcliente");
        int id_cliente = Integer.parseInt(idCliente);
        String nomeCliente = request.getParameter("nomecliente");
        String cpfCliente = request.getParameter("cpfcliente");
        String enderecoCliente = request.getParameter("enderecoCliente");
        String telefoneCliente = request.getParameter("telefonecliente");
        String numeroserieVeiculo = request.getParameter("numeroserieveiculo");
        int id_numeroserieveiculo = Integer.parseInt(numeroserieVeiculo);
        String observacao = request.getParameter("observacao");
        String idServico = request.getParameter("idservico");
        String dataEntrada = request.getParameter("dataEntrada");
        LocalDate dataentrada_Formatada = LocalDate.parse(dataEntrada);
        String dataSaida = request.getParameter("dataSaida");
        LocalDate datasaida_Formatada = LocalDate.parse(dataSaida);

        if(Validador.temConteudo(idCliente)&&Validador.temConteudo(nomeCliente)&&Validador.temConteudo(cpfCliente)
                &&Validador.temConteudo(enderecoCliente)&&Validador.temConteudo(telefoneCliente)&&Validador.temConteudo(numeroserieVeiculo)
                &&Validador.temConteudo(observacao)&&Validador.temConteudo(idServico)&&Validador.temConteudo(dataEntrada)
                &&Validador.temConteudo(dataSaida)) {
            OrdemServico o = new OrdemServico();
            try (OrdemServicoDaoInterface dao = new OrdemServicoDaoClasse()) {
                dao.inserir(o);
                //response.sendRedirect("cadastrarVeiculo.jsp?mensagem=cadastradocomsucesso");
            } catch (ErroDao e) {
                //throw new RuntimeException(e);
                //response.sendRedirect("cadastrarVeiculo.jsp?mensagem=falhaaotentarcadastrar");
            }
        }
        else//erro falta parâmetros
        {
            //response.sendRedirect("cadastrarVeiculo.jsp?mensagem=faltaparametros");
        }
    }
}
