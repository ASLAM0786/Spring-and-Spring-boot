<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
		<title>List Todos Page</title>
	</head>
	<body>
		<div class="container">
			<h1>Add  Todos Page</h1>
			<form method = "POST">
			 Description:<input type = "text" name = "description" required= "required"/>
			 <input type = "submit" class = "btn btn-success"/>
			</form>
		</div>
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>

	</body>
</html>