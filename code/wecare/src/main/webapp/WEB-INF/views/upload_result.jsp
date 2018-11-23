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
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="/dashboard">WeCare</a>
				</div>
				<form style="margin-left:85%;" class="navbar-form navbar-left">
			    	<p><a class="btn btn-success" href="/logout" role="button">logout</a></p>
			  	</form>
			</div>
        </nav>
    </div>
    
    
    <div class="jumbotron">
        <div class="container">
        	<h1 class="display-3">Upload ${resultState}</h1>
        		<c:if test="${resultState=='Failed'}">
        			<h3>Reason: ${reason} </h3>
        			<c:if test="${reason=='Errors exist'}">
        				<table class="table table-striped">
        					<c:forEach items="${errors}" var="item">
								<tr>
									<td><c:out value="${item}" /></td>
								</tr>
							</c:forEach>
						</table>
					</c:if>
				</c:if>
        </div>
    </div>
    
    <footer class="container">
    	<p>&copy; WeCare 2018</p>
	</footer>
</body>
</html>