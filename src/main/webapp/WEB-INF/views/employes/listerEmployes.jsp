<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>PAIE - Liste des employ�s</title>
</head>
<body class="container-fluid">
	<!-- ent�te de navigation -->
	<%@ include file="../pageNavbar.jsp"%>

	<!-- haut de page -->
	<header>
		<div class="row justify-content-md-center">
			<div class="col-auto">
				<p class="h1">Liste des employ�s</p>
			</div>
		</div>
	</header>

	<!-- cr�er employ� -->
	<div class="row">
		<div class="col-xl-12 mt-5 mr-5">
			<div class="float-sm-right">
				<a href='<c:url value="/mvc/employes/creer" />'
					class="btn btn-basic" role="button">Ajouter un employ�</a>
			</div>
		</div>
	</div>

	<!-- lister employ�s -->
	<section class="ml-5 mr-5 mt-5">
		<div class="row">
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>Date/heure cr�ation</th>
						<th>Matricule</th>
						<th>Grade</th>
						<th>Entreprise</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listEmployes}" var="employe">
						<tr>
							<td>${employe.creationLabel}</td>
							<td>${employe.matricule}</td>
							<td>${employe.grade.code}</td>
							<td>${employe.entreprise.denomination}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>
</body>

<!-- scripts -->
<%@ include file="../pageScripts.jsp"%>
</html>