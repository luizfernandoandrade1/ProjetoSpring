<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="/WEB-INF/template/header.jsp"/>

<div class="container">
	<jsp:include page="/WEB-INF/template/menu.jsp" />
	<div class="row">
		<div class="col-md-5 col-md-offset-5" style="margin-left: 40px;">
			<form action="salvarFornecedor" class="form-horizontal" role="form" method="post">
				<fieldset>
					<!-- Form Name -->
					<legend>Dados do Fornecedor</legend>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput">Nome</label>
						<div class="col-sm-10">
							<input type="text" name="nome" placeholder="Nome" class="form-control">
						</div>
					</div>					
						
				</fieldset>
				<fieldset>
					<!-- Form Name -->
					<legend>Endere�o</legend>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput">Rua</label>
						<div class="col-sm-10">
							<input type="text" name="rua" placeholder="Endere�o" class="form-control">
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput">Cidade</label>
						<div class="col-sm-10">
							<input type="text" name="cidade" placeholder="Cidade" class="form-control">
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput">Estado</label>
						<div class="col-sm-10">
							<select class="form-control" id="estado" name="estado">
								<option>Escolha o Estado</option>
								<option value="AC">Acre</option>
								<option value="AL">Alagoas</option>
								<option value="AP">Amap�</option>
								<option value="AM">Amazonas</option>
								<option value="BA">Bahia</option>
								<option value="CE">Cear�</option>
								<option value="DF">Distrito Federal</option>
								<option value="ES">Espirito Santo</option>
								<option value="GO">Goi�s</option>
								<option value="MA">Maranh�o</option>
								<option value="MT">Mato Grosso</option>
								<option value="MS">Mato Grosso do Sul</option>
								<option value="MG">Minas Gerais</option>
								<option value="PA">Par�</option>
								<option value="PB">Paraiba</option>
								<option value="PR">Paran�</option>
								<option value="PE">Pernambuco</option>
								<option value="PI">Piau�</option>
								<option value="RJ">Rio de Janeiro</option>
								<option value="RN">Rio Grande do Norte</option>
								<option value="RS">Rio Grande do Sul</option>
								<option value="RO">Rond�nia</option>
								<option value="RR">Roraima</option>
								<option value="SC">Santa Catarina</option>
								<option value="SP">S�o Paulo</option>
								<option value="SE">Sergipe</option>
								<option value="TO">Tocantis</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput">CEP</label>
						<div class="col-sm-4 col-lg-4">
							<input type="text" name="cep" placeholder="CEP" class="form-control">
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput">Pa�s</label>
						<div class="col-sm-10">
							<input type="text" name="pais" placeholder="Pa�s" class="form-control">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="pull-right">
								<button type="submit" class="btn btn-primary">Cadastrar</button>
							</div>
						</div>
					</div>

				</fieldset>
			</form>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
</div>
<jsp:include page="/WEB-INF/template/footer.jsp" />