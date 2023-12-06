package aula.prestaservico.Controle;

import aula.prestaservico.DAO.*;
import aula.prestaservico.Modelo.OrdemServico;
import aula.prestaservico.Modelo.OsHasServico;
import aula.prestaservico.Modelo.Servico;
import aula.prestaservico.Util.Validador;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

@WebServlet("/cadastrarOrdemServico")
public class CadastrarOrdemServico extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext aplicacao=getServletContext();
        request.setCharacterEncoding("utf-8");

        String id_cliente = request.getParameter("idCliente");
        int idCliente = Integer.parseInt(id_cliente);
        String nomeCliente = request.getParameter("nomeCliente");
        String cpfCliente = request.getParameter("cpfCliente");
        String enderecoCliente = request.getParameter("enderecoCliente");
        String telefoneCliente = request.getParameter("telefoneCliente");
        String numeroserie_veiculo = request.getParameter("numeroserieVeiculo");
        int numeroserieVeiculo = Integer.parseInt(numeroserie_veiculo);
        String observacao = request.getParameter("observacao");
        String dataEntrada = request.getParameter("dataEntrada");
        String dataSaida = request.getParameter("dataSaida");

        if(Validador.temConteudo(id_cliente)&&Validador.temConteudo(nomeCliente)&&Validador.temConteudo(cpfCliente)
                &&Validador.temConteudo(enderecoCliente)&&Validador.temConteudo(telefoneCliente)&&Validador.temConteudo(numeroserie_veiculo)
                &&Validador.temConteudo(observacao)&&Validador.temConteudo(dataEntrada)&&Validador.temConteudo(dataSaida)) {

            try (OrdemServicoDaoInterface ordemServicoDao = new OrdemServicoDaoClasse();
                    ServicoDaoInterface servicoDao = new ServicoDaoClasse();
                    OsHasServicoDaoInterface osHasServicoDao = new OsHasServicoDaoClasse()) {

                OrdemServico ordemServico = new OrdemServico(idCliente,nomeCliente,cpfCliente,enderecoCliente,
                        telefoneCliente,numeroserieVeiculo,observacao,dataEntrada,dataSaida);
                ordemServicoDao.inserir(ordemServico);

                String[] idsServicosSelecionados = request.getParameterValues("idServico");
                if (idsServicosSelecionados != null) {
                    for (String idServico : idsServicosSelecionados) {
                        Servico servico = servicoDao.buscar(Integer.parseInt(idServico));
                        int idServicoInserido = servico.getId();

                        OsHasServico osHasServico = new OsHasServico();

                        osHasServico.setId_ordemservico(ordemServico.getId());
                        osHasServico.setId_servico(idServicoInserido);
                        osHasServicoDao.inserir(osHasServico);
                        System.out.print("Sim, entrou");
                    }
                }
                response.sendRedirect("listarCliente.jsp?mensagem=cadastradocomsucesso");
            } catch (ErroDao e) {
                //throw new RuntimeException(e);
                response.sendRedirect("listarCliente.jsp?mensagem=falhaaotentarcadastrar");
            }
        }
        else//erro falta parâmetros
        {
            response.sendRedirect("listarCliente.jsp?mensagem=faltaparametros");
        }
    }
}
