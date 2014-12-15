<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="/WEB-INF/template/header.jsp"/>

<div class="container">
	<jsp:include page="/WEB-INF/template/menu.jsp" />
	<div class="col-sm-9 col-md-9">
		<div class="well">
			<div class="row">
				<c:if test="${empty listaProduto}">
						 	Nenhum produto cadastrado
				</c:if>
				<c:if test="${not empty listaProduto}">
					<c:forEach var="i" begin="0" end="${listaProduto.size() - 1}">
						<div class="col-5">
							<h3>
								<c:out value="${listaProduto[i].marca}" />
								<c:out value="${listaProduto[i].modelo}" />
							</h3>
							<div class="row">
								<div class="col-xs-3">
									<img src="<c:out value="${listaProduto[i].caminhoImagem}" />"
										alt="Scott Stevens" class="img-responsive img-circle" />
								</div>
								<div class="col-xs-2">
									<a href="deletarProduto?idProduto=${listaProduto[i].id}"
										type="button" class="btn btn-danger">Remover</a>
								</div>
								<div class="col-xs-2">
									<a href="atualizarProduto?idProduto=${listaProduto[i].id}"
										type="button" class="btn btn-primary">Atualizar</a>
								</div>
							</div>
							<h5>
								valor:
								<c:out value="${listaProduto[i].preco}" />
							</h5>
						</div>
						<br>
					</c:forEach>
				</c:if>
			</div>
		</div>
	</div>
</div>
</div>

<jsp:include page="/WEB-INF/template/footer.jsp" />