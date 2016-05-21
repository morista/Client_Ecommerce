<!DOCTYPE html>

<html>
  <head>
     <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	<meta charset="utf-8"/>
    <link href="<c:url value="/inc/connexion.css"/>" rel="stylesheet">
  </head>
    <body>
    	<div class="container">
        <form method="post" action="connexion" class="form-signin">
            <h2 class="form-signin-heading">Connectez vous !</h2>

                <label for="nom" class="sr-only">Login: <span class="requis">*</span></label>
                <input type="text" id="email" class="form-control" name="login" value="<c:out value="${param.login}"/>" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['email']}</span>
                <br />

                <label for="motdepasse" class="sr-only">Mot de passe: <span class="requis">*</span></label>
                <input type="password" id="motdepasse" class="form-control" name="motdepasse" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['motdepasse']}</span>
                <a href="" class="help-block">Pas encore membre ? </a>
                <br />

                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>

        </form>
        </div>
        
    </body>
</html>