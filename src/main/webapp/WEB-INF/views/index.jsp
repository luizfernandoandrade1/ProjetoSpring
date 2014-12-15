<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="/WEB-INF/template/header.jsp"/>
<div class="container">
	<jsp:include page="/WEB-INF/template/menu.jsp" />
	<div class="col-sm-9 col-md-9">
		<div class="well">
			<div class="row">
				<c:if test="${empty listaProduto}">
					<h3>Não há produtos cadastrados.</h3>
				</c:if>
				<c:if test="${not empty listaProduto}">
					<c:forEach var="i" begin="0" end="${listaProduto.size() - 1}">
						<div class="col-10 col-sm-10 col-lg-4">
							<h3>
								<c:out value="${listaProduto[i].marca}" />
							</h3>
							<div class="row">
								<div class="col-xs-12 col-sm-8">
									<img src="<c:out value="${listaProduto[i].caminhoImagem}" />"
										alt="Scott Stevens" class="img-responsive img-circle" />
								</div>
							</div>
							<div class="col-12 col-sm-12">							
								<h5>
									<label>R$ <c:out value="${listaProduto[i].preco}" /></label>
								</h5>
							</div>
							<div class="col-12 col-sm-12">	
								<p>
									<a class="btn btn-success"  id="btn_comprar" href="detalharProduto?idProduto=<c:out value="${listaProduto[i].id}"/>"
										role="button">Comprar &raquo;
									</a>
								</p>
							</div>
						</div>
					</c:forEach>
				</c:if>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/template/footer.jsp" />