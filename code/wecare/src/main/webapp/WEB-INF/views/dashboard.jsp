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
		   setTimeout(function() {
		       //document.getElementById("state").innerHTML = "";
		       $('#state').fadeOut();
		       }, 3000);
		
		    $("#submt").click(function(){
			$("#form1").css("display", "none");
			$("#reports").css("display", "none");
			$("#newaccount").css("display", "none");
			
		    });
		});
		</script>
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
	  
	<c:choose>  
		<c:when test="${loginUser.role!='Agency'}">
			<center>
				<h2 id = "state" style="color:#0c5460;background-color: #d1ecf1;"> ${state} </h2>
			</center>
		</c:when>
	</c:choose>  
	
	<div class="jumbotron">
        <div class="container">
          <h1 class="display-3">Welcome ${loginUser.name}!</h1>
          <p> This platform allows agencies to serve new arrivals in the Scarborough area!</p>
          <p> Employer: ${loginUser.role}!</p>
        </div>
    </div>
		
	<c:choose>
	<c:when test="${loginUser.role=='Agency'}">
	 	<div class="container">
        	<div class="row">
          		<div class="col-md-8">
            		<h2>Uploading files</h2>
            		<p> You can upload templates here.</p>
            		<form method="post" enctype = "multipart/form-data" action="/upload">
						<div class="form-group" style="color: 808080">
							<label class="custom-file-label" for="file1">Select a file</label>
							<input type="file" class="custom-file-input" id="file1" name="file1">
							<br>
							<button type="submit" class="btn btn-success">submit</button>
						</div>
					</form>
          		</div>
        	</div>
        </div>
	 </c:when>
	 <c:otherwise>
	 	<div class="container">
	 	<div class="row justify-content-md-center">
	 		<div class="col-md-4">
	 			<h2>Manage Users</h2>
	 			<button id = "newaccount" class="btn btn-success" >+user</button>
	 		</div>
			<div id = "reports" class="col-md-8">
				<h2>Generate Reports</h2>
		   		<form class="form-inline" method="Get" action="/query">
						<label for="email">Run queries </label>
						<br>
						<select name="template">
							<option>Select</option>
							<option>NeedAssessRef</option>
							<option>Template 2</option>
							<option>Template 3</option>
							<option>Template 4</option>
						</select>
						<select name="query">
							<option>Select all</option>
							<option>Select * WHERE serviceLanguage = English</option>
							<option>Select * WHERE startDate = 2018 </option>
							<option>Select * WHERE endDate   = 2018 </option>
						</select>
						<br> <br>
						<button type="submit" class="btn btn-success">Submit</button>
				</form>
		    	<h5 style="color:#536872"> ${my_results} </h5>
			</div>
		</div>
		</div>
		<h1 style="color:#536872"> ${status.result} </h1>
		
		<form id = "form1" style ="margin-left:19%;display:none; width:600px;height:600px;" action="/newaccount">
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
			<!--<input style="width:400px;" type="text" name="role" placeholder="role" required>-->
			 <select name="role">
			 	<option>Agency</option>
				<option>TEQ</option>
				<option>UTSC</option>
			 </select>
			<br><br><br>
			Agency:<br>
			<input style="width:400px;" type="text" name="agency" placeholder="agency">
			<br><br><br>
			 <button id = "submit" type="submit" class="btn btn-success" formmethod="post">Create</button>
			 <a href="/dashboard">Cancel</a>
		   </form>
		   
	 </c:otherwise>
	</c:choose>

	  <footer class="container">
	    <p>&copy; WeCare 2018</p>
	  </footer>
  </body>
</html>
