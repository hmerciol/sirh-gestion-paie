<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>PAIE - Création bulletin</title>
</head>
<body class="container-fluid">
	<!-- entête de navigation -->
	<%@ include file="../pageNavbar.jsp"%>

	<!-- haut de page -->
	<header>
		<div class="row justify-content-md-center">
			<div class="col-auto">
				<p class="h1">Ajouter un bulletin</p>
			</div>
		</div>
	</header>


	<!-- formulaire -->
	<form:form method="post" modelAttribute="newBulletin">
		<div class="row justify-content-md-center">
			<div class="col-xl-2 col-sm-auto align-content-end">
				<div class="float-sm-left">
					<form:label path="periode" class="control-label">Periode</form:label>
				</div>
			</div>
			<div class="col-xl-6 col-md-5">
				<form:select path="periode.id" class="form-control"
					items="${listPeriodes}" itemLabel="label" itemValue="id">
				</form:select>
				<div class="invalid-feedback">La période est obligatoire</div>
			</div>
			<div class="col-xl-2 col-md-0"></div>
		</div>
		<div class="row justify-content-md-center">
			<div class="col-xl-2 col-sm-auto align-content-end">
				<div class="float-sm-left">
					<form:label path="remunerationEmploye" class="control-label">Profil</form:label>
				</div>
			</div>
			<div class="col-xl-6 col-md-5">
				<form:select path="remunerationEmploye.id" class="form-control"
					items="${listEmployes}" itemLabel="matricule" itemValue="id">
				</form:select>
				<div class="invalid-feedback">Le matricule est obligatoire</div>
			</div>
			<div class="col-xl-2 col-md-0"></div>
		</div>
		<div class="row justify-content-md-center">
			<div class="col-xl-2 col-sm-auto align-content-end">
				<div class="float-sm-left">
					<form:label path="primeExceptionnelle" class="control-label">Prime exceptionnelle</form:label>
				</div>
			</div>
			<div class="col-xl-6 col-md-5">
				<form:input path="primeExceptionnelle" type="text"
					class="form-control" />
				<div class="invalid-feedback">La prime est obligatoire (entrez
					0 si pas de prime)</div>
			</div>
			<div class="col-xl-2 col-md-0"></div>
		</div>
		<div class="row justify-content-md-center">
			<div class="col-xl-7 col-md-6">
				<div class="float-sm-right">
					<button type="submit" class="btn btn-basic btn-send">Créer</button>
				</div>
			</div>
			<div class="col-xl-1 col-md-0"></div>
		</div>
	</form:form>
</body>

<!-- scripts -->
<%@ include file="../pageScripts.jsp"%>
<script type="text/javascript">
	(function() {
		if (location.search === "?erreur") {
			$('.form-control').addClass('is-invalid');
		}
	})();
</script>
</html>