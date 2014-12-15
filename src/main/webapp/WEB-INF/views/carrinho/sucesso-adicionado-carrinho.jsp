<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="/WEB-INF/template/header.jsp"/>

<div class="container">
	<jsp:include page="/WEB-INF/template/menu.jsp" />
	<div class="row">
		<div class="col-md-5 col-md-offset-5" style="margin-left: 40px;">
				<fieldset>
					<div class="form-group">
						<div class="col-sm-10">
							<h4>Produto adicionado com sucesso!</h4>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-10">
							<a href="index" id="btn_continuar_compras" type="button" class="btn btn-primary">Continuar as compras</a>
							<a href="listaProdutosCarrinho" type="button" class="btn btn-success">Finalizar pedido</a>
						</div>
					</div>
				</fieldset>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/template/footer.jsp" />