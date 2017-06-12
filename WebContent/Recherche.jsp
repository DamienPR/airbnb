<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>Recherche</title>
<link rel="stylesheet" type="text/css" href="CSS/airBnb.css">
</head>
<body>
	<header>
	<h1 class="titrePage">RECHERCHE DE DISPONIBILITE</h1>
	</header>
	<div class="maLigne"></div>
	<form method="post" action="Disponibilites.jsp">
		<div>
			<label class="formulaire">Ville</label> : <input type="text"
				name="ville" required />
		</div>
		<div>
			<p>Date :</p>
			<label class="formulaire">Du :</label><input type="date"
				name="dateDebut" required></input><img class="iconeCalendrier"
				src="../images/iconeCalendrier.png" /> <label class="formulaire">Au
			</label><input type="date" name="dateFin" required></input><img
				src="../images/iconeCalendrier.png" / class="iconeCalendrier" /><input
				type="submit" class="monBouton" value="Envoyer" />
		</div>
		<h1 class="resultat">Résultats</h1>
		<div class="listeResultat, texte">
			<p>resultat 1 : propriétaire, appartement, rue</p>
			<p>resultat 2 : propriétaire, appartement, rue</p>
			<p>resultat 3 : propriétaire, appartement, rue</p>
		</div>
	</form>
</body>
</html>