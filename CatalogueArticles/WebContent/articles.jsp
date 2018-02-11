<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Articles</title>
	<link rel="Stylesheet" type="text/css" href="css/bootstrap.min.css"/>
</head>
<body>
<%@include file="entete.jsp" %>
<div class="container col-md-10 col-md-offset-1">
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
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
</body>
</html>