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
<title>PAIE - Création employé</title>
</head>
<body class="container-fluid">
	<!-- entête de navigation -->
	<ul class="navbar navbar-expand-sm">
		<li class="navbar-nav"><a class="navbar-brand" href="../"> <img
				src="../../images/logo.jpg" alt="Logo" style="width: 40px;">
		</a></li>
		<li class="navbar-nav"><a class="nav-link active" href="./lister">Employés</a></li>
		<li class="navbar-nav"><a class="nav-link"
			href="../bulletins/lister">Bulletins</a></li>
	</ul>

	<!-- haut de page -->
	<header>
		<div class="row justify-content-md-center">
			<div class="col-auto">
				<p class="h1">Ajouter un employé</p>
			</div>
		</div>
	</header>

	<!-- formulaire -->
	<form:form method="post" modelAttribute="newEmploye">
		<div class="row justify-content-md-center">
			<div class="col-xl-1 col-sm-auto align-content-end">
				<div class="float-sm-left">
					<form:label path="matricule" class="control-label">Matricule</form:label>
				</div>
			</div>
			<div class="col-xl-6 col-md-5">
				<form:input path="matricule" type="text" class="form-control" />
			</div>
			<div class="col-xl-1 col-md-0"></div>
		</div>
		<div class="row justify-content-md-center">
			<div class="col-xl-1 col-sm-auto align-content-end">
				<div class="float-sm-left">
					<form:label path="entreprise" class="control-label">Entreprise</form:label>
				</div>
			</div>
			<div class="col-xl-6 col-md-5">
				<form:select path="entreprise.id" class="form-control">
					<form:options items="${listEntreprises}" itemLabel="denomination" itemValue="id"></form:options>
				</form:select>
			</div>
			<div class="col-xl-1 col-md-0"></div>
		</div>
		<div class="row justify-content-md-center">
			<div class="col-xl-1 col-sm-auto align-content-end">
				<div class="float-sm-left">
					<form:label path="profilRemuneration" class="control-label">Profil</form:label>
				</div>
			</div>
			<div class="col-xl-6 col-md-5">
				<form:select path="profilRemuneration.id" class="form-control">
					<form:options items="${listProfils}" itemLabel="code"  itemValue="id"></form:options>
				</form:select>
			</div>
			<div class="col-xl-1 col-md-0"></div>
		</div>
		<div class="row justify-content-md-center">
			<div class="col-xl-1 col-sm-auto align-content-end">
				<div class="float-sm-left">
					<form:label path="grade" class="control-label">Grade</form:label>
				</div>
			</div>
			<div class="col-xl-6 col-md-5">
				<form:select path="grade.id" class="form-control" >
					<form:options items="${listGrades}" itemLabel="code"  itemValue="id" ></form:options>
				</form:select>
			</div>
			<div class="col-xl-1 col-md-0"></div>
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
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js "
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN "
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js "
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q "
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js "
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl "
	crossorigin="anonymous"></script>
</html>