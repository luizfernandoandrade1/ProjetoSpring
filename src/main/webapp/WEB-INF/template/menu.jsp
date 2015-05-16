<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="col-sm-3 col-md-3">
	<div class="panel-group" id="accordion">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseOne"><span class="glyphicon glyphicon-user">
					</span> Conta</a>
				</h4>
			</div>
			<div id="collapseOne" class="panel-collapse collapse">
				<div class="panel-body">
					<table class="table">
						<tr>
							<td><a href="cadastrarCliente">Cadastrar</a></td>
						</tr>
						<tr>
							<td><a href=loginCliente>Entrar</a></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseTwo"><span class="glyphicon glyphicon-shopping-cart">
					</span> Produtos</a>
				</h4>
			</div>
			<div id="collapseTwo" class="panel-collapse collapse">
				<div class="panel-body">
					<table class="table">
						<tr>
							<td ><a id="menuCarrinho" href="listaProdutosCarrinho">Carrinho</a></td>
						</tr>
						<tr>
							<td><a href="index">Produtos</a></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<c:if test="${tipoCliente eq 'INTERNO'}">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion"
							href="#collapseFour"><span class="glyphicon glyphicon-align-justify">
						</span> Administrativo</a>
					</h4>
				</div>
				<div id="collapseFour" class="panel-collapse collapse">
					<div class="panel-body">
						<table class="table">
							<tr>
								<td><a href="cadastrarProduto">Cadastrar Produto</a></td>
							</tr>
							<tr>
								<td><a href="listarProdutos">Listar Produtos</a></td>
							</tr>
							<tr>
								<td><a href="cadastrarFornecedor">Cadastrar Fornecedor</a></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</c:if>
	</div>
</div>