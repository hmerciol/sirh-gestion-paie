<nav class="navbar">
	<div class="container-fluid">
		<ul class="nav navbar navbar-expand-sm">
			<li class="navbar-nav"><a class="navbar-brand"
				href='<c:url value="/" />'> <img
					src='<c:url value="/images/logo.jpg" />' alt="Logo"
					style="width: 40px;">
			</a></li>
			<li class="navbar-nav"><a class="nav-link"
				href='<c:url value="/mvc/employes/lister" />'>Employ�s</a></li>
			<li class="navbar-nav"><a class="nav-link"
				href='<c:url value="/mvc/bulletins/lister" />'>Bulletins</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li class="navbar-nav">
				<form method="post" action='<c:url value="/mvc/logout" />'>
					<button type="submit" class="btn">Logout</button>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
		</ul>
	</div>
</nav>