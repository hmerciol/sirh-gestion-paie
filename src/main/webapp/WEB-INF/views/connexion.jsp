<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Paie - connexion</title>
</head>
<body class="container">

	<h1>Connexion</h1>

	<!-- Spring Security s'attend aux paramètres "username" et "password" -->
	<form:form method="post">
		<input type="text" name="username">
		<input type="password" name="password">
		<input type="submit" value="Se connecter">
	</form:form>

	<!-- en cas d'erreur un paramètre "error" est créé par Spring Security -->
	<c:if test="${param.error !=null}">
Erreur d'authentification.
</c:if>

<c:if test="${param.logout !=null}">
Vous vous êtes déconnectés.
</c:if>

<a href='<c:url value="/" />'>Acceuil</a>
</body>

<%@ include file="./pageScripts.jsp"%>
</html>
