<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="/WEB-INF/template/header.jsp"/>

<div class="container">
	<jsp:include page="/WEB-INF/template/menu.jsp" />
	<div class="row">
		<div class="col-md-5 col-md-offset-5" style="margin-left: 40px;">
			<h2>${message}</h2>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
</div>
<jsp:include page="/WEB-INF/template/footer.jsp" />