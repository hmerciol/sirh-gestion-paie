<nav class="navbar">
	<div class="container-fluid">
		<ul class="nav navbar navbar-expand-sm">
			<li class="navbar-nav"><a class="navbar-brand" href="../"> <img
					src='<c:url value="/images/logo.jpg" />' alt="Logo"
					style="width: 40px;">
			</a></li>
			<li class="navbar-nav"><a class="nav-link"
				href='<c:url value="/mvc/employes/lister" />'>Employés</a></li>
			<li class="navbar-nav"><a class="nav-link"
				href='<c:url value="/mvc/bulletins/lister" />'>Bulletins</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li class="navbar-nav"><a class="nav-link"
				href='<c:url value="/mvc/logout" />'>logout</a></li>
		</ul>
	</div>
</nav>