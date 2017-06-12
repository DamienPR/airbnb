<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>Création Appartement</title>
<link rel="stylesheet" type="text/css" href="CSS/airBnb.css">
</head>
<body>
	<header>
	<h1 class="titrePage">CREATION D'UN APPARTEMENT</h1>
	</header>
	<div class="maLigne"></div>
	<form method="post" action="ServletAfficherPlanning">
		<p id="choixProprietaire">
			<label for="proprietaire">Choisir propriétaire</label>
			<select name="listeNom">
				<option>--Sélectionnez--</option> ${leNom}
			</select>
		</p>

		<fieldset>
			<legend class="legendFielset">Champs requis</legend>
			<div class="champForm">
				<label for="descriptionAppartement"> Description de	l'appartement </label>
			</div>
			<div class="champForm">
				<textarea name="descriptionAppartement" id="descriptionAppartement"
					rows="10" cols="140">
				   </textarea>
			</div>
			<div class="champForm">
				<label class="formulaire">Rue</label>
			</div>
			<div class="champForm">
				<input type="text" name="rue" />
			</div>
			<div class="champForm">
				<label class="formulaire">Ville</label>
			</div>
			<div class="champForm">
				<input type="text" name="ville" />
			</div>
		</fieldset>
		<div class="envoiForm">
			<input type="submit" class="monBouton" value="Envoyer" />
		</div>
	</form>
</body>
</html>