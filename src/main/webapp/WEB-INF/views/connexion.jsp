<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Paie - connexion</title>
</head>
<body class="container-fluid">

	<div class="row justify-content-md-center">
		<div class="col-auto">
			<h1>Connexion</h1>

			<!-- Spring Security s'attend aux paramètres "username" et "password" -->
			<form:form method="post">
				<input type="text" name="username" class="form-control" />
				<input type="password" name="password" class="form-control" />
				<button type="submit" class="btn">Se connecter</button>
			</form:form>

			<!-- en cas d'erreur un paramètre "error" est créé par Spring Security -->
			<c:if test="${param.error !=null}">
Erreur d'authentification.
</c:if>

			<c:if test="${param.logout !=null}">
Vous vous êtes déconnectés.
</c:if>

			<a href='<c:url value="/" />'>Acceuil</a>
		</div>
	</div>
</body>

<%@ include file="./pageScripts.jsp"%>
</html>
