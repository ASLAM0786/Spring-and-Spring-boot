<html>
	<head>
		<title> Login Page - JSP</title>
	</head>
	<body>
	    <div class = "container">
	        <h1>Login </h1>
	        <pre>${errorMessage}</pre>
            <form method = "POST">
            Name:<input type = "text" name = "name" />
            Password:<input type = "password" name = "password" />
            <input type="Submit">
            </form>
        </div>
	</body>
</html>