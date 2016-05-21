	
	<c:import url="/inc/head.jsp" />
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Produits</h1>
          
          	<c:forEach var="produit" items="${ ListProduit }">
          		<div class="row">
          		 <div class="col-md-4">
					<p><a href=""> <c:out value="${ produit.nom }"/> </a></p>
					<p>Prix de vente: <c:out value=" ${ produit.montantVente }"/> </p>
					<p>Fournisseur: <c:out value="${ produit.fournisseur }"/> </p>         		 
          		 </div>
				 <div class="col-md-offset-6 col-md-2">

				 	 <a href="<c:url value="/monPanier">
				       			<c:param name="nomProduit" value="${ produit.nom }" />
				       		  </c:url>" 
				      >
				 		<button class="btn btn-primary"> <span class="glyphicon glyphicon-shopping-cart "></span> Ajouter au panier </button>
				 	</a>
				 </div>
					
		    	</div><br>
          	
          	</c:forEach>

      </div>

    </div>

    

 </body>
 </html>