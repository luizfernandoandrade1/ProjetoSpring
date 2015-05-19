<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tiger Shoes - Inicio</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

<link href="/resources/css/offcanvas.css" rel="stylesheet">
<link href="/resources/css/accordionMenu.css" rel="stylesheet">

</head>

<body>
	<hr>
	<hr>
	<div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index">Tiger Shoes</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="index"> <span class="glyphicon glyphicon-home"></span> Home
					</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> <span
							class="glyphicon glyphicon-search"></span> Buscar Produto <b class="caret"></b></a>
						<ul class="dropdown-menu" style="min-width: 300px;">
							<li>
								<div class="row">
									<div class="col-md-12">
										<form class="navbar-form navbar-left" role="search" method="post" action="buscarProdutoPelaMarca">
											<div class="input-group">
												<input name="marca" type="text" class="form-control"
													placeholder="Buscar" /> <span class="input-group-btn">
													<button class="btn btn-primary" type="submit">Buscar!</button>
												</span>
											</div>
										</form>
									</div>
								</div>
							</li>
						</ul>
					</li>
					
					<li>						
						<a href="listaProdutosCarrinho"><span class="glyphicon glyphicon-shopping-cart"></span> Carrinho</a>
					</li>
					
					<li class="dropdown">
					<a id="cmb_login" href="#" class="dropdown-toggle" data-toggle="dropdown">
					<span class="glyphicon glyphicon-user"></span>						
						 <c:if test="${empty cliente.nome}">
						 	Olá, Visitante <b class="caret"></b>		
						 </c:if>
						 <c:if test="${not empty cliente.nome}">
						 	Olá, ${cliente.nome} <b class="caret"></b>		
						 </c:if>
					</a>
		            <ul  class="dropdown-menu">
		            	<c:if test="${empty cliente.nome}">
		                	<li><a id="opt_entrar" href="loginCliente"><span class="glyphicon glyphicon-user"></span> Entrar</a></li>
		                </c:if>
		                <c:if test="${not empty cliente.nome}">
		                	<li class="divider"></li>
		                	<li><a href="logout"><span class="glyphicon glyphicon-off"></span> Logout</a></li>
		                </c:if>
		            </ul>
		       </li>
			</ul>
		</div>
	</div>
</div>