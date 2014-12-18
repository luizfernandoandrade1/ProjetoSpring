<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="/WEB-INF/template/header.jsp"/>

<div class="container">
	<jsp:include page="/WEB-INF/template/menu.jsp" />
	<div class="row">
		<div class="col-md-1">
			<div class="container">
				<div class="col-md-5">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">
								<strong>Entre com os seus dados</strong>
							</h3>
						</div>
						<div class="panel-body">
							<form action="efetuarLogin"	role="form" method="post">
								<div class="form-group">
									<label for="exampleInputEmail1">E-mail</label> 
									<input id="txt_email" name="email" type="email" class="form-control" id="exampleInputEmail1" placeholder="Entre com e-mail">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Senha</label> 
									<input id="txt_senha" name="senha" type="password" class="form-control" id="exampleInputPassword1" placeholder="Senha">
								</div>
								<button id="btn_entrar" type="submit" class="btn btn-primary">Entrar</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
</div>
<jsp:include page="/WEB-INF/template/footer.jsp" />