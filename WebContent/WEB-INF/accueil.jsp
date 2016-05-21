	
	<c:import url="/inc/head.jsp" />
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Produits</h1>
          
              <div class="row">
		    	<ul class="list-group">
		    		<c:forEach var="category" items="${ category }"> 
				      <a href="<c:url value="/produits">
				       				<c:param name="idCategory" value="${ category.id }" />
				       		   </c:url>" class="list-group-item col-md-3"
				      >
				         <h4 class="list-group-item-heading"><c:out value=" ${ category.nom }" /></h4>
				         <p class="list-group-item-text pull-right"><c:out value=" ${ category.description }" /></p>
				         <img src="images/t1.jpg">
				       </a>
					</c:forEach>
		    		
		    	</ul>
		    </div>
      </div>

    </div>

    

 </body>
 </html>