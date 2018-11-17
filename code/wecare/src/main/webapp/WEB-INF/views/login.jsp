<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!--
<!DOCTYPE html>
<html>
<head>
	<title>weCare</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<style type="text/css">
	
	</style>
</head>
<body>
	<div class="nav">
  <nav class="navbar navbar-default" role="navigation" style="margin-top:0; background-color:#A1CAF1;">
  	<ul class="nav navbar-nav" style="margin-left: 10%">
  		<li><a href="/">weCare!</a></li>
  	</ul>
  </nav>
	</div>
	<div style="margin-left: 10%;">
		<form:form action="/login" modelAttribute="loginUser">
			<div class="form-group" style="margin-right: 50%;color: 808080">
				<label for="email">Email</label>
				<form:input type="email" class = "form-control" id = "email" name="email" path="email" placeholder="Email address"/>
				<label for="password">Password</label>
				<form:input type="password" class = "form-control" id = "password" name="password" path="password" placeholder="password"/>
				<input type="submit" value="submit" class="btn btn-default"/>
			</div>
			
		</form:form>

	</div>

</body>
</html>

-->
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS 
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- Custom styles for this template -->
    <link href="https://getbootstrap.com/docs/4.1/examples/sign-in/signin.css" rel="stylesheet">
  </head>
  
  <body class="text-center">
    
    <form:form action="/login" modelAttribute="loginUser" class="form-signin">
    <div>
        
	<h1 style = "background-color:#8A2BE2;color:white;" width="72" height="72">WeCare</h1>
	<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
				<label for="email" class="sr-only">Email address</label>
				<form:input type="email" class = "form-control" id = "email" name="email" path="email" placeholder="Email address"/>
			
				<form:input type="password" class = "form-control" id = "password" name="password" path="password" placeholder="password"/>
				
				<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
			</div>
			<p class="mt-5 mb-3 text-muted">&copy; WeCare 2018</p>
			
		</form:form>
  </body>
</html>