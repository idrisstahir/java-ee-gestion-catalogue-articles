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
<div class="container col-md-8 col-md-offset-2">
	<div class="panel panel-primary">
		<div class="panel-heading">Confirmation</div>
		<div class="panel-body">
		
			<div class="form-group">
				<label>ID:</label>
				<label>${article.idArticle}</label>
			</div>
			<div class="form-group">
				<label>Désignation:</label>
				<label>${article.designation}</label>
			</div>
			<div class="form-group">
				<label>Prix:</label>
				<label>${article.prix}</label>
			</div>
			<div class="form-group">
				<label>Quantité:</label>
				<label>${article.quantite}</label>
			</div>
			
		</div>
	</div>
</div>
</body>
</html>