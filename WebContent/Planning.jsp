<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>Planning</title>
<link rel="stylesheet" type="text/css" href="CSS/airBnb.css">
</head>
<body>
	<header>
	<h1 class="titrePage">PLANNING</h1>
	</header>
	<div class="maLigne"></div>
	<form method="post" action="">
		<div class="texte">
			<p id="choixProprietaire">
				<label for="proprietaire">Choisir propriétaire</label> 
				<select	name="listeNom">
					<option>--Sélectionnez--</option> ${leNom}
				</select>
			</p>
		</div>
		<div class="envoiForm">
			<input type="submit" class="monBouton" value="Envoyer" />
		</div>
	</form>
	<div class="listeRestultat">
		<ul>
		<c:forEach items="${ listeLogement}" var="numeroLogement" >
			<li>Logement numero : <c:out value="${numeroLogement}"/></li>
			<li>Ville : <c:out value="${ville }"/></li>
			<li>Adresse : <c:out value="${adresse }"/></li>
		</c:forEach>
		</ul>
	</div>
	<div class="maLigne"></div>
</body>
</html>