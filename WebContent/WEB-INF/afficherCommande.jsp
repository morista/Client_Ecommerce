
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Affichage d'une commande</title>
        <link href="DOC/bootstrap.min.css" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
    </head>
    <body class="container">
    	<c:import url="/head.jsp"></c:import>
        <c:import url="/inc/menu.jsp" />
        <div id="corps">
            <p class="info">${ message }</p>
            <c:if test="${ !erreur }">
                <p>Client</p>
                <p>Nom : <c:out value="${ client.getNomClient() }"/></p>
                <p>Prénom : <c:out value="${ client.getPrenomClient() }"/></p>
                <p>Adresse : <c:out value="${ client.getAdresseClient() }"/></p>
                <p>Numéro de téléphone : <c:out value="${ client.getTelephoneClient() }"/></p>
                <p>Email : <c:out value="${ client.getEmailClient() }"/></p>
                <p>Commande</p>
                <p>Date  : <c:out value="${ commande.getDate() }"/></p> 
                <p>Montant  : <c:out value="${ commande.getMontantCommande() }"/></p> 
                <p>Mode de paiement  : <c:out value="${ commande.getModePaiement() }"/></p> 
                <p>Statut du paiement  : <c:out value="${ commande.getStatutPaiement() }"/></p> 
                <p>Mode de livraison  : <c:out value="${ commande.getModeLivraison() }"/></p> 
                <p>Statut de la livraison  : <c:out value="${ commande.getStatutLivraison() }"/></p> 
            </c:if>
        </div>
    </body>
</html>