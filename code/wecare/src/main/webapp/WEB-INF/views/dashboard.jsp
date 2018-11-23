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
		       }, 1500);
		
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
			    <a class="navbar-brand" href="/">WeCare</a>
			  </div>
			  <form style="margin-left:85%;" class="navbar-form navbar-left">
			    <p><a class="btn btn-success" href="/logout" role="button">logout</a></p>
			  </form>
			</div>
                  </nav>
	    </div>
	    
	<h2 id = "state" style="color:#536872;"> ${state} </h2>
	
	<div class="jumbotron">
        <div class="container">
          <h1 class="display-3">Welcome ${loginUser.name}!</h1>
          <p> This platform allows agencies to serve new arrivals in the Scarborough area!</p>
          <p> Employer: ${loginUser.role}!</p>
        </div>
    </div>
    
	<!--<h2 id = "state" style="color:#536872;"> ${state} </h2>
	<h5 style="color:#536872"> Welcome ${loginUser.name}! </h5>
	<h5 style="color:#536872"> Employer: ${loginUser.role}! </h5> -->
		
	<c:choose>
	 <c:when test="${loginUser.role=='Agence'}">
	 <div class="container">
        <div class="row">
          <div class="col-md-4 col-md-offset-4">
            <h2>Uploading files</h2>
            <p> You can upload templates here.</p>
            <form method="post" enctype = "multipart/form-data" action="/upload">
				<div class="form-group" style="color: 808080">
					<label class="custom-file-label" for="file1">Select a file</label>
					<input type="file" class = "custom-file-input" id = "file1" name="file1">
					<button type="submit" class="btn btn-success">submit</button>
				</div>
			</form>
          </div>
        </div>

        <hr>

      </div>
      
	   <!--<div style="margin-left: 70%;">
		<form method="post" enctype = "multipart/form-data" action="/upload">
			<div class="form-group" style="color: 808080">
				<label for="email">Upload a file</label>
				<input style="width:200px;" type="file" class = "form-control" id = "file1" name="file1">
				<button type="submit" class="btn btn-default">submit</button>
			</div>
		</form>
	  </div>-->
	 </c:when>
	 <c:when test="${loginUser.role=='UTSC'}">
		<div style="margin-left: 70%;">
		  <h4 style="color:#536872">Welcome UTSC staff, this system provides you with all the data for analysis! </h4>
		</div>
	 </c:when>
	 <c:otherwise>
	       <div style="display:flex;flex-direction:row;margin-left:5%;">
	       <div>
	       <h2>Manage Users</h2>
	       <button id = "newaccount" class="btn btn-success" >+user</button>
	       </div>
		<div id = "reports" style="margin-left: 30%;">
		      <h2>Generate Reports</h2>
		       <div style="color:#536872">Welcome TEQ staff, manage agencies and generate reports here!</div>
		       
		       <form method="Get" action="/query">
			<div class="form-group" style="color: 808080">
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
				<!--<input type="submit" value="Submit">-->
				<button type="submit" class="btn btn-success">Submit</button>
				
			</div>
		      </form>
		       <h5 style="color:#536872"> ${my_results} </h5>
		</div>
		</div>
		<h1 style="color:#536872"> ${status.result} </h1>
		
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
			 <button id = "submit" type="submit" class="btn btn-success" formmethod="post">Create</button>
			 <a href="/dashboard">Cancel</a>
		   </form> 
		   
	 </c:otherwise>
	</c:choose>
		
		
	<div style="margin-top:20%">
	  <div class="container">
	      <div class="row">
		    <div class="col-md-4">
		      <h2>Uploading files</h2>
		      <p> The site helps agency staff to upload templates containing data for new arrivals. </p>
		    </div>
		    
		    <div class="col-md-4">
		      <h2>Generating reports</h2>
		      <p>The TEQ staff generates reports from the uploaded data.</p>
		    </div>
		    
		    <div class="col-md-4">
		      <h2>Data analysis</h2>
		      <p>A UTSC staff runs data analysis on existing data.</p>
		    </div>
		</div>
               <hr>
            </div> <!-- /container -->
         </div>
	  <footer class="container">
	    <p>&copy; WeCare 2018</p>
	  </footer>
  </body>
</html>
