	
	<c:import url="/inc/head.jsp" />
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Produits</h1>
          
          
                    		<table class="table table-inverse">
				  <thead>
				    <tr>
				      <th>Nom</th>
				      <th>Prix</th>
				      <th>Fournisseur</th>
				      <th>action</th>
				    </tr>
				  </thead>
				  <tbody>
			  		<c:forEach var="produit" items="${ ListProduit }">
					    <tr>
					      <td><c:out value="${ produit.nom }"/></td>
					      <td><c:out value="${ produit.montantVente }"/></td>
					      <td><c:out value="${ produit.fournisseur }"/></td>
					      <td>
   			          		 <form method="POST" action="<c:url value="/monPanier"/>">
			          		 	<input type="hidden" name="idP" value="${ produit.id }">
			          		 	<input class="btn btn-primary" type="submit" value="Ajouter au panier">
			          		 </form>
					      </td>
					    </tr>
				   	</c:forEach>
				  </tbody>
				</table>

      </div>

    </div>

    

 </body>
 </html>