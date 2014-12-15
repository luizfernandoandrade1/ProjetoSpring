<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="/WEB-INF/template/header.jsp"/>

<div class="container">
	<jsp:include page="/WEB-INF/template/menu.jsp" />
	<div class="row">
		<div class="col-md-5 col-md-offset-5" style="margin-left: 40px;">
			<fieldset>
				<legend>Detalhe do Produto</legend>
				<div class="form-group">
					<div class="col-sm-6">
						<img src="<c:out value="${produto.caminhoImagem}" />" alt="Scott Stevens" class="img-responsive img-circle" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-6">
						<label>Marca:</label> <c:out value="${produto.marca}" /><br>
						<label>Modelo:</label> <c:out value="${produto.modelo}" /><br>
						<label>Número:</label> <c:out value="${produto.numero}" /><br>
						<label>Preço:</label> R$ <c:out value="${produto.preco}" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-6">
							<a href="adicionarProdutoCarrinho?idProduto=<c:out value="${produto.id}"/>"  type="button" id="btn_add" class="btn btn-primary">Adicionar ao carrinho</a>
							<a href="listaProdutosCarrinho"  type="button" class="btn btn-success">Finalizar pedido</a>
						</div>
					</div>
			</fieldset>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/template/footer.jsp" />