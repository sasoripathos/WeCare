<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
    <head>

        <title>weCare</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

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
                <a style="color:#536872;margin-left: 50%;" href="/src/main/java/com/newcomer/controller/report.csv" download> Download report</a>
                <div style="margin-left: 70%;">
                    <h4 style="color:#536872">Welcome TEQ staff, you will manage agencies and generate reports here!</h4>

                    <form method="Get" action="/query">
                        <div class="form-group" style="color: 808080">
                            <label for="email">Run queries </label>
                            <input style="width:200px;" type="String" class = "form-control" id = "query" name="query">
                            <button type="submit" class="btn btn-default">submit</button>
                        </div>
                    </form>
                    
                    <h5 style="color:#536872;margin-left: 5%;"> ${my_results} </h5>
                    


                </div>
            </c:otherwise>
        </c:choose>

    </body>
</html>