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
		<div class="panel-heading"> Recherche des articles</div>
		<div class="panel-body">
		
			<form action="chercher.do" method="get">
				<label>Mot clé : </label>
				<input type="text" name="motCle" value="${model.motCle}"/>
				<button type="submit" class="btn btn-primary">Chercher</button>
			</form>
			
			<table class="table table-striped">
				<tr>
					<th>ID article</th><th>Désignation</th><th>Prix</th><th>Quantité</th>
				</tr>
				<c:forEach items="${model.articles}" var="a">
					<tr>
						<td>${a.idArticle}</td>
						<td>${a.designation}</td>
						<td>${a.prix}</td>
						<td>${a.quantite}</td>
						<td><a onclick="return confirm('êtes vous sûre de vouloir supprimer?')" href="supprimerArticle.do?id=${a.idArticle}">Supprimer</a></td>
						<td><a href="editerArticle.do?id=${a.idArticle}">Editer</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
</body>
</html>