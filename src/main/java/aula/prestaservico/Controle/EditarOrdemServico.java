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

@WebServlet("/editarOrdemServico")
public class EditarOrdemServico extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario != null) {
            String id_ordemServico = request.getParameter("id");
            int id = Integer.parseInt(id_ordemServico);
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


            if(Validador.temConteudo(id_ordemServico)&&Validador.temConteudo(id_cliente)&&Validador.temConteudo(nomeCliente)&&Validador.temConteudo(cpfCliente)
                    &&Validador.temConteudo(enderecoCliente)&&Validador.temConteudo(telefoneCliente)&&Validador.temConteudo(numeroserie_veiculo)
                    &&Validador.temConteudo(observacao)&&Validador.temConteudo(dataEntrada)&&Validador.temConteudo(dataSaida)) {
                try (OrdemServicoDaoInterface ordemServicoDao = new OrdemServicoDaoClasse();
                     ServicoDaoInterface servicoDao = new ServicoDaoClasse();
                     OsHasServicoDaoInterface osHasServicoDao = new OsHasServicoDaoClasse()) {

                    OrdemServico ordemServico = new OrdemServico(id,idCliente,nomeCliente,cpfCliente,enderecoCliente,
                            telefoneCliente,numeroserieVeiculo,observacao,dataEntrada,dataSaida);
                    ordemServicoDao.editar(ordemServico);

                    String[] idsServicosSelecionados = request.getParameterValues("idServico");
                    if (idsServicosSelecionados != null) {
                        double totalValorServicos = 0.0;
                        for (String idServico : idsServicosSelecionados) {
                            Servico servico = servicoDao.buscar(Integer.parseInt(idServico));

                            double valorServico = servico.getValor();
                            totalValorServicos += valorServico;

                            int idServicoInserido = servico.getId();

                            OsHasServico osHasServico = new OsHasServico();

                            osHasServico.setId_ordemservico(ordemServico.getId());
                            osHasServico.setId_servico(idServicoInserido);
                            osHasServicoDao.editar(osHasServico);
                        }

                        ordemServico.setValorTotal(totalValorServicos);
                        ordemServicoDao.atualizarValor(ordemServico);
                    }
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
