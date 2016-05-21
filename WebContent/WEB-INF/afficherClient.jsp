
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Affichage d'un client</title>
        <link href="DOC/bootstrap.min.css" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
    </head>
    <body class="container">
    	<c:import url="/head.jsp"></c:import>
        <c:import url="/inc/menu.jsp" />
        <div id="corps">
            <p class="info">${ message }</p>
            <c:if test="${ !erreur }">
                <p>Nom : <c:out value="${ client.nom }"/></p>
                <p>Prénom : <c:out value="${ client.prenom }"/></p>
                <p>Adresse : <c:out value="${ client.adresse }"/></p>
                <p>Numéro de téléphone : <c:out value="${ client.telephone }"/></p>
                <p>Email : <c:out value="${ client.email }"/></p>
            </c:if>
        </div>
    </body>
</html>