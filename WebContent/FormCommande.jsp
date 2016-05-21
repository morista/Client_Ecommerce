
<!DOCTYPE html>
<html>
  <head>
 	 <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	<meta charset="utf-8"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
    <style>
      #nice {
        background-color: #DCDCDC;
        height: 50px;
      }
      .pousse {
        padding-left: 30px;
      }
    </style>
  </head>

    <body class="container">
    	<header>
    		
    		 <c:import url="/inc/menu.jsp" />
    	</header>
    	
       <section>
       
        <div>
            <form method="get" action="<c:url value="/creationCommande"/>">
                <fieldset>
                    <legend>Informations client</legend>
                    <c:import url="/inc/inc_client_form.jsp" />
                </fieldset>
                <fieldset>
                    <legend>Informations commande</legend>
                    
                    <label for="dateCommande">Date <span class="requis">*</span></label>
                    <input type="text" id="dateCommande" name="dateCommande" value="" size="30" maxlength="30" disabled />
                    <br />
                    
                    <label for="montantCommande">Montant <span class="requis">*</span></label>
                    <input type="text" id="montantCommande" name="montantCommande" value="" size="30" maxlength="30" />
                    <br />
                    
                    <label for="modePaiementCommande">Mode de paiement <span class="requis">*</span></label>
                    <input type="text" id="modePaiementCommande" name="modePaiementCommande" value="" size="30" maxlength="30" />
                    <br />
                    
                    <label for="statutPaiementCommande">Statut du paiement</label>
                    <input type="text" id="statutPaiementCommande" name="statutPaiementCommande" value="" size="30" maxlength="30" />
                    <br />
                    
                    <label for="modeLivraisonCommande">Mode de livraison <span class="requis">*</span></label>
                    <input type="text" id="modeLivraisonCommande" name="modeLivraisonCommande" value="" size="30" maxlength="30" />
                    <br />
                    
                    <label for="statutLivraisonCommande">Statut de la livraison</label>
                    <input type="text" id="statutLivraisonCommande" name="statutLivraisonCommande" value="" size="30" maxlength="30" />
                    <br />
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
       </section>
    </body>
</html>