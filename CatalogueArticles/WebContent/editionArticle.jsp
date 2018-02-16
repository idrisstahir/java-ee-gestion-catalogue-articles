<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Articles</title>
	<link rel="Stylesheet" type="text/css" href="css/bootstrap.min.css"/>
</head>
<body>

<div class="container col-md-8 col-md-offset-2">
<%@include file="entete.jsp" %>
	<div class="panel panel-primary">
		<div class="panel-heading"> Saisie d'un article</div>
		<div class="panel-body">
		
			<form action="updateArticle.do" method="post">
				<div class="form-group">
					<label class=control-label>ID article: </label>
					<input type="hidden" name="id" value="${article.idArticle}" class="form-control" required="required"/>
					<label>${article.idArticle}</label>
					<span></span>
				</div>
				<div class="form-group">
					<label class=control-label>Désignation</label>
					<input type="text" name="designation" value="${article.designation}" class="form-control" required="required"/>
				</div>
				<div class="form-group">
					<label class=control-label>Prix</label>
					<input type="text" name="prix" value="${article.prix}" class="form-control"/>
				</div>
				<div class="form-group">
					<label class=control-label>Quantité</label>
					<input type="text" name="quantite" value="${article.quantite}" class="form-control"/>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary" >Save</button>
				</div>
			</form>
			
		</div>
	</div>
</div>
</body>
</html>