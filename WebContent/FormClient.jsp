<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'un client</title>
        <link href="DOC/bootstrap.min.css" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
    </head>
    <body class="container">
    	<c:import url="/head.jsp"></c:import>
        <c:import url="/inc/menu.jsp" />
        <div>
            <form method="get" action="<c:url value="/creationClient"/>" class="well">
                <fieldset>
                    <legend>Informations client</legend>
                    <c:import url="/inc/inc_client_form.jsp" />
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>