# OrdemServicoServletJSTL
Projeto de Ordem de Serviço, usando JAVA, Servlet e JSTL


            <c:forEach var="servico" items="${servicos}">
                <c:forEach var="osHasServico" items="${osHasServicos}">
                    <c:choose>
                        <c:when test="${osHasServico.id_servico==servico.id}">
                            <input type="checkbox" name="idServico" value="${servico.id}">${servico.nome}
                        </c:when>
                        <c:otherwise>
                            <input type="checkbox" checked name="idServico" value="${servico.id}">${servico.nome}
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </c:forEach>
