<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> 
	<style>
		body {
		  padding-top: 5rem;
		}
		.starter-template {
		  padding: 3rem 1.5rem;
		  text-align: center;
		}
	</style>
</head>
<body>
	<div class="container">
		<h1 class="h3 mb-3 font-weight-normal">Bienvenue</h1>
		
	 	<form:form action="qcm" modelAttribute="qcm" method="POST">
			<p>Choisir un domaine:</p>
			<form:select path="domaine" class="form-control form-control-lg">
			
				<c:forEach var="domaine" items="${domaines}">
					<form:option value="${domaine}"></form:option>
				</c:forEach>
				
			</form:select>
			
			<br>
			<p>Choisir la mode:</p>
			<form:select path="mode" class="form-control form-control-lg">
				<form:option value="Exercice"></form:option>
				<form:option value="Examen"></form:option>
			</form:select>
			
			<br><br>
				<input type="submit" value="commencer" class="save" class="btn btn-lg btn-primary btn-block"/>
			<br>
			<p class="mt-5 mb-3 text-muted">&copy; 2020</p>
		</form:form>
	</div>
</body>
</html>