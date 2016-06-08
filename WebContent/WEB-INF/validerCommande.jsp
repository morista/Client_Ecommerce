<c:import url="/inc/head.jsp" />

<div class='container'>
	<div class='row'>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="page-header">
  				<h1>Veuillez remplir le formulaire pour valider la commande <br />
				</h1>
			</div>
		<form method="POST" action="/Client_Ecommerces/creationCommande">
			<div class="form-group">
				<label for="nomClient">Nom :</label> <input required="required"
					type="text" class="form-control" name="nomClient" id="nomClient" value="<c:out value="${ sessionScope.userSession.nom }" />" >
			</div>
			<div class="form-group">
				<label for="prenomClient">Prenom :</label>
				<input required="required" type="text" class="form-control" name="prenomClient" id="prenomClient" value="<c:out value="${ sessionScope.userSession.login }" />">
			</div>
			<div class="form-group">
				<label for="adresseClient">Adresse :</label> 
				<input required="required" type="text" class="form-control" name="adresseClient" id="adresseClient">
			</div>
			<div class="form-group">
				<label for="emailClient">Email :</label> <input required="required"
					type="email" class="form-control" name="emailClient" id="emailClient">
			</div>
			<div class="form-group">
				<label for="telephoneClient">T&eacute;l&eacute;phone :</label> 
				<input required="required" type="text" class="form-control" name="telephoneClient" id="telephoneClient">
			</div>
			<div class="form-group">
				<label for="modePaiementCommande">Mode de paiment :</label> 
			      <select class="form-control" id="modePaiementCommande">
			        <option value="carte" >Carte</option>
			        <option value="paypal" >PayPal</option>
			      </select>
			</div>
			<div class="form-group">
				<label for="modeLivraisonCommande">Mode de livraison :</label> 
			      <select class="form-control" id="modeLivraisonCommande">
			        <option value="express" >Express</option>
			        <option value="teleportation" >Teleportation</option>
			      </select>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Valider</button>
		</form>
	</div>
</div>


</div>
</div>

</body>
</html>