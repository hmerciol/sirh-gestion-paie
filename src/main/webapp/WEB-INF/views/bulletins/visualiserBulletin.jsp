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
				<p class="h1">Bulletin de salaire</p>
			</div>
		</div>

		<!-- informations d'entête -->
		<div class="row justify-content-between ml-2 mr-2 mt-2">
			<div class="col-4">
				<div class="row align-items-end">
					<p>
						Entreprise<br />
						${bulletin.remunerationEmploye.entreprise.denomination}<br />
						Siret : ${bulletin.remunerationEmploye.entreprise.siret}
					</p>
				</div>
			</div>
			<div class="col-4">
				<div class="row align-items-start">
					<p>
						Période<br /> Du ${bulletin.periode.dateDebut} au
						${bulletin.periode.dateFin}
					</p>
				</div>
				<div class="row align-items-end">
					<p>Matricule : ${bulletin.remunerationEmploye.matricule}</p>
				</div>
			</div>
		</div>
	</header>

	<!-- tableaux de valeurs -->
	<section>
		<!-- salaire -->
		<div class="row ml-2 mr-2 mt-2">
			<h2>Salaire</h2>
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>Rubriques</th>
						<th>Base</th>
						<th>Taux salarial</th>
						<th>Montant salarial</th>
						<th>Taux patronal</th>
						<th>Cot. patronales</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Salaire de base</td>
						<td>${bulletin.remunerationEmploye.grade.nbHeuresBase}</td>
						<td>${bulletin.remunerationEmploye.grade.tauxBase}</td>
						<td>${calculs.salaireDeBase}</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>Prime except.</td>
						<td></td>
						<td></td>
						<td>${bulletin.primeExceptionnelle}</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>Salaire brut</td>
						<td></td>
						<td></td>
						<td>${calculs.salaireBrut}</td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- cotisations -->
		<div class="row ml-2 mr-2 mt-2">
			<h2>Cotisations</h2>
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>Rubriques</th>
						<th>Base</th>
						<th>Taux salarial</th>
						<th>Montant salarial</th>
						<th>Taux patronal</th>
						<th>Cot. patronales</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach
						items="${bulletin.remunerationEmploye.profilRemuneration.cotisationsNonImposables}"
						var="cot">
						<tr>
							<td>${cot.libelle}</td>
							<td>${calculs.salaireBrut}</td>
							<c:choose>
								<c:when test="${cot.tauxSalarial != null}">
									<td>${cot.tauxSalarial}</td>
									<td>${cot.tauxSalarial * calculs.salaireBrut}</td>
								</c:when>
								<c:otherwise>
									<td></td>
									<td></td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${cot.tauxPatronal != null}">
									<td>${cot.tauxPatronal}</td>
									<td>${cot.tauxPatronal * calculs.salaireBrut}</td>
								</c:when>
								<c:otherwise>
									<td></td>
									<td></td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
					<tr>
						<td>Total retenue</td>
						<td></td>
						<td></td>
						<td>${calculs.totalRetenueSalarial}</td>
						<td></td>
						<td>${calculs.totalCotisationsPatronales}</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- net imposable -->
		<div class="row ml-2 mr-2 mt-2">
			<h2>Net imposable : ${calculs.netImposable}</h2>
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>Rubriques</th>
						<th>Base</th>
						<th>Taux salarial</th>
						<th>Montant salarial</th>
						<th>Taux patronal</th>
						<th>Cot. patronales</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach
						items="${bulletin.remunerationEmploye.profilRemuneration.cotisationsImposables}"
						var="cot">
						<tr>
							<td>${cot.libelle}</td>
							<td>${calculs.salaireBrut}</td>
							<c:choose>
								<c:when test="${cot.tauxSalarial != null}">
									<td>${cot.tauxSalarial}</td>
									<td>${cot.tauxSalarial * calculs.salaireBrut}</td>
								</c:when>
								<c:otherwise>
									<td></td>
									<td></td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${cot.tauxPatronal != null}">
									<td>${cot.tauxPatronal}</td>
									<td>${cot.tauxPatronal * calculs.salaireBrut}</td>
								</c:when>
								<c:otherwise>
									<td></td>
									<td></td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
					<tr>
						<td>Total retenue</td>
						<td></td>
						<td></td>
						<td>${calculs.totalRetenueSalarial}</td>
						<td></td>
						<td>${calculs.totalCotisationsPatronales}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</section>

	<!-- net à payer -->
	<footer>
		<div class="row">
			<div class="col-xl-12 mt-5 mr-5 mb-5">
				<div class="float-sm-right">
					<h2>Net à payer : ${calculs.netAPayer}</h2>
				</div>
			</div>
		</div>
	</footer>
</body>

<!-- scripts -->
<%@ include file="../pageScripts.jsp"%>
</html>