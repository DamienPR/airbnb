<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" />
<title>Création de propriétaire</title>
<link rel="stylesheet" type="text/css" href="CSS/airBnb.css">
</head>
<body>
	<header>
	<h1 class="titrePage">CREATION DU PROPRIETAIRE</h1>
	</header>
	<div class="maLigne"></div>
	<form method="post" action="ServletCreationAppart">
		<fieldset>
			<legend class="legendFielset">Inscription</legend>
			<div class="champForm">
				<label class="formulaire">Nom :</label>
			</div>
			<div class="champForm">
				<input type="text" name="nom"  /><span> ${msgErreur}</span>
			</div>
			<div class="champForm">
				<label class="formulaire">Prénom :</label>
			</div>
			<div class="champForm">
				<input type="text" name="prenom"  /><span> ${msgErreur}</span>
			</div>
			<div class="champForm">
				<label class="formulaire">Téléphone :</label>
			</div>
			<div class="champForm">
				<input type="tel" name="tel"  />
			</div>
			<div class="champForm">
				<label class="formulaire">email :</label>
			</div>
			<div class="champForm">
				<input type="email" name="email"  />
			</div>
		</fieldset>
		<div class="envoiForm">
			<input type="submit" class="monBouton" value="Envoyer" />
		</div>
	</form>
</body>
</html>