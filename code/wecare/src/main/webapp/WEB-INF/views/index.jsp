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
		body {}
		a {font-size: 16px;text-decoration:none;}
		a:hover {text-decoration:underline;}
		li:hover {color:red;}
	</style>
</head>
<body>
	<div class="nav">
		<nav class="navbar navbar-default" role="navigation" style="margin-top:0; background-color:#A1CAF1">
  			<ul class="nav navbar-nav" style="margin-left: 82%">
  				<li><a href="/">weCare!</a></li>
  				<li><a href="/login">login</a></li>
  			</ul>
		</nav>
	</div>
	<div style="margin-left: 10%;">
		Welcome to weCare system! Sign in to upload files or generate reports.
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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <title>Jumbotron Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- Custom styles for this template -->
    <link href="https://getbootstrap.com/docs/4.1/examples/jumbotron/jumbotron.css" rel="stylesheet">
  </head>

  <body>

    <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WeCare</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#"></a></li>
      <li><a href="#"></a></li>
      <li><a href="#"></a></li>
    </ul>
    <form style="margin-left:50%;" class="navbar-form navbar-left" action="/action_page.php">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search" name="search">
      </div>
      <button type="submit" class="btn btn-success">Search</button>
    </form>
  </div>
</nav>

    <main role="main">

      <!-- Main jumbotron for a primary marketing message or call to action -->
      <div class="jumbotron">
        <div class="container">
          <h1 class="display-3">Welcome to WeCare system!</h1>
          <p> This platform allows agencies to serve new arrivals in the Scarborough area!</p>
          <p><a class="btn btn-success" href="/login" role="button">login here &raquo;</a></p>
        </div>
      </div>

      <div class="container">
        <!-- Example row of columns -->
        <div class="row">
          <div class="col-md-4">
            <h2>Uploading files</h2>
            <p> The site helps agency staff to upload templates containing data for new arrivals... </p>
         
          </div>
          <div class="col-md-4">
            <h2>Generating reports</h2>
            <p>The TEQ staff generates reports from the uploaded data ...</p>
            
          </div>
          <div class="col-md-4">
            <h2>Data analysis</h2>
            <p>A UTSC staff runs data analysis on existing data to ...</p>
            
          </div>
        </div>

        <hr>

      </div> <!-- /container -->

    </main>

    <footer class="container">
      <p>&copy; WeCare 2018</p>
    </footer>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="https://getbootstrap.com/docs/4.1/assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="https://getbootstrap.com/docs/4.1/assets/js/vendor/popper.min.js"></script>
    <script src="https://getbootstrap.com/docs/4.1/dist/js/bootstrap.min.js"></script>
  </body>
</html>
