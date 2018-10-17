<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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