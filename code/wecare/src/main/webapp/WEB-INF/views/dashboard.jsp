<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		
		<title>weCare</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		
		<script>
		$(document).ready(function(){
		    $("#newaccount").click(function(){
			$("#form1").css("display", "block");
			$("#reports").css("display", "none");
			$("#newaccount").css("display", "none");
		    });
		});
		
		$(document).ready(function(){
		    $("#submt").click(function(){
			$("#form1").css("display", "none");
		    });
		});
		</script>
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

		<h5 style="color:#536872"> Welcome ${loginUser.name}! </h5>
		<h5 style="color:#536872"> Employer: ${loginUser.role}! </h5>
		
	
		
		<c:choose>
		 <c:when test="${loginUser.role=='Agence'}">
		   <div style="margin-left: 70%;">
			<form method="post" enctype = "multipart/form-data" action="/upload">
				<div class="form-group" style="color: 808080">
					<label for="email">Upload a file</label>
					<input style="width:200px;" type="file" class = "form-control" id = "file1" name="file1">
					<button type="submit" class="btn btn-default">submit</button>
				</div>
			</form>
		  </div>
		 </c:when>
		 <c:when test="${loginUser.role=='UTSC'}">
			<div style="margin-left: 70%;">
			  <h4 style="color:#536872">Welcome UTSC staff, this system provides you with all the data for analysis! </h4>
			</div>
		 </c:when>
		 <c:otherwise>
		       <button id = "newaccount" class="btn btn-success" >add account</button>
		        
			<div id = "reports" style="margin-left: 70%;">
			       <h4 style="color:#536872">Welcome TEQ staff, you will manage agencies and generate reports here!</h4>
			       
			       <form method="Get" action="/query">
				<div class="form-group" style="color: 808080">
					<label for="email">Run queries </label>
					<br>
				    
					<select name="template">
						<option>NeedAssessRef</option>
						<option>Template 2</option>
						<option>Template 3</option>
						<option>Template 4</option>
                                         </select>
					 
					 <select name="query">
						<option>Select all</option>
						<option>Select all</option>
                                         </select>
					 <br> <br> <br>
                                        <input type="submit" value="Submit">
					
					
					<!--<button type="submit" class="btn btn-default">submit</button> -->
				</div>
			      </form>
			       <h5 style="color:#536872"> ${my_results} </h5>
			       
			</div>
			
			<form id = "form1" style ="margin-left:10%;display:none; width:600px;height:600px;" action="/newaccount">
				*Name:<br>
				<input style="width:400px;" type="text" name="firstname" placeholder="name" required>
				<br><br><br>
				*Email:<br>
				 <input style="width:400px;" type="email" name="email" placeholder="email" required>
				 <br><br><br>
				*Password:<br>
				 <input style="width:400px;" type="password" name="password" placeholder="password" required>
				 <br><br><br>
				 *Role:<br>
				<input style="width:400px;" type="text" name="role" placeholder="role" required>
				<br><br><br>
				Agency:<br>
				<input style="width:400px;" type="text" name="agency" placeholder="agency">
				<br><br><br>
				 <input  id = "submt" type="submit" value="Create" formmethod="post">
				 <a href="/dashboard">Cancel</a>
			   </form> 
			   
		 </c:otherwise>
		</c:choose>
		
	</body>
</html>
