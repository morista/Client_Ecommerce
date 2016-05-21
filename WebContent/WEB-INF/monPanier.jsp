	
	<c:import url="/inc/head.jsp" />
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Panier</h1>
          	<p>${ requestScope.panier } </p>
 			<button btn btn-default>Commander</button>
			<p>p! ${ param.nomProduit } </p>
      </div>

    </div>

    

 </body>
 </html>