<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="/WEB-INF/template/header.jsp" />

<div class="container">
	<jsp:include page="/WEB-INF/template/menu.jsp" />
	<div class="row">
		<div class="col-md-5 col-md-offset-5" style="margin-left: 40px;">
			<form action="salvarCliente" class="form-horizontal" role="form"
				method="post">
				<fieldset>
					<!-- Form Name -->
					<legend>Dados do Cliente</legend>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput">Nome</label>
						<div class="col-sm-10">
							<input type="text" name="nome" placeholder="Nome"
								class="form-control">
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput">CPF</label>
						<div class="col-sm-10">
							<input type="text" name="cpf" placeholder="CPF"
								class="form-control">
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput">E-mail</label>
						<div class="col-sm-10">
							<input type="email" name="email"
								placeholder="exemplo@exemplo.com" class="form-control">
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput">Senha</label>
						<div class="col-sm-10">
							<input type="password" name="senha" placeholder="Senha"
								class="form-control">
						</div>
					</div>

				</fieldset>
				<fieldset>
					<!-- Form Name -->
					<legend>Endereço</legend>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput">Rua</label>
						<div class="col-sm-10">
							<input type="text" name="rua" placeholder="Endereço"
								class="form-control">
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput">Cidade</label>
						<div class="col-sm-10">
							<input type="text" name="cidade" placeholder="Cidade"
								class="form-control">
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
								<option value="AP">Amapá</option>
								<option value="AM">Amazonas</option>
								<option value="BA">Bahia</option>
								<option value="CE">Ceará</option>
								<option value="DF">Distrito Federal</option>
								<option value="ES">Espirito Santo</option>
								<option value="GO">Goiás</option>
								<option value="MA">Maranhão</option>
								<option value="MT">Mato Grosso</option>
								<option value="MS">Mato Grosso do Sul</option>
								<option value="MG">Minas Gerais</option>
								<option value="PA">Pará</option>
								<option value="PB">Paraiba</option>
								<option value="PR">Paraná</option>
								<option value="PE">Pernambuco</option>
								<option value="PI">Piauí</option>
								<option value="RJ">Rio de Janeiro</option>
								<option value="RN">Rio Grande do Norte</option>
								<option value="RS">Rio Grande do Sul</option>
								<option value="RO">Rondônia</option>
								<option value="RR">Roraima</option>
								<option value="SC">Santa Catarina</option>
								<option value="SP">São Paulo</option>
								<option value="SE">Sergipe</option>
								<option value="TO">Tocantis</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput">CEP</label>
						<div class="col-sm-4 col-lg-4">
							<input type="text" name="cep" placeholder="CEP"
								class="form-control">
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput">País</label>
						<div class="col-sm-10">
							<input type="text" name="pais" placeholder="País"
								class="form-control">
						</div>
					</div>
				</fieldset>
				
				<fieldset>
					<!-- Text input-->
					<div class="form-group">
						<label class="col-sm-2 control-label">Faixa Salarial</label>
						<div class="col-sm-10">
							<select class="form-control" id="renda" name="renda">
								<option>Escolha a Faixa Salarial</option>
								<option value="700">R$ 200 até R$ 700</option>
								<option value="1540">R$ 700 até R$ 1.540</option>
								<option value="1925">R$ 1.540 até R$ 1.925</option>
								<option value="2813">R$ 1.925 até R$ 2.813</option>
								<option value="4845">R$ 2.813 até R$ 4.845</option>
								<option value="12988">R$ 4.845 até R$ 12.988</option>
							</select>
						</div>
					</div>
				</fieldset>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="pull-right">
							<button type="submit" class="btn btn-primary">Cadastrar</button>
						</div>
					</div>
				</div>
			</form>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
</div>
<jsp:include page="/WEB-INF/template/footer.jsp" />