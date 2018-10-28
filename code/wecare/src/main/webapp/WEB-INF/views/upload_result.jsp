<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<nav class="navbar navbar-default" role="navigation" style="margin-top:0; background-color:#A1CAF1">
			<ul class="nav navbar-nav" style="margin-left: 87%">
				<li><a href="/">weCare!</a></li>
				<li style="background-color: #FFBF00;"><a href="/logout">logout</a></li>
  			</ul>
		</nav>
	</div>
	<h3>Upload ${resultState}</h3>
	<c:if test="${resultState=='Failed'}">
		<h5>Reason: ${reason} </h5>
		<c:if test="${reason=='Errors exist'}">
			<table>
				<c:forEach items="${errors}" var="item">
					<tr>
						<td><c:out value="${item}" /></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</c:if>
</body>
</html>