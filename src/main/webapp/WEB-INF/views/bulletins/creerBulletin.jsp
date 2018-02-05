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
				<form:select path="periode.id" class="form-control">
					<c:forEach items="${listPeriodes}" var="periode">
						<form:option value="${periode.id}">${periode.dateDebut} - ${periode.dateFin}</form:option>
					</c:forEach>
				</form:select>
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
</html>