
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <title>Login page</title>
    <link href = "bootstrap/css/bootstrap.css" rel = "stylesheet" type="text/css">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="bootstrap/css/signin.css" rel="stylesheet" type="text/css">
    <!-- for including headers -->
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script>
        $(function(){
            $("#header").load("header.html");
        });
    </script>
</head>
<body>
<div id="header"></div>

<main class="form-signin">
<%--    sign in form    --%>
    <h2 class="h3 mb-3 fw-normal"> Sign in </h2>
    <form action="Login" method="post">
        <label for="user_id" class="h3 mb-3 fw-normal">User ID:</label>
        <div class="form-floating">
        <input type="text" class="form-control" id="user_id" name="user_id" placeholder="ID" required><br>
        </div>
        <label for="pass" class="h3 mb-3 fw-normal">Password:</label>
        <div class="form-floating">
            <input type="password" class="form-control" id="pass" name="pass" placeholder="password" required><br>
        </div>
        <input class="w-100 btn btn-lg btn-primary" type="submit" value="login">
        <a href="signup.jsp">Register a manager</a><br>
        <a href="forgot.jsp">Forgot Password</a><br>
        <a href="change.jsp">Change Password</a>
    </form>
<%--back button--%>
    <div style="text-align:right">
        <p><a href="index.jsp">Back</a> </p>
    </div>
</main>
</body>
</html>
