<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>PAIE - Liste des bulletins</title>
</head>
<body class="container-fluid">
	<!-- entête de navigation -->
	<%@ include file="../pageNavbar.jsp"%>

	<!-- haut de page -->
	<header>
		<div class="row justify-content-md-center">
			<div class="col-auto">
				<p class="h1">Liste des bulletins</p>
			</div>
		</div>
	</header>

	<!-- créer bulletin -->
	<div class="row">
		<div class="col-xl-12 mt-5 mr-5">
			<div class="float-sm-right">
				<a href='<c:url value="/mvc/bulletins/creer" />'
					class="btn btn-basic" role="button">Ajouter un bulletin</a>
			</div>
		</div>
	</div>

	<!-- lister bulletins -->
	<section class="ml-5 mr-5 mt-5">
		<div class="row">
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>Date/heure création</th>
						<th>Période</th>
						<th>Matricule</th>
						<th>Salaire brut</th>
						<th>Net imposable</th>
						<th>Net à payer</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listBulletins}" var="bulletin">
						<tr>
							<td>${bulletin.key.creationDate} ${bulletin.key.creationTime}</td>
							<td>${bulletin.key.periode.dateDebut} - ${bulletin.key.periode.dateFin}</td>
							<td>${bulletin.key.remunerationEmploye.matricule}</td>
							<td>${bulletin.value.salaireBrut}</td>
							<td>${bulletin.value.netImposable}</td>
							<td>${bulletin.value.netAPayer}</td>
							<td><a href='<c:url value="/mvc/bulletins/visualiser/${bulletin.key.id}"/>'>Visualiser</a></td>
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