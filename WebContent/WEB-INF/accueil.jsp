	
	<c:import url="/inc/head.jsp" />
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="page-header">
  				<h1>Bienvenu <br />
 					<small>Achat et vente en ligne parmi une multitude de produits en stock. Livraison gratuite a partir de 25 euros.</small>
				</h1>
			</div>
            <div class="row">
				<ul class="list-group">
					<c:forEach var="category" items="${ category }" varStatus="loop"> 
					
				   <a href="<c:url value="/produits"><c:param name="idCategory" value="${ category.id }" /></c:url>" style ="min-height:150px;" class="list-group-item col-md-3">
				      <h4 class="list-group-item-heading"><c:out value=" ${ category.nom }" /></h4>
				      <p class="list-group-item-text pull-right"><c:out value=" ${ category.description }" /></p>
				    </a>
					
					</c:forEach>
				</ul>
    		</div>
      </div> 

 </body>
 </html>