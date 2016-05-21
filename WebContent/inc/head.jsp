<!DOCTYPE html>
<html>
  <head>
     <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	<meta charset="utf-8"/>
    <link href="<c:url value="/inc/tut.css"/>" rel="stylesheet">>
  </head>
  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="accueil">E-COMMERCE</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
           <li> <a href="<c:url value="/connexion"/>"><span class="glyphicon glyphicon-user"></span>  Connecter </a> </li>
          <li> <a href="<c:url value="/monPanier"/>"><span class="glyphicon glyphicon-shopping-cart"></span>  Panier </a> </li>
          <li> <a href="#" ><span class="glyphicon glyphicon-bullhorn"></span>  Besoin d'aide</a> </li>
          
          </ul>
            <form role="form" class="navbar-form navbar-right">
              <div class="input-group ">
                <div class="input-group-btn ">
                  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"> Produit 
                    <span class="caret"></span>
                  </button>
                  <ul class="dropdown-menu">
                      <li class="list-group-item">
                        <span class="badge">22</span>
                        Item 1
                      </li>
                      <li class="list-group-item">
                        <span class="badge">12</span>
                        Item 2
                      </li>
                      <li class="list-group-item">
                        <span class="badge">33</span>
                        Item 3 
                      </li>
                      <li class="list-group-item">
                        <span class="badge">87</span>
                        Item 4
                      </li>
                  </ul>
                </div>
              <input type="text" class="form-control" >
              </div>
          </form>

        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar list-group">
          
            <li class="list-group-item"><a href="#">Informatique</a></li>
            <li class="list-group-item"><a href="#">Cuisine</a></li>
            <li class="list-group-item"><a href="#">Electroménager</a></li>
            <li class="list-group-item"><a href="">Automobile</a></li>
            <li class="list-group-item"><a href="">Smartphone</a></li>
            <li class="list-group-item"><a href="">Tablette</a></li>
            <li class="list-group-item"><a href="">Loisir</a></li>
            <li class="list-group-item"><a href="">Vetement</a></li>
            <li class="list-group-item"><a href="">Nada</a></li>
            <li class="list-group-item"><a href="">More navigation</a></li>
       
          </ul>
        </div>