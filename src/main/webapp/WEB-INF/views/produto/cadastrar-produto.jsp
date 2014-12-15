<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="/WEB-INF/template/header.jsp"/>

<div class="container">
	<jsp:include page="/WEB-INF/template/menu.jsp" />
	<div class="row">
		<div class="col-md-5 col-md-offset-5" style="margin-left: 40px;">
			<c:if test="${empty produto.id}">
				<form action="cadastrarProdutoPost" class="form-horizontal" role="form" method="post">
			</c:if>

			<c:if test="${not empty produto.id}">
				<form action="atualizarProdutoPost" class="form-horizontal" role="form" method="post">
					<input type="hidden" name="id" value="${produto.id}">
			</c:if>

			<fieldset>
				<!-- Form Name -->
				<legend>Dados do Produto</legend>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="textinput">Marca</label>
					<div class="col-sm-10">
						<c:if test="${empty produto.marca}">
							<input type="text" name="marca" placeholder="Marca"
								class="form-control">
						</c:if>

						<c:if test="${not empty produto.marca}">
							<input type="text" name="marca" placeholder="Marca"
								class="form-control" value="${produto.marca}">
						</c:if>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label" for="textinput">Modelo</label>
					<div class="col-sm-10">
						<c:if test="${empty produto.modelo}">
							<input type="text" name="modelo" placeholder="Modelo"
								class="form-control">
						</c:if>

						<c:if test="${not empty produto.modelo}">
							<input type="text" name="modelo" placeholder="Marca"
								class="form-control" value="${produto.modelo}">
						</c:if>

					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label" for="textinput">Número</label>
					<div class="col-sm-10">

						<c:if test="${empty produto.numero}">
							<input type="text" name="numero" placeholder="Número"
								class="form-control">
						</c:if>

						<c:if test="${not empty produto.numero}">
							<input type="text" name="numero" placeholder="Número"
								class="form-control" value="${produto.numero}">
						</c:if>

					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label" for="textinput">Preço</label>
					<div class="col-sm-10">

						<c:if test="${empty produto.preco}">
							<input type="text" name="preco" placeholder="Preço"
								class="form-control">
						</c:if>

						<c:if test="${not empty produto.preco}">
							<input type="text" name="preco" placeholder="Preço"
								class="form-control" value="${produto.preco}">
						</c:if>

					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="textinput">Imagem</label>
					<div class="col-sm-10">

						<c:if test="${empty produto.caminhoImagem}">
							<input type="text" name="caminhoImagem"
								placeholder="Endereço da Imagem" class="form-control">
						</c:if>

						<c:if test="${not empty produto.caminhoImagem}">
							<input type="text" name="caminhoImagem"
								placeholder="Endereço da Imagem" class="form-control"
								value="${produto.caminhoImagem}">
						</c:if>

					</div>
				</div>
				<div class="form-group">
					<c:if test="${not empty listaFornecedor}">
						<label class="col-sm-2 control-label" for="textinput">Fornecedor</label>
						<div class="col-sm-10">						
								<select class="form-control" id="fornecedor" name="id_fornecedor">
									<c:forEach var="i" begin="0" end="${listaFornecedor.size() - 1}">
										<option value="${listaFornecedor[i].id}">
											<c:out value="${listaFornecedor[i].nome}" />
										</option>
									</c:forEach>
								</select>
							</div>
						</c:if>
						<c:if test="${empty listaFornecedor}">
							<label>Fornecedor não cadastrado, <a href="cadastrarFornecedor">Clique aqui para cadastar</a></label>
						</c:if>					
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="pull-right">
							<c:if test="${empty listaFornecedor}">
								<button type="submit" class="btn btn-primary" disabled="disabled">Cadastrar</button>
							</c:if>	
							<c:if test="${not empty listaFornecedor}">
								<button type="submit" class="btn btn-primary">Cadastrar</button>
							</c:if>
						</div>
					</div>
				</div>
			</fieldset>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
</div>
<jsp:include page="/WEB-INF/template/footer.jsp" />