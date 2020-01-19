<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<style>
		body {
		  padding-top: 5rem;
		}
		.starter-template {
		  padding: 3rem 1.5rem;
		  text-align: center;
		}
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> 
</head>
<body>
	<div class="container text-center">
	
		<c:if test="${score > 4}">
			<p>Tu as réussi ton test.</p>
		</c:if>
		<c:if test="${score < 5}">
			<p>Malheureusement tu as pas réussi ton test.</p>
		</c:if>
		
		<p>Tu as eu un score de ${score}.</p>
	
		<h1>à la prochaine!</h1>
	</div>
</body>
</html>