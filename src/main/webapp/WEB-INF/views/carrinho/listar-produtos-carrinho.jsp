<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="/WEB-INF/template/header.jsp"/>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container">
	<jsp:include page="/WEB-INF/template/menu.jsp" />
	<div class="col-sm-9 col-md-9">
		<div class="well">
			<div class="row">
				<c:if test="${empty pedido}">
						 	Nenhum produto no carrinho.
				</c:if>
				<c:if test="${not empty pedido}">
					<form:form action="executarCompra" class="form-horizontal" role="form" method="post" modelAttribute="pedidoForm" >
						<c:forEach items="${pedido.itens}" var="item" varStatus="status">
							<br>
							<div class="col-5">
								<h3>
									<input type="hidden" name="itens[${status.index}].produto.id" value="${item.produto.id}" class="form-control">
									<c:out value="${item.produto.marca}" />
									<c:out value="${item.produto.modelo}" />
								</h3>
								<div class="row">
									<div class="col-xs-3">
										<img src="<c:out value="${item.produto.caminhoImagem}" />"
											alt="Scott Stevens" class="img-responsive img-circle" />
									</div>
								</div>
								<div class="col-12 col-sm-12">							
									<h5>Valor:
										<label>R$ <c:out value="${item.produto.preco}" /></label>
									</h5>
								</div>
								<div class="col-xs-3">
									<input id="txt_quantidade" type="number" name="itens[${status.index}].quantidade" placeholder="Quantidade" class="form-control">
								</div>
								<br>
							</div>
							<br>
						</c:forEach>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<div class="pull-right">
									<button id="btn_finalizar" type="submit" class="btn btn-primary">Finalizar Pedido</button>
								</div>
							</div>
						</div>
					</form:form>
				</c:if>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/template/footer.jsp" />