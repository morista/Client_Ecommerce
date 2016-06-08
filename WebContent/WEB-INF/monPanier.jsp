
<c:import url="/inc/head.jsp" />

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h1 class="page-header">
		<span class="glyphicon glyphicon-shopping-cart"></span>Mon Panier
	</h1>
	<c:choose>
		<c:when test="${!empty sessionScope.produitPanier}">
			<div class="alert alert-info">
				<strong>Message : </strong> Votre produit a bien été enregistré dans
				votre panier (liste ci-dessous), vous pouvez continuer vos achats ou
				bien finaliser la commande et passer au paiement
			</div>
			<table class="table table-inverse">
				<thead>
					<tr>
						<th>Nom</th>
						<th>Fournisseur</th>
						<th>Quantite</th>
						<th>Prix Total</th>
						<th>action</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="produitPanier" items="${ sessionScope.produitPanier }">
					<tr>
						<th><c:out value="${ produitPanier.produit.nom }" /></th>
						<td><c:out value="${ produitPanier.produit.fournisseur }" /></td>
						<td><c:out value="${ produitPanier.quantite }" /></td>
						<td><c:out value="${ produitPanier.prixTotal } $" /></td>
						<td><a title="supprimer"
							href="<c:url value="/supprimeArticlePanier"> <c:param name="idProduit" value="${ produitPanier.produit.id }" /></c:url>"
							class="btn btn-danger"> <span
								class="glyphicon glyphicon-trash"></span>
						</a></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			
			<hr />
			<a class="btn btn-primary pull-right" href="<c:url value="/creationCommande"></c:url>">
				Finaliser la commande
			</a>
		</c:when>
		<c:otherwise>
   			<div class="alert alert-warning">
				<strong>Message : </strong> Votre panier est vide
			</div>
	  	</c:otherwise>
	  	
	</c:choose>
</div>

</div>
</div>

</body>
</html>